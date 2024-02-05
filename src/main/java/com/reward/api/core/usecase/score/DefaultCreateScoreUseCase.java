package com.reward.api.core.usecase.score;

import com.reward.api.core.domain.level.LevelScoreCalculate;
import com.reward.api.core.domain.score.ScoreBanking;
import com.reward.api.core.domain.score.TypeOperation;
import com.reward.api.core.domain.transaction.TypeTransaction;
import com.reward.api.core.exception.DomainException;
import com.reward.api.core.gateway.ScoreBankingGateway;
import com.reward.api.core.usecase.customer.common.CustomerOutputData;
import com.reward.api.core.usecase.customer.edit.EditCustomerCommand;
import com.reward.api.core.usecase.customer.edit.EditCustomerUseCase;
import com.reward.api.core.usecase.customer.retrieve.FindCustomerCommand;
import com.reward.api.core.usecase.customer.retrieve.FindCustomerUseCase;
import com.reward.api.core.usecase.transaction.common.BankTransactionOutput;
import com.reward.api.core.usecase.transaction.retrieve.FindByIDBankTransactionCommand;
import com.reward.api.core.usecase.transaction.retrieve.FindByIDBankTransactionUseCase;
import jakarta.inject.Inject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class DefaultCreateScoreUseCase extends CreateScoreUseCase {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private final FindCustomerUseCase findCustomerUseCase;

    private final FindByIDBankTransactionUseCase findByIDBankTransactionUseCase;

    private final ScoreBankingGateway scoreBankingGateway;

    private final EditCustomerUseCase editCustomerUseCase;

    @Inject
    public DefaultCreateScoreUseCase(FindCustomerUseCase findCustomerUseCase, FindByIDBankTransactionUseCase findByIDBankTransactionUseCase, ScoreBankingGateway scoreBankingGateway, EditCustomerUseCase editCustomerUseCase) {
        this.findCustomerUseCase = findCustomerUseCase;
        this.findByIDBankTransactionUseCase = findByIDBankTransactionUseCase;
        this.scoreBankingGateway = scoreBankingGateway;
        this.editCustomerUseCase = editCustomerUseCase;
    }

    @Override
    public CreateScoreBankingOutput execute(CreateScoreBankingCommand createScoreBankingCommand) {
        CustomerOutputData customer = findCustomerUseCase.execute(FindCustomerCommand.with(createScoreBankingCommand.cpf()));
        BankTransactionOutput bankTransactionOutput = findByIDBankTransactionUseCase.execute(FindByIDBankTransactionCommand.with(createScoreBankingCommand.transactionId()));

        if (isUnder18YearsOld(customer.getDateBirth())) {
            editCustomerUseCase.execute(EditCustomerCommand.with(
                    customer.getId(), customer.getName(), customer.getCpf(), customer.getEmail(), customer.getDateBirth(), 0
            ));
            return createZeroScoreBankingOutput(customer.getId(), createScoreBankingCommand.origin());
        }

        Integer computedScore = computeScore(createScoreBankingCommand.level(), bankTransactionOutput.amount());

        Integer currentScore = customer.getCurrentScore() != null ? customer.getCurrentScore() : 0;

        editCustomerUseCase.execute(EditCustomerCommand.with(
                customer.getId(), customer.getName(), customer.getCpf(), customer.getEmail(), customer.getDateBirth(), currentScore+computedScore
        ));

        return CreateScoreBankingOutput.from(scoreBankingGateway.create(ScoreBanking.of(
                computedScore,
                customer.getId(),
                createScoreBankingCommand.origin(),
                TypeOperation.SUM)));
    }

    private CreateScoreBankingOutput createZeroScoreBankingOutput(UUID customerId, String origin) {
        return CreateScoreBankingOutput.from(scoreBankingGateway.create(ScoreBanking.of(0, customerId, origin, TypeOperation.SUM)));
    }

    private Integer computeScore(String level, double originalScore) {
        LevelScoreCalculate levelScoreCalculate = LevelScoreCalculate.valueOf(level);

        switch (levelScoreCalculate) {
            case LEVEL_ONE:
            case LEVEL_TWO:
            case LEVEL_THREE:
                return levelScoreCalculate.compute(originalScore);
            default:
                throw new DomainException("Error score calculate");
        }
    }


    private static boolean isUnder18YearsOld(String dateOfBirth) {
        try {
            Date birthDate = dateFormat.parse(dateOfBirth);
            Date currentDate = new Date();

            long timeDifference = currentDate.getTime() - birthDate.getTime();
            long ageInMilliseconds = 18L * 365 * 24 * 60 * 60 * 1000;

            return timeDifference < ageInMilliseconds;
        } catch (ParseException e) {
            // Handle the exception if the date format is incorrect
            e.printStackTrace();
            return false;
        }
    }

}

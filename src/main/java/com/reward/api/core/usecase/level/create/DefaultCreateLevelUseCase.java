package com.reward.api.core.usecase.level.create;

import com.reward.api.core.domain.level.LevelScore;
import com.reward.api.core.gateway.LevelScoreGateway;
import com.reward.api.core.usecase.customer.common.CustomerOutputData;
import com.reward.api.core.usecase.customer.retrieve.FindCustomerCommand;
import com.reward.api.core.usecase.customer.retrieve.FindCustomerUseCase;
import com.reward.api.core.usecase.level.common.LevelOutputData;
import com.reward.api.core.usecase.score.common.CreateScoreLevelCommand;
import com.reward.api.core.usecase.transaction.common.BankTransactionOutput;
import com.reward.api.core.usecase.transaction.retrieve.FindBankTransactionCommand;
import com.reward.api.core.usecase.transaction.retrieve.FindBankTransactionUseCase;
import jakarta.inject.Inject;

import java.util.List;

public class DefaultCreateLevelUseCase extends CreateLevelUseCase {

    private final LevelScoreGateway levelScoreGateway;
    private final FindCustomerUseCase findCustomerUseCase;
    private final FindBankTransactionUseCase findBankTransactionUseCase;

    @Inject
    public DefaultCreateLevelUseCase(LevelScoreGateway levelScoreGateway, FindCustomerUseCase findCustomerUseCase, FindBankTransactionUseCase findBankTransactionUseCase) {
        this.levelScoreGateway = levelScoreGateway;
        this.findCustomerUseCase = findCustomerUseCase;
        this.findBankTransactionUseCase = findBankTransactionUseCase;
    }

    @Override
    public LevelOutputData execute(CreateScoreLevelCommand createLevelCommand) {
        CustomerOutputData customer =
                findCustomerUseCase.execute(FindCustomerCommand.with(createLevelCommand.cpf()));
        List<BankTransactionOutput> transactions =
                findBankTransactionUseCase.execute(FindBankTransactionCommand.with(customer.getId()));

        return LevelOutputData.from(
                levelScoreGateway.create(LevelScore.of(sumAmount(transactions), customer.getId()))
        );
    }

    private static Double sumAmount(List<BankTransactionOutput> transactions) {
        if(transactions.isEmpty())
            throw new IllegalArgumentException("The list cannot be null or empty.");

        return transactions.stream().
                mapToDouble(BankTransactionOutput::amount).sum();

    }

}

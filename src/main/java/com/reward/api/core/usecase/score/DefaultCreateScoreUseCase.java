package com.reward.api.core.usecase.score;

import com.reward.api.core.domain.score.ScoreBanking;
import com.reward.api.core.domain.score.TypeOperation;
import com.reward.api.core.gateway.ScoreBankingGateway;
import jakarta.inject.Inject;

public class DefaultCreateScoreUseCase extends CreateScoreUseCase {

    private final ScoreBankingGateway scoreBankingGateway;

    @Inject
    public DefaultCreateScoreUseCase(ScoreBankingGateway scoreBankingGateway) {
        this.scoreBankingGateway = scoreBankingGateway;
    }

    @Override
    public CreateScoreBankingOutput execute(CreateScoreBankingCommand createScoreBankingCommand) {
        var score = ScoreBanking.of(createScoreBankingCommand.score(),
                createScoreBankingCommand.customerId(),
                createScoreBankingCommand.origin(),
                TypeOperation.SUM);
        return CreateScoreBankingOutput.from(scoreBankingGateway.create(score));
    }
}

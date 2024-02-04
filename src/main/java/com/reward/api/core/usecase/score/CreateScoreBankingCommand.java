package com.reward.api.core.usecase.score;

import java.util.UUID;

public record CreateScoreBankingCommand(Integer score, UUID customerId, String origin) {

    public static CreateScoreBankingCommand with(Integer score, UUID customerId, String origin) {
        return new CreateScoreBankingCommand(score, customerId, origin);
    }
}

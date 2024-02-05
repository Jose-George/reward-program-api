package com.reward.api.core.usecase.score;

import java.util.UUID;

public record CreateScoreBankingCommand(String cpf, String origin, UUID transactionId, String level) {

    public static CreateScoreBankingCommand with(String cpf, String origin, UUID transactionId, String level) {
        return new CreateScoreBankingCommand(cpf, origin, transactionId, level);
    }
}

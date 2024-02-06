package com.reward.api.core.usecase.score.common;

public record CreateScoreLevelCommand(String cpf) {

    public static CreateScoreLevelCommand with(String cpf) {
        return new CreateScoreLevelCommand(cpf);
    }
}

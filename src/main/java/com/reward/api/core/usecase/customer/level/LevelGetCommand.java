package com.reward.api.core.usecase.customer.level;

public record LevelGetCommand(String cpf) {

    public static LevelGetCommand with(String cpf) {
        return new LevelGetCommand(cpf);
    }

}

package com.reward.api.core.usecase.level.common;

import java.util.UUID;

public record CreateLevelCommand(String cpf) {

    public static CreateLevelCommand with(String cpf) {
        return new CreateLevelCommand(cpf);
    }
}

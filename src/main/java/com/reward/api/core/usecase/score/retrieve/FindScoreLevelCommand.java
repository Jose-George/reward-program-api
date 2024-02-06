package com.reward.api.core.usecase.score.retrieve;

import java.util.UUID;

public record FindScoreLevelCommand(UUID customerId) {

    public static FindScoreLevelCommand with(UUID customerId) {
        return new FindScoreLevelCommand(customerId);
    }
}

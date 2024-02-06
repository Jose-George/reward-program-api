package com.reward.api.core.usecase.customer.level;

public record LevelGetOutput(String level, Integer score) {

    public static LevelGetOutput with(String level, Integer score) {
        return new LevelGetOutput(level, score);
    }

}

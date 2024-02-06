package com.reward.api.core.usecase.score.common;

public record ScoreDataOutput(String description) {

    public static ScoreDataOutput with(String description) {
        return new ScoreDataOutput(description);
    }

}

package com.reward.api.core.domain.level;

public final class LevelScoreOne {
    private final static Double PERCENTAGE = 10.0;

    public static Integer score(Double value) {
        return (int) Math.floor(value * (PERCENTAGE / 100));
    }

}

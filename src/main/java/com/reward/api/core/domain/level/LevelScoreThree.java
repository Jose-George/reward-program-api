package com.reward.api.core.domain.level;

public class LevelScoreThree {

    private final static Double PERCENTAGE = 20.0;

    static Integer score(Double value) {
        return (int) Math.floor(value * (PERCENTAGE / 100));
    }
}

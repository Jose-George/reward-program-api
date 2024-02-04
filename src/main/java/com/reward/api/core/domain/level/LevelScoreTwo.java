package com.reward.api.core.domain.level;

public class LevelScoreTwo {

    private final static Double PERCENTAGE = 15.0;

    static Integer score(Double value) {
        return (int) Math.floor(value * (PERCENTAGE/ 100));
    }
}

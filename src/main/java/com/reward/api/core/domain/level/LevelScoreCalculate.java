package com.reward.api.core.domain.level;

import java.util.function.DoubleFunction;

public enum LevelScoreCalculate {
    LEVEL_ONE(LevelScoreOne::score),
    LEVEL_TWO(LevelScoreTwo::score),
    LEVEL_THREE (LevelScoreThree::score);

    private final DoubleFunction levelScore;


    LevelScoreCalculate(DoubleFunction<Integer> levelScore) {
        this.levelScore = levelScore;
    }

    public Integer compute(Double value) {
        return (Integer) levelScore.apply(value);
    }

}

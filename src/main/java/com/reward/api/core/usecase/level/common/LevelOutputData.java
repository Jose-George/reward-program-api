package com.reward.api.core.usecase.level.common;

import com.reward.api.core.domain.level.LevelScore;

import java.util.UUID;

public class LevelOutputData {

    private final UUID id;

    private final String level;


    private LevelOutputData(UUID id, String level) {
        this.id = id;
        this.level = level;
    }

    public static LevelOutputData from(LevelScore level) {
        return new LevelOutputData(level.getId(), level.getDescription());
    }

    public static LevelOutputData from(String level) {
        return new LevelOutputData(null, level);
    }

    public UUID getId() {
        return id;
    }

    public String getLevel() {
        return level;
    }

}

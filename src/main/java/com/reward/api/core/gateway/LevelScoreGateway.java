package com.reward.api.core.gateway;

import com.reward.api.core.domain.level.LevelScore;

import java.util.Optional;
import java.util.UUID;

public interface LevelScoreGateway {

    LevelScore create(LevelScore levelScore);
    LevelScore edit(LevelScore levelScore);
    Optional<LevelScore> findByCustomerId(UUID id);
    void delete(UUID id);

}
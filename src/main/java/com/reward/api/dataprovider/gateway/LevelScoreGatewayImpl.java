package com.reward.api.dataprovider.gateway;

import com.reward.api.core.domain.level.LevelScore;
import com.reward.api.core.gateway.LevelScoreGateway;
import com.reward.api.dataprovider.entity.LevelScoreEntity;
import com.reward.api.dataprovider.repository.LevelScoreRepository;
import jakarta.inject.Inject;

import java.util.Optional;
import java.util.UUID;

public class LevelScoreGatewayImpl implements LevelScoreGateway {

    private final LevelScoreRepository repository;

    @Inject
    public LevelScoreGatewayImpl(LevelScoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public LevelScore create(LevelScore levelScore) {
        repository.save(builderLevelScore(levelScore));
        return levelScore;
    }

    @Override
    public LevelScore edit(LevelScore levelScore) {
        return null;
    }

    @Override
    public Optional<LevelScore> findByLevelScoreId(UUID id) {
        return Optional.empty();
    }

    @Override
    public void delete(UUID id) {
    }

    private LevelScoreEntity builderLevelScore(final LevelScore levelScore) {
        return LevelScoreEntity.builder()
                .id(levelScore.getId())
                .description(levelScore.getDescription())
                .createdAt(levelScore.getCreatedAt())
                .customerId(levelScore.getCustomerId())
                .build();
    }

}

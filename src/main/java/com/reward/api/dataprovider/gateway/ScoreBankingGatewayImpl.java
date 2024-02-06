package com.reward.api.dataprovider.gateway;

import com.reward.api.core.domain.score.ScoreBanking;
import com.reward.api.core.gateway.ScoreBankingGateway;
import com.reward.api.dataprovider.entity.ScoreBankingEntity;
import com.reward.api.dataprovider.repository.ScoreBankingRepository;
import jakarta.inject.Inject;

import java.util.Optional;
import java.util.UUID;

public class ScoreBankingGatewayImpl implements ScoreBankingGateway {

    private final ScoreBankingRepository repository;

    @Inject
    public ScoreBankingGatewayImpl(ScoreBankingRepository repository) {
        this.repository = repository;
    }

    @Override
    public ScoreBanking create(ScoreBanking scoreBanking) {
        repository.save(builderScore(scoreBanking));
        return scoreBanking;
    }

    @Override
    public Optional<ScoreBanking> findByScoreCustomerId(UUID id) {
        return Optional.empty();
    }

    private ScoreBankingEntity builderScore(final ScoreBanking score) {
        return ScoreBankingEntity.builder()
                .id(score.getId())
                .typeOperation(score.getTypeOperation().getDescription())
                .origin(score.getOrigin())
                .createdAt(score.getCreatedAt())
                .customerId(score.getCustomerId())
                .score(score.getScore())
                .build();
    }

}

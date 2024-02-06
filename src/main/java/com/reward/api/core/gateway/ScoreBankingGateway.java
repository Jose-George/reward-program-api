package com.reward.api.core.gateway;

import com.reward.api.core.domain.score.ScoreBanking;

import java.util.Optional;
import java.util.UUID;

public interface ScoreBankingGateway {
    ScoreBanking create(ScoreBanking scoreBanking);

    Optional<ScoreBanking> findByScoreCustomerId(UUID id);

}
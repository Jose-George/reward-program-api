package com.reward.api.core.gateway;

import com.reward.api.core.domain.score.ScoreBanking;

public interface ScoreBankingGateway {
    ScoreBanking create(ScoreBanking scoreBanking);

}
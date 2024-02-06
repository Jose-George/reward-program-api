package com.reward.api.core.usecase.score.create;

import com.reward.api.core.domain.score.ScoreBanking;

import java.util.UUID;

public record CreateScoreBankingOutput(UUID id, Integer score) {

    public static CreateScoreBankingOutput from(ScoreBanking score){
        return new CreateScoreBankingOutput(score.getId(), score.getScore());
    }
}

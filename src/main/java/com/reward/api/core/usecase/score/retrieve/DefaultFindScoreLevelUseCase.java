package com.reward.api.core.usecase.score.retrieve;

import com.reward.api.core.domain.level.LevelScore;
import com.reward.api.core.exception.NotFoundException;
import com.reward.api.core.gateway.LevelScoreGateway;
import com.reward.api.core.usecase.level.common.LevelOutputData;
import com.reward.api.core.usecase.score.common.ScoreDataOutput;
import jakarta.inject.Inject;

public class DefaultFindScoreLevelUseCase extends FindScoreLevelUseCase {


    @Override
    public ScoreDataOutput execute(FindScoreLevelCommand findScoreLevelCommand) {
        return null;
    }
}

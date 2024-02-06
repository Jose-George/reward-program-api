package com.reward.api.entrypoint.api.controller.impl;

import com.reward.api.core.usecase.customer.level.LevelGetCommand;
import com.reward.api.core.usecase.customer.level.LevelGetOutput;
import com.reward.api.core.usecase.customer.level.LevelGetScoreUseCase;
import com.reward.api.core.usecase.level.common.LevelOutputData;
import com.reward.api.core.usecase.level.create.CreateLevelUseCase;
import com.reward.api.core.usecase.score.common.CreateScoreLevelCommand;
import com.reward.api.entrypoint.api.controller.LevelScoreController;
import com.reward.api.entrypoint.api.model.LevelModel;
import com.reward.api.entrypoint.api.model.LevelScoreModel;
import com.reward.api.entrypoint.api.model.input.LevelInput;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;
import jakarta.validation.Valid;

import java.util.UUID;

@Controller("/level")
@Validated
public class LevelScoreControllerImpl implements LevelScoreController {

    private final CreateLevelUseCase createLevelUseCase;

    private final LevelGetScoreUseCase levelGetScoreUseCase;

    @Inject
    public LevelScoreControllerImpl(CreateLevelUseCase createLevelUseCase, LevelGetScoreUseCase levelGetScoreUseCase) {
        this.createLevelUseCase = createLevelUseCase;
        this.levelGetScoreUseCase = levelGetScoreUseCase;
    }

    @Post("/create")
    @Override
    public HttpResponse<LevelModel> create(@Body @Valid LevelInput levelInput) {
        var levelScore = createLevelUseCase.execute(CreateScoreLevelCommand.with(levelInput.cpf()));
        return HttpResponse.created(mapToLevel(levelScore));
    }

    @Get("/find/{cpf}")
    @Override
    public HttpResponse<LevelScoreModel> findLevelCustomerId(@PathVariable String cpf) {
        var levelGetScoreOutput = levelGetScoreUseCase.execute(LevelGetCommand.with(cpf));
        return HttpResponse.ok(mapToLevelScore(levelGetScoreOutput));
    }

    private static LevelModel mapToLevel(LevelOutputData levelOutputData) {
        return new LevelModel(levelOutputData.getId(), levelOutputData.getLevel());
    }

    private static LevelScoreModel mapToLevelScore(LevelGetOutput levelOutputData) {
        return new LevelScoreModel(levelOutputData.level(), levelOutputData.score());
    }

}

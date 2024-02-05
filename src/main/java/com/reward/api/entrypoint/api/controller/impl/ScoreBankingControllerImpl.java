package com.reward.api.entrypoint.api.controller.impl;

import com.reward.api.core.usecase.score.CreateScoreBankingCommand;
import com.reward.api.core.usecase.score.CreateScoreBankingOutput;
import com.reward.api.core.usecase.score.CreateScoreUseCase;
import com.reward.api.entrypoint.api.controller.ScoreBankingController;
import com.reward.api.entrypoint.api.model.ScoreBankingModel;
import com.reward.api.entrypoint.api.model.input.ScoreBankingInput;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;
import jakarta.validation.Valid;

@Controller("/score")
@Validated
public class ScoreBankingControllerImpl implements ScoreBankingController {

    private final CreateScoreUseCase createScoreUseCase;

    @Inject
    public ScoreBankingControllerImpl(CreateScoreUseCase createScoreUseCase) {
        this.createScoreUseCase = createScoreUseCase;
    }

    @Post("/create")
    @Override
    public HttpResponse<ScoreBankingModel> create(@Body @Valid ScoreBankingInput scoreBankingInput) {
        var score = createScoreUseCase.execute(CreateScoreBankingCommand.with(
                scoreBankingInput.cpf(), scoreBankingInput.origin(), scoreBankingInput.transactionId(), scoreBankingInput.level()
        ));

        return HttpResponse.created(mapToLevel(score));
    }

    private static ScoreBankingModel mapToLevel(CreateScoreBankingOutput createScoreBankingOutput) {
        return new ScoreBankingModel(createScoreBankingOutput.id(), createScoreBankingOutput.score());
    }

}

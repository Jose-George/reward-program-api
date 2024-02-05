package com.reward.api.entrypoint.api.controller;

import com.reward.api.entrypoint.api.model.LevelModel;
import com.reward.api.entrypoint.api.model.ScoreBankingModel;
import com.reward.api.entrypoint.api.model.input.LevelInput;
import com.reward.api.entrypoint.api.model.input.ScoreBankingInput;
import io.micronaut.http.HttpResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "ScoreBanking")
public interface ScoreBankingController {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "created successfully"),
            @ApiResponse(responseCode = "500", description = "An internal server error occurred"),
    })
    @Operation(
            tags = "ScoreBanking",
            summary = "Add a new score for a customer",
            description = "Creates and adds a new score for the given customer."
    )
    HttpResponse<ScoreBankingModel> create(ScoreBankingInput scoreBankingInput);

}

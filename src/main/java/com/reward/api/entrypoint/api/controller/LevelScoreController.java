package com.reward.api.entrypoint.api.controller;

import com.reward.api.entrypoint.api.model.LevelModel;
import com.reward.api.entrypoint.api.model.LevelScoreModel;
import com.reward.api.entrypoint.api.model.input.LevelInput;
import io.micronaut.http.HttpResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.UUID;

@Tag(name = "LevelScore")
public interface LevelScoreController {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "created successfully"),
            @ApiResponse(responseCode = "422", description = "A validation error occurred"),
            @ApiResponse(responseCode = "500", description = "An internal server error occurred"),
    })
    @Operation(
            tags = "LevelScore",
            summary = "Add a new level for a customer",
            description = "Creates and adds a new level for the given customer."
    )
    HttpResponse<LevelModel> create(LevelInput levelInput);

    HttpResponse<LevelScoreModel> findLevelCustomerId(String customerId);

}

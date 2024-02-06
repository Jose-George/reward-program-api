package com.reward.api.entrypoint.api.controller;

import com.reward.api.entrypoint.api.model.BankTransactionModel;
import com.reward.api.entrypoint.api.model.input.BankTransactionInput;
import io.micronaut.http.HttpResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Transaction")
public interface BankTransactionController {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "created successfully"),
            @ApiResponse(responseCode = "500", description = "An internal server error occurred"),
    })
    @Operation(
            tags = "BankTransaction",
            summary = "Add a new transaction for a customer",
            description = "Creates and adds a new transaction for the given customer."
    )
    HttpResponse<BankTransactionModel> create(BankTransactionInput bankTransactionInput);

}

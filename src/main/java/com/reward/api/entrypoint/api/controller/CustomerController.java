package com.reward.api.entrypoint.api.controller;

import com.reward.api.entrypoint.api.model.CustomerModel;
import com.reward.api.entrypoint.api.model.input.CustomerInput;
import io.micronaut.http.HttpResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.UUID;

@Tag(name = "Customer")
public interface CustomerController {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "created successfully"),
            @ApiResponse(responseCode = "500", description = "An internal server error occurred"),
    })
    HttpResponse<CustomerModel> create(CustomerInput customerInput);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successfully"),
            @ApiResponse(responseCode = "500", description = "An internal server error occurred"),
    })
    HttpResponse<CustomerModel> findByCpf(String cpf);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successfully"),
            @ApiResponse(responseCode = "500", description = "An internal server error occurred"),
    })
    HttpResponse<CustomerModel> edit(UUID id, CustomerInput customerInput);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "delete successfully"),
            @ApiResponse(responseCode = "500", description = "An internal server error occurred"),
    })
    void delete(String cpf);

}

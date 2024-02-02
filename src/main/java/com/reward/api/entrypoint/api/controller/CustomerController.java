package com.reward.api.entrypoint.api.controller;

import com.reward.api.entrypoint.api.controller.model.CustomerModel;
import com.reward.api.entrypoint.api.controller.model.input.CustomerInput;
import io.micronaut.http.HttpResponse;

import java.util.UUID;

public interface CustomerController {

    HttpResponse<CustomerModel> create(CustomerInput customerInput) throws Exception;

    HttpResponse<CustomerModel> findByCpf(String cpf);

    HttpResponse<CustomerModel> edit(UUID id, CustomerInput customerInput);

    void delete(String cpf);

}

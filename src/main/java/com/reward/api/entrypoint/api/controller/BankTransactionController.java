package com.reward.api.entrypoint.api.controller;

import com.reward.api.entrypoint.api.model.BankTransactionModel;
import com.reward.api.entrypoint.api.model.input.BankTransactionInput;
import io.micronaut.http.HttpResponse;

public interface BankTransactionController {

    HttpResponse<BankTransactionModel> create(BankTransactionInput bankTransactionInput);

}

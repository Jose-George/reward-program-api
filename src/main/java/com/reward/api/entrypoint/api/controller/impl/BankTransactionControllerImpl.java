package com.reward.api.entrypoint.api.controller.impl;

import com.reward.api.core.usecase.transaction.create.CreateBankTransactionCommand;
import com.reward.api.core.usecase.transaction.common.BankTransactionOutput;
import com.reward.api.core.usecase.transaction.create.CreateBankTransactionUseCase;
import com.reward.api.entrypoint.api.controller.BankTransactionController;
import com.reward.api.entrypoint.api.model.BankTransactionModel;
import com.reward.api.entrypoint.api.model.input.BankTransactionInput;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import org.javamoney.moneta.Money;

@Controller("/transaction")
@Validated
public class BankTransactionControllerImpl implements BankTransactionController {

    private final CreateBankTransactionUseCase createBankTransactionUseCase;

    @Inject
    public BankTransactionControllerImpl(CreateBankTransactionUseCase createBankTransactionUseCase) {
        this.createBankTransactionUseCase = createBankTransactionUseCase;
    }

    @Post("/create")
    @Override
    public HttpResponse<BankTransactionModel> create(@Body @Valid BankTransactionInput bankTransactionInput) {
        var bankTransaction = createBankTransactionUseCase.execute(CreateBankTransactionCommand.with(
                bankTransactionInput.type(), bankTransactionInput.cpf(), Money.of(bankTransactionInput.amount(), "USD"),
                bankTransactionInput.storeBuy()
        ));

        return HttpResponse.created(mapToBankTransaction(bankTransaction));
    }

    private static BankTransactionModel mapToBankTransaction(BankTransactionOutput bankTransaction) {
        return new BankTransactionModel(bankTransaction.id(), bankTransaction.amount().toString(), bankTransaction.date());
    }
}

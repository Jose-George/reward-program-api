package com.reward.api.core.usecase.transaction;

import com.reward.api.core.domain.transaction.BankTransaction;
import com.reward.api.core.gateway.BankTransactionGateway;
import jakarta.inject.Inject;

public class DefaultCreateBankTransactionUseCase extends CreateBankTransactionUseCase {

    private final BankTransactionGateway bankTransactionGateway;

    @Inject
    public DefaultCreateBankTransactionUseCase(BankTransactionGateway bankTransactionGateway) {
        this.bankTransactionGateway = bankTransactionGateway;
    }

    @Override
    public CreateBankTransactionOutput execute(CreateBankTransactionCommand createBankTransactionCommand) {
        BankTransaction bankTransaction = BankTransaction.of(createBankTransactionCommand.type(),
                createBankTransactionCommand.customerId(), createBankTransactionCommand.amount(), createBankTransactionCommand.storeBuy());
        return CreateBankTransactionOutput.from(bankTransactionGateway.create(bankTransaction));
    }
}

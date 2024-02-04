package com.reward.api.core.usecase.transaction.create;

import com.reward.api.core.domain.transaction.BankTransaction;
import com.reward.api.core.gateway.BankTransactionGateway;
import com.reward.api.core.usecase.transaction.common.BankTransactionOutput;
import jakarta.inject.Inject;

public class DefaultCreateBankTransactionUseCase extends CreateBankTransactionUseCase {

    private final BankTransactionGateway bankTransactionGateway;

    @Inject
    public DefaultCreateBankTransactionUseCase(BankTransactionGateway bankTransactionGateway) {
        this.bankTransactionGateway = bankTransactionGateway;
    }

    @Override
    public BankTransactionOutput execute(CreateBankTransactionCommand createBankTransactionCommand) {
        BankTransaction bankTransaction = BankTransaction.of(createBankTransactionCommand.type(),
                createBankTransactionCommand.customerId(), createBankTransactionCommand.amount(), createBankTransactionCommand.storeBuy());
        return BankTransactionOutput.from(bankTransactionGateway.create(bankTransaction));
    }
}

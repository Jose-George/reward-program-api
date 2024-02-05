package com.reward.api.core.usecase.transaction.create;

import com.reward.api.core.domain.transaction.BankTransaction;
import com.reward.api.core.gateway.BankTransactionGateway;
import com.reward.api.core.usecase.customer.common.CustomerOutputData;
import com.reward.api.core.usecase.customer.retrieve.FindCustomerCommand;
import com.reward.api.core.usecase.customer.retrieve.FindCustomerUseCase;
import com.reward.api.core.usecase.transaction.common.BankTransactionOutput;
import jakarta.inject.Inject;

public class DefaultCreateBankTransactionUseCase extends CreateBankTransactionUseCase {

    private final BankTransactionGateway bankTransactionGateway;

    private final FindCustomerUseCase findCustomerUseCase;

    @Inject
    public DefaultCreateBankTransactionUseCase(BankTransactionGateway bankTransactionGateway, FindCustomerUseCase findCustomerUseCase) {
        this.bankTransactionGateway = bankTransactionGateway;
        this.findCustomerUseCase = findCustomerUseCase;
    }

    @Override
    public BankTransactionOutput execute(CreateBankTransactionCommand createBankTransactionCommand) {
        CustomerOutputData customer =
                findCustomerUseCase.execute(FindCustomerCommand.with(createBankTransactionCommand.cpf()));

        BankTransaction bankTransaction = BankTransaction.of(createBankTransactionCommand.type(),
                customer.getId(), createBankTransactionCommand.amount(), createBankTransactionCommand.storeBuy());
        return BankTransactionOutput.from(bankTransactionGateway.create(bankTransaction));
    }
}

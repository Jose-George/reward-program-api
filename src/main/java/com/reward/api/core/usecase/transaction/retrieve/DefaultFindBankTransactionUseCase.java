package com.reward.api.core.usecase.transaction.retrieve;

import com.reward.api.core.domain.transaction.BankTransaction;
import com.reward.api.core.exception.NotFoundException;
import com.reward.api.core.gateway.BankTransactionGateway;
import com.reward.api.core.usecase.transaction.common.BankTransactionOutput;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultFindBankTransactionUseCase extends FindBankTransactionUseCase{

   private final BankTransactionGateway bankTransactionGateway;

    public DefaultFindBankTransactionUseCase(BankTransactionGateway bankTransactionGateway) {
        this.bankTransactionGateway = bankTransactionGateway;
    }


    @Override
    public List<BankTransactionOutput> execute(FindBankTransactionCommand findBankTransactionCommand) {

        List<BankTransaction> bankTransactions =  bankTransactionGateway.findByTransactionLast30Days(findBankTransactionCommand.customerId())
                .orElseThrow(() -> new NotFoundException("bank transaction not found"));

        return bankTransactions.stream().map(t -> BankTransactionOutput.from(t)).collect(Collectors.toList());
    }
}

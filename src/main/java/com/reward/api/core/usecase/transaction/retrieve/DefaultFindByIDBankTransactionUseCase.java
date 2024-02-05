package com.reward.api.core.usecase.transaction.retrieve;

import com.reward.api.core.domain.transaction.BankTransaction;
import com.reward.api.core.exception.DomainException;
import com.reward.api.core.gateway.BankTransactionGateway;
import com.reward.api.core.usecase.transaction.common.BankTransactionOutput;
import jakarta.inject.Inject;

public class DefaultFindByIDBankTransactionUseCase extends FindByIDBankTransactionUseCase {

   private final BankTransactionGateway bankTransactionGateway;

   @Inject
    public DefaultFindByIDBankTransactionUseCase(BankTransactionGateway bankTransactionGateway) {
        this.bankTransactionGateway = bankTransactionGateway;
    }


    @Override
    public BankTransactionOutput execute(FindByIDBankTransactionCommand findByIDBankTransactionCommand) {
       BankTransaction transaction = bankTransactionGateway.findByTransactionId(findByIDBankTransactionCommand.transactionId()).orElseThrow(
               () -> new DomainException("error get id bank transaction"));

       return BankTransactionOutput.from(transaction);
    }
}

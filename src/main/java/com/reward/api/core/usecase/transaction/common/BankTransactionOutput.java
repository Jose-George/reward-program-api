package com.reward.api.core.usecase.transaction.common;

import com.reward.api.core.domain.transaction.BankTransaction;
import com.reward.api.core.domain.transaction.TypeTransaction;

import java.time.OffsetDateTime;
import java.util.UUID;

public record BankTransactionOutput(UUID id, OffsetDateTime date, Double amount, TypeTransaction typeTransaction) {

    public static BankTransactionOutput from(BankTransaction bankTransaction) {
        return new BankTransactionOutput(bankTransaction.getId(), bankTransaction.getTransactionDate(), bankTransaction.getAmount().getNumber().doubleValue(), bankTransaction.getType());
    }
}

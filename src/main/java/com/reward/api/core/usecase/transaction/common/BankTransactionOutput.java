package com.reward.api.core.usecase.transaction.common;

import com.reward.api.core.domain.transaction.BankTransaction;

import java.time.OffsetDateTime;
import java.util.UUID;

public record BankTransactionOutput(UUID id, OffsetDateTime date, String amount) {

    public static BankTransactionOutput from(BankTransaction bankTransaction) {
        return new BankTransactionOutput(bankTransaction.getId(), bankTransaction.getTransactionDate(), bankTransaction.getAmount().toString());
    }
}

package com.reward.api.core.usecase.transaction;

import com.reward.api.core.domain.transaction.BankTransaction;

import java.time.OffsetDateTime;
import java.util.UUID;

public record CreateBankTransactionOutput(UUID id, OffsetDateTime date, String amount) {

    public static CreateBankTransactionOutput from(BankTransaction bankTransaction) {
        return new  CreateBankTransactionOutput(bankTransaction.getId(), bankTransaction.getTransactionDate(), bankTransaction.getAmount().toString());
    }
}

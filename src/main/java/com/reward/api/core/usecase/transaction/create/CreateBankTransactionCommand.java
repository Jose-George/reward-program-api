package com.reward.api.core.usecase.transaction.create;

import com.reward.api.core.domain.transaction.TypeTransaction;

import javax.money.MonetaryAmount;
import java.util.UUID;

public record CreateBankTransactionCommand(TypeTransaction type, String cpf, MonetaryAmount amount, String storeBuy) {

    public static CreateBankTransactionCommand with(String type, String cpf, MonetaryAmount amount, String storeBuy) {
        return new CreateBankTransactionCommand(TypeTransaction.valueOf(type), cpf, amount, storeBuy);
    }

}

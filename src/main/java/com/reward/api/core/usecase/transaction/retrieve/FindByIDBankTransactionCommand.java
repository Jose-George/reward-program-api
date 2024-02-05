package com.reward.api.core.usecase.transaction.retrieve;

import java.util.UUID;

public record FindByIDBankTransactionCommand(UUID transactionId) {

    public static FindByIDBankTransactionCommand with(UUID transactionId) {
        return new FindByIDBankTransactionCommand(transactionId);
    }
}

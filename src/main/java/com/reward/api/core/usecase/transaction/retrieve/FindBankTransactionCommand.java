package com.reward.api.core.usecase.transaction.retrieve;

import java.util.UUID;

public record FindBankTransactionCommand(UUID customerId) {

    public static FindBankTransactionCommand with(UUID customerId) {
        return new FindBankTransactionCommand(customerId);
    }
}

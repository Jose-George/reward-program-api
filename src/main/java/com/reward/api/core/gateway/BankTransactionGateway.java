package com.reward.api.core.gateway;

import com.reward.api.core.domain.transaction.BankTransaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BankTransactionGateway {
    BankTransaction create(BankTransaction bankTransaction);

    Optional<List<BankTransaction>> findByTransactionLast30Days(UUID customerId);

}
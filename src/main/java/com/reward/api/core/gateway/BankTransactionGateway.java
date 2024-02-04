package com.reward.api.core.gateway;

import com.reward.api.core.domain.transaction.BankTransaction;

public interface BankTransactionGateway {
    BankTransaction create(BankTransaction bankTransaction);

}
package com.reward.api.dataprovider.gateway;

import com.reward.api.core.domain.transaction.BankTransaction;
import com.reward.api.core.gateway.BankTransactionGateway;
import com.reward.api.dataprovider.entity.BankTransactionEntity;
import com.reward.api.dataprovider.repository.BankTransactionRepository;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BankTransactionImpl implements BankTransactionGateway {

    private final BankTransactionRepository repository;

    @Inject
    public BankTransactionImpl(BankTransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public BankTransaction create(BankTransaction bankTransaction) {
        repository.save(builderTransactionEntity(bankTransaction));
        return bankTransaction;
    }

    @Override
    public Optional<List<BankTransaction>> findByTransactionLast30Days(UUID customerId) {
        //implementar
        return Optional.empty();
    }


    private BankTransactionEntity builderTransactionEntity(final BankTransaction bankTransaction) {
        return BankTransactionEntity.builder()
                .id(bankTransaction.getId())
                .type(bankTransaction.getType().getDescription())
                .transactionDate(bankTransaction.getTransactionDate())
                .amount(bankTransaction.getAmount().getNumber().doubleValue())
                .customerId(bankTransaction.getCustomerId())
                .storeBuy(bankTransaction.getStoreBuy())
                .build();
    }

}

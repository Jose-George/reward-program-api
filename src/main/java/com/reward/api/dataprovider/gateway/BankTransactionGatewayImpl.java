package com.reward.api.dataprovider.gateway;

import com.reward.api.core.domain.transaction.BankTransaction;
import com.reward.api.core.domain.transaction.TypeTransaction;
import com.reward.api.core.gateway.BankTransactionGateway;
import com.reward.api.dataprovider.entity.BankTransactionEntity;
import com.reward.api.dataprovider.repository.BankTransactionRepository;
import jakarta.inject.Inject;
import org.javamoney.moneta.Money;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class BankTransactionGatewayImpl implements BankTransactionGateway {

    private final BankTransactionRepository repository;

    @Inject
    public BankTransactionGatewayImpl(BankTransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public BankTransaction create(BankTransaction bankTransaction) {
        repository.save(builderTransactionEntity(bankTransaction));
        return bankTransaction;
    }

    @Override
    public List<BankTransaction> findByTransactionLast30Days(UUID customerId) {
        List<BankTransactionEntity> transactionEntities = repository.findTransactionsByCustomerIdAndTransactionDateRange(
                customerId, OffsetDateTime.now().minusDays(30)
        );

        return transactionEntities.stream()
                .map(this::mapToBankTransaction)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BankTransaction> findByTransactionId(UUID transactionId) {
        return Optional.of(mapToBankTransaction(repository.findById(transactionId).get()));
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

    public BankTransaction mapToBankTransaction(BankTransactionEntity bankTransactionEntity) {
        return BankTransaction.of(TypeTransaction.valueOf(bankTransactionEntity.getType()),
                bankTransactionEntity.getCustomerId(), Money.of(bankTransactionEntity.getAmount(), "USD"),bankTransactionEntity.getStoreBuy() );
    }

}

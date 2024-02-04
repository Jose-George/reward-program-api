package com.reward.api.core.domain.transaction;

import javax.money.MonetaryAmount;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

public class BankTransaction {

    private final UUID id;

    private final TypeTransaction type;

    private final UUID customerId;

    private final MonetaryAmount amount;

    private final OffsetDateTime transactionDate;

    private final String storeBuy;

    private BankTransaction(final UUID id, final TypeTransaction type, final UUID customerId, final MonetaryAmount amount, final OffsetDateTime transactionDate,
                           final String storeBuy) {
        this.id = id;
        this.type = type;
        this.customerId = customerId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.storeBuy = storeBuy;
    }

    public static BankTransaction of(final TypeTransaction type, final UUID customerId, final MonetaryAmount amount, final String storeBuy) {
        Objects.requireNonNull(customerId);
        Objects.requireNonNull(amount);
        Objects.requireNonNull(storeBuy);

        UUID id = UUID.randomUUID();
        OffsetDateTime transactionDate = OffsetDateTime.now();

        return new BankTransaction(id, type, customerId, amount, transactionDate, storeBuy);
    }

    public UUID getId() {
        return id;
    }

    public TypeTransaction getType() {
        return type;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public MonetaryAmount getAmount() {
        return amount;
    }

    public OffsetDateTime getTransactionDate() {
        return transactionDate;
    }

    public String getStoreBuy() {
        return storeBuy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankTransaction that = (BankTransaction) o;
        return Objects.equals(id, that.id) && type == that.type && Objects.equals(customerId, that.customerId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(storeBuy, that.storeBuy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, customerId, amount, transactionDate, storeBuy);
    }
}

package com.reward.api.dataprovider.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
@Data
@Entity
@Table(name = "BANK_TRANSACTION")
@NoArgsConstructor
@AllArgsConstructor
public class BankTransactionEntity {

    @Id
    private UUID id;

    private String type;

    private UUID customerId;

    private double amount;

    private OffsetDateTime transactionDate;

    private String storeBuy;

}

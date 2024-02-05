package com.reward.api.dataprovider.repository;

import com.reward.api.dataprovider.entity.BankTransactionEntity;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface BankTransactionRepository extends JpaRepository<BankTransactionEntity, UUID> {

    @Query("SELECT bt FROM BankTransactionEntity bt " +
                  "WHERE bt.customerId = :customerUUID " +
                  "AND bt.transactionDate >= :transactionStartDate " +
                  "ORDER BY bt.transactionDate DESC")
    List<BankTransactionEntity> findTransactionsByCustomerIdAndTransactionDateRange(
            UUID customerUUID,
            OffsetDateTime transactionStartDate
    );

}

package com.reward.api.dataprovider.repository;

import com.reward.api.dataprovider.entity.BankTransactionEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Repository
public interface BankTransactionRepository extends JpaRepository<BankTransactionEntity, UUID> {

}
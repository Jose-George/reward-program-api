package com.reward.api.dataprovider.repository;

import com.reward.api.dataprovider.entity.LevelScoreEntity;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LevelScoreRepository extends JpaRepository<LevelScoreEntity, UUID> {

    Optional<LevelScoreEntity> findByCustomerId(UUID customerId);

}

package com.reward.api.dataprovider.repository;

import com.reward.api.dataprovider.entity.LevelScoreEntity;
import com.reward.api.dataprovider.entity.ScoreBankingEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ScoreBankingRepository extends JpaRepository<ScoreBankingEntity, UUID> {

}

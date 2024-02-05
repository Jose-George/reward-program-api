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
@Table(name = "LEVEL_SCORE")
@NoArgsConstructor
@AllArgsConstructor
public class LevelScoreEntity {

    @Id
    private UUID id;
    private UUID customerId;
    private String description;
    private OffsetDateTime createdAt;

}

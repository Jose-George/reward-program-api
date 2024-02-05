package com.reward.api.dataprovider.entity;

import com.reward.api.core.domain.score.TypeOperation;
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
@Table(name = "SCORE_BANKING")
@NoArgsConstructor
@AllArgsConstructor
public class ScoreBankingEntity {

    @Id
    private UUID id;

    private Integer score;

    private UUID customerId;

    private OffsetDateTime createdAt;

    private String origin;

    private String typeOperation;


}

package com.reward.api.core.domain.score;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

public class ScoreBanking {

    private final UUID id;

    private final Integer score;

    private final UUID customerId;

    private final OffsetDateTime createdAt;

    private final String origin;

    private final TypeOperation typeOperation;

    private ScoreBanking(UUID id, Integer score, UUID customerId, OffsetDateTime createdAt, String origin, TypeOperation typeOperation) {
        this.id = id;
        this.score = score;
        this.customerId = customerId;
        this.createdAt = createdAt;
        this.origin = origin;
        this.typeOperation = typeOperation;
    }

    public static ScoreBanking of(Integer score, UUID customerId, String origin, TypeOperation typeOperation){
        Objects.requireNonNull(score);
        Objects.requireNonNull(customerId);
        Objects.requireNonNull(origin);
        Objects.requireNonNull(typeOperation);

        UUID id = UUID.randomUUID();
        OffsetDateTime createdAt = OffsetDateTime.now();
        return new ScoreBanking(
            id, score, customerId, createdAt, origin, typeOperation
        );
    }

    public UUID getId() {
        return id;
    }

    public Integer getScore() {
        return score;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public String getOrigin() {
        return origin;
    }

    public TypeOperation getTypeOperation() {
        return typeOperation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreBanking that = (ScoreBanking) o;
        return Objects.equals(id, that.id) && Objects.equals(score, that.score) && Objects.equals(customerId, that.customerId) && Objects.equals(createdAt, that.createdAt) && Objects.equals(origin, that.origin) && typeOperation == that.typeOperation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, score, customerId, createdAt, origin, typeOperation);
    }
}

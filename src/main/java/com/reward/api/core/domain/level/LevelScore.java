package com.reward.api.core.domain.level;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

public final class LevelScore {

    private final UUID id;

    private final UUID customerId;
    private final String description;

    private final OffsetDateTime createdAt;

    private LevelScore(UUID id, UUID customerId, String description, OffsetDateTime createdAt) {
        this.id = id;
        this.customerId = id;
        this.description = description;
        this.createdAt = createdAt;
    }

    public static LevelScore of(Double transactionalValueLast30days, UUID customerId){
        UUID id = UUID.randomUUID();
        OffsetDateTime date = OffsetDateTime.now();
        Objects.requireNonNull(transactionalValueLast30days);
        Objects.requireNonNull(customerId);
        return new LevelScore(id, customerId, determineLevel(transactionalValueLast30days), date);
    }

    public static LevelScore update(UUID id , Double transactionalValueLast30days, UUID customerId){
        OffsetDateTime date = OffsetDateTime.now();
        Objects.requireNonNull(id);
        Objects.requireNonNull(transactionalValueLast30days);
        Objects.requireNonNull(customerId);
        return new LevelScore(id, customerId, determineLevel(transactionalValueLast30days), date);
    }

    private static String determineLevel(Double transactionalValueLast30days) {
        if (transactionalValueLast30days >= 10000) {
            return LevelScoreCalculate.LEVEL_THREE.toString();
        }

        if (transactionalValueLast30days >= 3000) {
            return LevelScoreCalculate.LEVEL_TWO.toString();
        }

        return LevelScoreCalculate.LEVEL_ONE.toString();
    }

    public UUID getId() {
        return id;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LevelScore that = (LevelScore) o;
        return Objects.equals(description, that.description) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, createdAt);
    }

}

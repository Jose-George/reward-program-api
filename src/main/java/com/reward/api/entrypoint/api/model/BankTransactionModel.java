package com.reward.api.entrypoint.api.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

import java.time.OffsetDateTime;
import java.util.UUID;

@Introspected
@Serdeable
public record BankTransactionModel(UUID id, String amount, OffsetDateTime date) {
}

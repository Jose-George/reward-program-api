package com.reward.api.entrypoint.api.model.input;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

import java.util.UUID;

@Introspected
@Serdeable
public record ScoreBankingInput(String cpf, String origin, UUID transactionId, String level) {
}

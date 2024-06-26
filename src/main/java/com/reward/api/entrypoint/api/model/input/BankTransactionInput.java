package com.reward.api.entrypoint.api.model.input;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

import java.util.UUID;

@Introspected
@Serdeable
public record BankTransactionInput(String type, String cpf, double amount, String storeBuy) {
}



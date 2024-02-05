package com.reward.api.entrypoint.api.model.input;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

@Introspected
@Serdeable
public record LevelInput(String cpf) {
}

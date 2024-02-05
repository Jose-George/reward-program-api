package com.reward.api.entrypoint.api.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

import java.util.UUID;

@Introspected
@Serdeable
public record LevelModel(UUID id, String level) {
}

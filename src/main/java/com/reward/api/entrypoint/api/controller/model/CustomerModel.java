package com.reward.api.entrypoint.api.controller.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

import java.util.UUID;

@Introspected
@Serdeable
public record CustomerModel(UUID id, String name, String email, Integer currentScore) {
}

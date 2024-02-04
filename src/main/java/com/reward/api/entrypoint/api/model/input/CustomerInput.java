package com.reward.api.entrypoint.api.model.input;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotBlank;

@Introspected
@Serdeable
public record CustomerInput(
        @NotBlank(message = "Name cannot be empty")  String name,
        @NotBlank(message = "Cpf cannot be empty") String cpf,
        @NotBlank(message = "E-mail cannot be empty") String email,
        @NotBlank(message = "Date Birth cannot be empty") String dateBirth,
        Integer currentScore) {
}

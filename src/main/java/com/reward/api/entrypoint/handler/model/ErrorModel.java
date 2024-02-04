package com.reward.api.entrypoint.handler.model;

import io.micronaut.http.HttpStatus;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@Serdeable
@AllArgsConstructor
@NoArgsConstructor
public class ErrorModel {

    private String message;
    private HttpStatus status;
    private LocalDateTime time;

}

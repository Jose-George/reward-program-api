package com.reward.api.entrypoint.handler;

import com.reward.api.entrypoint.handler.model.ErrorModel;
import io.micronaut.context.annotation.Replaces;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import io.micronaut.http.server.exceptions.response.ErrorResponseProcessor;
import jakarta.inject.Singleton;
import jakarta.validation.ConstraintViolationException;

import java.time.LocalDateTime;

@Produces
@Replaces(io.micronaut.validation.exceptions.ConstraintExceptionHandler.class)
@Requires(classes = {ConstraintViolationException.class, ExceptionHandler.class})
@Singleton
public class ConstraintExceptionHandler extends io.micronaut.validation.exceptions.ConstraintExceptionHandler {
    /**
     * Constructor.
     *
     * @param responseProcessor Error Response Processor
     */
    public ConstraintExceptionHandler(ErrorResponseProcessor<?> responseProcessor) {
        super(responseProcessor);
    }

    public HttpResponse handle(HttpRequest request, ConstraintViolationException exception) {
        return HttpResponse.badRequest().body(new ErrorModel(exception.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now()));
    }
}
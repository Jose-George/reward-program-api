package com.reward.api;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;


@OpenAPIDefinition(
        info = @Info(
                title = "reward-program-api",
                version = "1.0",
                description = "Reward Program API",
                contact = @Contact(url = "https://github.com/jose-george", name = "Jose George")))
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
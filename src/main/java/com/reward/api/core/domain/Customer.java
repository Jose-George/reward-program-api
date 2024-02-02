package com.reward.api.core.domain;

import java.util.Objects;
import java.util.UUID;

public class Customer {

    private final UUID id;
    private final String name;
    private final Cpf cpf;
    private final Email email;
    private final String dateBirth;
    private final Integer currentScore;

    private Customer(final UUID id, final String name, final Cpf cpf, final Email email, final String dateBirth, final Integer currentScore) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.dateBirth = dateBirth;
        this.currentScore = currentScore;
        this.id = id;
    }

    public static Customer of(final String name, final Cpf cpf, final Email email, final String dateBirth, final Integer currentScore) {
        Objects.requireNonNull(name);
        UUID id = UUID.randomUUID();
        return new Customer(id, name, cpf, email, dateBirth, currentScore);
    }

    public static Customer of(final UUID id, final String name, final Cpf cpf, final Email email, final String dateBirth, final Integer currentScore) {
        Objects.requireNonNull(name);
        return new Customer(id, name, cpf, email, dateBirth, currentScore);
    }

    public static Customer update(final UUID id, final String name, final Cpf cpf, final Email email, final String dateBirth, final Integer currentScore) {
        Objects.requireNonNull(name);
        return new Customer(id, name, cpf, email, dateBirth, currentScore);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public Email getEmail(){
        return email;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public Integer getCurrentScore() {
        return currentScore;
    }
}

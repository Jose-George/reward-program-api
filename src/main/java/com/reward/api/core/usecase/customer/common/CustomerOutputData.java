package com.reward.api.core.usecase.customer.common;

import com.reward.api.core.domain.customer.Customer;

import java.util.UUID;

public class CustomerOutputData {

    private UUID id;
    private String name;
    private String cpf;
    private  String email;
    private String dateBirth;
    private Integer currentScore;

    public CustomerOutputData(UUID id, String name, String cpf, String email, String dateBirth, Integer currentScore) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.dateBirth = dateBirth;
        this.currentScore = currentScore;
    }

    public static CustomerOutputData from(Customer customer) {
        return new CustomerOutputData(
                customer.getId(), customer.getName(), customer.getCpf().get(), customer.getEmail().get(),
                customer.getDateBirth(), customer.getCurrentScore()
        );
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Integer getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(Integer currentScore) {
        this.currentScore = currentScore;
    }
}

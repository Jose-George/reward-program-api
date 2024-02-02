package com.reward.api.core.gateway;

import com.reward.api.core.domain.Cpf;
import com.reward.api.core.domain.Customer;

import java.util.Optional;

public interface CustomerGateway {
    Customer create(Customer customer);
    Customer edit(Customer customer);
    Optional<Customer> findByCpf(Cpf cpf);
    void delete(Cpf cpf);
}
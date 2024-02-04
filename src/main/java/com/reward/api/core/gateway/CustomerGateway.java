package com.reward.api.core.gateway;

import com.reward.api.core.domain.customer.Cpf;
import com.reward.api.core.domain.customer.Customer;

import java.util.Optional;

public interface CustomerGateway {
    Customer create(Customer customer);
    Customer edit(Customer customer);
    Optional<Customer> findByCpf(Cpf cpf);
    void delete(Cpf cpf);
}
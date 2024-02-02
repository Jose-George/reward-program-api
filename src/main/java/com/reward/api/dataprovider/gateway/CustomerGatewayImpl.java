package com.reward.api.dataprovider.gateway;

import com.reward.api.core.domain.Cpf;
import com.reward.api.core.domain.Customer;
import com.reward.api.core.domain.Email;
import com.reward.api.core.gateway.CustomerGateway;
import com.reward.api.dataprovider.entity.CustomerEntity;
import com.reward.api.dataprovider.repository.CustomerRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;

import java.util.Optional;

@Singleton
public class CustomerGatewayImpl implements CustomerGateway {

    private final CustomerRepository repository;

    @Inject
    public CustomerGatewayImpl (CustomerRepository customerRepository) {
        this.repository = customerRepository;
    }

    @Override
    @Transactional
    public Customer create(Customer customer) {
        repository.save(builderCustomerEntity(customer));
        return customer;
    }

    @Override
    @Transactional
    public Customer edit(Customer customer) {
        repository.update(builderCustomerEntity(customer));
        return customer;
    }

    @Override
    @Transactional
    public Optional<Customer> findByCpf(Cpf cpf) {
        return Optional.of(mapToCustomer(repository.findByCpf(cpf.get()).get()));
    }

    @Override
    @Transactional
    public void delete(Cpf cpf) {
        var customer = findByCpf(cpf);
        repository.deleteById(customer.get().getId());
    }

    private CustomerEntity builderCustomerEntity(final Customer customer) {
        return CustomerEntity.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail().get())
                .cpf(customer.getCpf().get())
                .dateBirth(customer.getDateBirth())
                .currentScore(customer.getCurrentScore())
                .build();
    }

    private Customer mapToCustomer(final CustomerEntity customerEntity) {
        return Customer.of(customerEntity.getId(), customerEntity.getName(), Cpf.of(customerEntity.getCpf()), Email.of(customerEntity.getEmail()), customerEntity.getDateBirth(), customerEntity.getCurrentScore());
    }
}

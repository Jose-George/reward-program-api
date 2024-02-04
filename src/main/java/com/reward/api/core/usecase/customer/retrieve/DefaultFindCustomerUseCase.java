package com.reward.api.core.usecase.customer.retrieve;

import com.reward.api.core.domain.customer.Cpf;
import com.reward.api.core.domain.customer.Customer;
import com.reward.api.core.exception.NotFoundException;
import com.reward.api.core.gateway.CustomerGateway;
import com.reward.api.core.usecase.customer.common.CustomerOutputData;
import jakarta.inject.Inject;


public class DefaultFindCustomerUseCase extends FindCustomerUseCase {

    private final CustomerGateway customerGateway;

    @Inject
    public DefaultFindCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public CustomerOutputData execute(FindCustomerCommand findCustomerCommand) {
        Cpf cpf = Cpf.of(findCustomerCommand.cpf());
        Customer customer = customerGateway.findByCpf(cpf)
                .orElseThrow(() -> new NotFoundException("Customer not found"));

        return CustomerOutputData.from(customer);
    }
}
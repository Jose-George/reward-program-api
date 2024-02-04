package com.reward.api.core.usecase.customer.create;

import com.reward.api.core.domain.customer.Cpf;
import com.reward.api.core.domain.customer.Customer;
import com.reward.api.core.domain.customer.Email;
import com.reward.api.core.gateway.CustomerGateway;
import com.reward.api.core.usecase.customer.common.CustomerOutputData;
import jakarta.inject.Inject;

public class DefaultCreateCustomerUseCase extends CreateCustomerUseCase {

    private final CustomerGateway customerGateway;

    @Inject
    public DefaultCreateCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public CustomerOutputData execute(CreateCustomerCommand createCustomerCommand) {
        Customer customer = Customer.of(createCustomerCommand.name(), Cpf.of(createCustomerCommand.cpf()), Email.of(createCustomerCommand.email()),
                createCustomerCommand.dateBirth(), createCustomerCommand.currentScore());
        return CustomerOutputData.from(customerGateway.create(customer));
    }
}

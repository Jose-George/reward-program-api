package com.reward.api.core.usecase.customer.edit;

import com.reward.api.core.domain.Cpf;
import com.reward.api.core.domain.Customer;
import com.reward.api.core.domain.Email;
import com.reward.api.core.gateway.CustomerGateway;
import com.reward.api.core.usecase.customer.common.CustomerOutputData;
import jakarta.inject.Inject;

public class DefaultEditCustomerUseCase extends EditCustomerUseCase {

    private final CustomerGateway customerGateway;

    @Inject
    public DefaultEditCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public CustomerOutputData execute(EditCustomerCommand editCustomerCommand) {
        Customer customer = Customer.update(editCustomerCommand.id(), editCustomerCommand.name(), Cpf.of(editCustomerCommand.cpf()), Email.of(editCustomerCommand.email()),
                editCustomerCommand.dateBirth(), editCustomerCommand.currentScore());
        return CustomerOutputData.from(customerGateway.edit(customer));
    }

}

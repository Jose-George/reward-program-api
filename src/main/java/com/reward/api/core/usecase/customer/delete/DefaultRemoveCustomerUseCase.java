package com.reward.api.core.usecase.customer.delete;

import com.reward.api.core.domain.Cpf;
import com.reward.api.core.gateway.CustomerGateway;
import jakarta.inject.Inject;

public class DefaultRemoveCustomerUseCase extends RemoveCustomerUseCase {


    private final CustomerGateway customerGateway;

    @Inject
    public DefaultRemoveCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public RemoveCustomerOutput execute(RemoveCustomerCommand removeCustomerCommand) {
        Cpf cpf = Cpf.of(removeCustomerCommand.cpf());
        customerGateway.delete(cpf);
        return new RemoveCustomerOutput();
    }
}
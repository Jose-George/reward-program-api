package com.reward.api.core.usecase.customer.delete;

import java.util.UUID;

public record RemoveCustomerCommand(String cpf) {

    public static RemoveCustomerCommand with(String cpf) {
        return new RemoveCustomerCommand(cpf);
    }
}

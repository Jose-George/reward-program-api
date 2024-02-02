package com.reward.api.core.usecase.customer.retrieve;

public record FindCustomerCommand(String cpf) {

    public static FindCustomerCommand with(String cpf) {
        return new FindCustomerCommand(cpf);
    }
}

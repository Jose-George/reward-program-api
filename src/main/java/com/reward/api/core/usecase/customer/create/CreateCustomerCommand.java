package com.reward.api.core.usecase.customer.create;

public record CreateCustomerCommand(String name, String cpf, String email,
                                    String dateBirth, Integer currentScore) {

        public static CreateCustomerCommand with(String name, String cpf, String email,
                                                 String dateBirth, Integer currentScore) {
            return new CreateCustomerCommand(name, cpf, email, dateBirth, currentScore);
        }
}

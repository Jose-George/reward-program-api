package com.reward.api.core.usecase.customer.edit;

import java.util.UUID;

public record EditCustomerCommand(UUID id, String name, String cpf, String email,
                                  String dateBirth, Integer currentScore) {

        public static EditCustomerCommand with(UUID id, String name, String cpf, String email,
                                               String dateBirth, Integer currentScore) {
            return new EditCustomerCommand(id, name, cpf, email, dateBirth, currentScore);
        }
}

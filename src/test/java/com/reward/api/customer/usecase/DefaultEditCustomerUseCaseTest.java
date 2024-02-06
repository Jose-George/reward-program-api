package com.reward.api.customer.usecase;

import com.reward.api.core.domain.customer.Cpf;
import com.reward.api.core.domain.customer.Customer;
import com.reward.api.core.domain.customer.Email;
import com.reward.api.core.gateway.CustomerGateway;
import com.reward.api.core.usecase.customer.common.CustomerOutputData;
import com.reward.api.core.usecase.customer.edit.DefaultEditCustomerUseCase;
import com.reward.api.core.usecase.customer.edit.EditCustomerCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DefaultEditCustomerUseCaseTest {

    @Mock
    private CustomerGateway customerGateway;

    @InjectMocks
    private DefaultEditCustomerUseCase editCustomerUseCase;

    @Test
    void executeShouldEditCustomerSuccessfully() {
        // Arrange
        UUID id = UUID.randomUUID();
        String dateOfBirthStr = "1980-12-31";
        EditCustomerCommand command = new EditCustomerCommand(
                id, "Jane Doe", "987.654.321-00", "janedoe@example.com", dateOfBirthStr, 750);
        Customer editedCustomer = Customer.update(id, command.name(), Cpf.of(command.cpf()), Email.of(command.email()),
                dateOfBirthStr, command.currentScore());
        CustomerOutputData expectedOutput = CustomerOutputData.from(editedCustomer);

        when(customerGateway.edit(any(Customer.class))).thenReturn(editedCustomer);

        // Act
        CustomerOutputData result = editCustomerUseCase.execute(command);

        // Assert
        assertEquals(expectedOutput.getId(), result.getId());
        assertEquals(expectedOutput.getName(), result.getName());
        assertEquals(expectedOutput.getCpf(), result.getCpf());
        assertEquals(expectedOutput.getEmail(), result.getEmail());
        assertEquals(expectedOutput.getDateBirth(), result.getDateBirth());
        assertEquals(expectedOutput.getCurrentScore(), result.getCurrentScore());

        verify(customerGateway).edit(any(Customer.class));
    }
}

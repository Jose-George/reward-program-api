package com.reward.api.customer.usecase;

import com.reward.api.core.domain.customer.Cpf;
import com.reward.api.core.gateway.CustomerGateway;
import com.reward.api.core.usecase.customer.delete.DefaultRemoveCustomerUseCase;
import com.reward.api.core.usecase.customer.delete.RemoveCustomerCommand;
import com.reward.api.core.usecase.customer.delete.RemoveCustomerOutput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DefaultRemoveCustomerUseCaseTest {

    @Mock
    private CustomerGateway customerGateway;

    @InjectMocks
    private DefaultRemoveCustomerUseCase removeCustomerUseCase;

    @Test
    void executeShouldDeleteCustomerSuccessfully() {
        // Arrange
        String cpfStr = "123.456.789-00";
        RemoveCustomerCommand command = new RemoveCustomerCommand(cpfStr);

        // Act
        RemoveCustomerOutput output = removeCustomerUseCase.execute(command);

        // Assert
        verify(customerGateway).delete(Cpf.of(cpfStr));
        assertNotNull(output, "Expected non-null RemoveCustomerOutput");
    }
}

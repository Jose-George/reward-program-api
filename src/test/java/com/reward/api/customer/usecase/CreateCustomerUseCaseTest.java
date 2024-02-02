package com.reward.api.customer.usecase;


import com.reward.api.core.gateway.CustomerGateway;
import com.reward.api.core.usecase.customer.create.CreateCustomerCommand;
import com.reward.api.core.usecase.customer.create.DefaultCreateCustomerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;

import static org.mockito.AdditionalAnswers.returnsFirstArg;


@ExtendWith(MockitoExtension.class)
public class CreateCustomerUseCaseTest {

    @InjectMocks
    private DefaultCreateCustomerUseCase useCase;

    @Mock
    private CustomerGateway gateway;

    @Test
    public void givenAValidCommand_whenCreateCustomer_shouldReturnCustomer() {
        final var expectedName = "Francesco Forgione";
        final var expectedCpf = "691.177.780-18";
        final var expectedEmail = "francescoforgione@email.com";
        final var expectedDateBirth = "25/05/1887";
        final var expectedCurrentScore = 0;

        final var command =
                CreateCustomerCommand.with(expectedName, expectedCpf,
                        expectedEmail, expectedDateBirth, expectedCurrentScore);

        Mockito.when(gateway.create(Mockito.any()))
                .thenAnswer(returnsFirstArg());

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Assertions.assertNotNull(actualOutput.getId());

        Mockito.verify(gateway, Mockito.times(1))
                .create(Mockito.argThat(customer ->
                        Objects.equals(expectedName, customer.getName())
                                && Objects.equals(expectedEmail, customer.getEmail().get())
                                && Objects.equals(expectedCpf, customer.getCpf().get())
                                && Objects.equals(expectedDateBirth, customer.getDateBirth())
                ));

    }

    @Test
    public void givenAValidCommand_whenGatewayThrowsException_shouldReturnAException() {
        final var expectedName = "Francesco Forgione";
        final var expectedCpf = "691.177.780-12";
        final var expectedEmail = "francescoforgione@email.com";
        final var expectedDateBirth = "25/05/1887";
        final var expectedCurrentScore = 0;
        final var expectedErrorMessage = "Gateway error";

        final var command =
                CreateCustomerCommand.with(expectedName, expectedCpf,
                        expectedEmail, expectedDateBirth, expectedCurrentScore);

        Mockito.when(gateway.create(Mockito.any()))
                .thenThrow(new IllegalStateException(expectedErrorMessage));

        final var actualException = Assertions.assertThrows(IllegalStateException.class, () -> useCase.execute(command));

        Assertions.assertEquals(expectedErrorMessage, actualException.getMessage());

        Mockito.verify(gateway, Mockito.times(1))
                .create(Mockito.argThat(customer ->
                        Objects.equals(expectedName, customer.getName())

                ));
    }

}

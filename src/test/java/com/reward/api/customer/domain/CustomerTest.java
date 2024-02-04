package com.reward.api.customer.domain;

import com.reward.api.core.domain.customer.Cpf;
import com.reward.api.core.domain.customer.Customer;
import com.reward.api.core.domain.customer.Email;
import com.reward.api.core.exception.CpfException;
import com.reward.api.core.exception.EmailException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void givenCustomerRegister_whenNewCustome_thenSucess() {
        final var expectedName = "Francesco Forgione";
        final var expectedCpf = "691.177.780-18";
        final var expectedEmail = "francescoforgione@email.com";
        final var expectedDateBirth = "25/05/1887";
        final var expectedCurrentScore = 0;

        final var actualCustomer =
                Customer.of(expectedName, Cpf.of(expectedCpf), Email.of(expectedEmail), expectedDateBirth, expectedCurrentScore);


        Assertions.assertNotNull(actualCustomer);
        Assertions.assertNotNull(actualCustomer.getId());
        Assertions.assertNotNull(actualCustomer.getCpf());
        Assertions.assertNotNull(actualCustomer.getEmail());
        Assertions.assertEquals(expectedName, actualCustomer.getName());
        Assertions.assertEquals(expectedCpf, actualCustomer.getCpf().get());
        Assertions.assertEquals(expectedEmail, actualCustomer.getEmail().get());

    }

    @Test
    public void givenCustomerWithInvalidCpf_whenNewInstance_shouldReturnCpfException() {
        final var expectedName = "Francesco Forgione";
        final var expectedCpf = "000.000.000-0";
        final var expectedEmail = "francescoforgione@email.com";
        final var expectedDateBirth = "25/05/1887";
        final var expectedCurrentScore = 0;

        Assertions.assertThrows(CpfException.class, () ->
                Customer.of(expectedName, Cpf.of(expectedCpf), Email.of(expectedEmail), expectedDateBirth, expectedCurrentScore));

    }

    @Test
    public void givenCustomerWithInvalidEmail_whenNewInstance_shouldReturnEmailException() {
        final var expectedName = "Francesco Forgione";
        final var expectedCpf = "691.177.780-18";
        final var expectedEmail = "francescoforgione.email.com";
        final var expectedDateBirth = "25/05/1887";
        final var expectedCurrentScore = 0;

        Assertions.assertThrows(EmailException.class, () ->
                Customer.of(expectedName, Cpf.of(expectedCpf), Email.of(expectedEmail), expectedDateBirth, expectedCurrentScore));

    }

    @Test
    public void givenCustomerWithEmptyName_whenNewInstance_shouldReturnNPE() {
        final var expectedCpf = "691.177.780-18";
        final var expectedEmail = "francescoforgione@email.com";
        final var expectedDateBirth = "25/05/1887";
        final var expectedCurrentScore = 0;

        Assertions.assertThrows(NullPointerException.class, () ->
                Customer.of(null, Cpf.of(expectedCpf), Email.of(expectedEmail), expectedDateBirth, expectedCurrentScore));
    }

    @Test
    public void givenCustomerUpdate_whenNewInstanceUpdate_thenReturnSucess() {
        final var expectedName = "Francesco Forgione 2";
        final var expectedCpf = "691.177.780-18";
        final var expectedEmail = "francescoforgione2@email.com";
        final var expectedDateBirth = "26/05/1887";
        final var expectedCurrentScore = 10;

        var actualCustomer =
                Customer.of("Francesco Forgione", Cpf.of("691.177.780-18"), Email.of("francescoforgione@email.com"),
                        "25/05/1887", 0);

        final var id = actualCustomer.getId();

        actualCustomer = Customer.update(id, expectedName, Cpf.of(expectedCpf), Email.of(expectedEmail), expectedDateBirth, expectedCurrentScore);


        Assertions.assertNotNull(actualCustomer);
        Assertions.assertNotNull(actualCustomer.getId());
        Assertions.assertNotNull(actualCustomer.getCpf());
        Assertions.assertNotNull(actualCustomer.getEmail());
        Assertions.assertEquals(expectedName, actualCustomer.getName());
        Assertions.assertEquals(expectedCpf, actualCustomer.getCpf().get());
        Assertions.assertEquals(expectedEmail, actualCustomer.getEmail().get());
        Assertions.assertEquals(id, actualCustomer.getId());

    }


}

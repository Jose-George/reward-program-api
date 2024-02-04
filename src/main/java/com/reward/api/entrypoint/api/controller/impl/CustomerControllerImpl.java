package com.reward.api.entrypoint.api.controller.impl;

import com.reward.api.core.exception.NotFoundException;
import com.reward.api.core.usecase.customer.common.CustomerOutputData;
import com.reward.api.core.usecase.customer.create.CreateCustomerCommand;
import com.reward.api.core.usecase.customer.create.CreateCustomerUseCase;
import com.reward.api.core.usecase.customer.delete.DefaultRemoveCustomerUseCase;
import com.reward.api.core.usecase.customer.delete.RemoveCustomerCommand;
import com.reward.api.core.usecase.customer.edit.EditCustomerCommand;
import com.reward.api.core.usecase.customer.edit.EditCustomerUseCase;
import com.reward.api.core.usecase.customer.retrieve.FindCustomerCommand;
import com.reward.api.core.usecase.customer.retrieve.FindCustomerUseCase;
import com.reward.api.entrypoint.api.controller.CustomerController;
import com.reward.api.entrypoint.api.model.CustomerModel;
import com.reward.api.entrypoint.api.model.input.CustomerInput;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

@Controller("/customer")
@Validated
public class CustomerControllerImpl implements CustomerController {

    private static Logger logger = LoggerFactory.getLogger(CustomerControllerImpl.class);

    private final CreateCustomerUseCase createCustomerUseCase;

    private final EditCustomerUseCase editCustomerUseCase;

    private final FindCustomerUseCase findCustomerUseCase;

    private final DefaultRemoveCustomerUseCase defaultRemoveCustomerUseCase;

    @Inject
    public CustomerControllerImpl(CreateCustomerUseCase createCustomerUseCase, EditCustomerUseCase editCustomerUseCase, FindCustomerUseCase findCustomerUseCase, DefaultRemoveCustomerUseCase defaultRemoveCustomerUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.editCustomerUseCase = editCustomerUseCase;
        this.findCustomerUseCase = findCustomerUseCase;
        this.defaultRemoveCustomerUseCase = defaultRemoveCustomerUseCase;
    }

    @Post("/create")
    @Override
    public HttpResponse<CustomerModel> create(@Body @Valid CustomerInput customerInput) {
        var customer = createCustomerUseCase.execute(CreateCustomerCommand.with(
                customerInput.name(), customerInput.cpf(),
                customerInput.email(), customerInput.dateBirth(), customerInput.currentScore()));

        return HttpResponse.created(mapToCustomerModel(customer));
    }

    @Put("/edit/{id}")
    @Override
    public HttpResponse<CustomerModel> edit(@PathVariable UUID id, @Body @Valid CustomerInput customerInput) {
        var customer = editCustomerUseCase.execute(EditCustomerCommand.with(id,
                customerInput.name(), customerInput.cpf(),
                customerInput.email(), customerInput.dateBirth(), customerInput.currentScore()));
        return HttpResponse.ok(mapToCustomerModel(customer));
    }

    @Get("/find/{cpf}")
    @Override
    public HttpResponse<CustomerModel> findByCpf(@PathVariable String cpf) {
        try {
            logger.info("findByCpf with CPF = " + cpf);
            var customer = findCustomerUseCase.execute(FindCustomerCommand.with(cpf));
            return HttpResponse.ok(mapToCustomerModel(customer));
        } catch (RuntimeException runtimeException) {
            throw new NotFoundException(runtimeException.getMessage());
        }
    }

    @Delete("/delete/{cpf}")
    @Status(HttpStatus.OK)
    @Override
    public void delete(@PathVariable String cpf) {
        defaultRemoveCustomerUseCase.execute(RemoveCustomerCommand.with(cpf));
    }

    private static CustomerModel mapToCustomerModel(CustomerOutputData customer) {
        return new CustomerModel(customer.getId(), customer.getName(), customer.getEmail(), customer.getCurrentScore());
    }

}

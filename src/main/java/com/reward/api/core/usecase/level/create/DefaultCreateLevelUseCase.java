package com.reward.api.core.usecase.level.create;

import com.reward.api.core.domain.customer.Customer;
import com.reward.api.core.gateway.LevelScoreGateway;
import com.reward.api.core.usecase.customer.common.CustomerOutputData;
import com.reward.api.core.usecase.customer.retrieve.FindCustomerCommand;
import com.reward.api.core.usecase.customer.retrieve.FindCustomerUseCase;
import com.reward.api.core.usecase.level.common.CreateLevelCommand;
import com.reward.api.core.usecase.level.common.LevelOutputData;
import jakarta.inject.Inject;

public class DefaultCreateLevelUseCase extends CreateLevelUseCase{

    private final LevelScoreGateway leavelScoreGateway;
    private final FindCustomerUseCase findCustomerUseCase;

    @Inject
    public DefaultCreateLevelUseCase(LevelScoreGateway leavelScoreGateway, FindCustomerUseCase findCustomerUseCase) {
        this.leavelScoreGateway = leavelScoreGateway;
        this.findCustomerUseCase = findCustomerUseCase;
    }

    @Override
    public LevelOutputData execute(CreateLevelCommand createLevelCommand) {
        CustomerOutputData customer =
                findCustomerUseCase.execute(FindCustomerCommand.with(createLevelCommand.cpf()));
        //validar customerId
        //recuperar o valor de transacoes dos ultimos 30 dias
        return null;
    }
}

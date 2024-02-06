package com.reward.api.core.usecase.customer.level;

import com.reward.api.core.usecase.customer.common.CustomerOutputData;
import com.reward.api.core.usecase.customer.retrieve.FindCustomerCommand;
import com.reward.api.core.usecase.customer.retrieve.FindCustomerUseCase;
import com.reward.api.core.usecase.level.common.LevelOutputData;
import com.reward.api.core.usecase.level.retrive.FindLevelGetByCustomerUseCase;
import jakarta.inject.Inject;

public class DefaultLevelGetScoreUseCase extends LevelGetScoreUseCase{

    private final FindCustomerUseCase findCustomerUseCase;

    private final FindLevelGetByCustomerUseCase findLevelGetByCustomerUseCase;

    @Inject
    public DefaultLevelGetScoreUseCase(FindCustomerUseCase findCustomerUseCase, FindLevelGetByCustomerUseCase findLevelGetByCustomerUseCase) {
        this.findCustomerUseCase = findCustomerUseCase;
        this.findLevelGetByCustomerUseCase = findLevelGetByCustomerUseCase;
    }

    @Override
    public LevelGetOutput execute(LevelGetCommand levelGetCommand) {
        CustomerOutputData customer = findCustomerUseCase.execute(FindCustomerCommand.with(levelGetCommand.cpf()));
        LevelOutputData level = findLevelGetByCustomerUseCase.execute(customer.getId());
        return LevelGetOutput.with(level.getLevel(), customer.getCurrentScore());
    }
}

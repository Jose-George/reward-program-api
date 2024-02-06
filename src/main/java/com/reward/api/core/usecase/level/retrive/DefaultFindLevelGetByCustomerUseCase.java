package com.reward.api.core.usecase.level.retrive;

import com.reward.api.core.exception.DomainException;
import com.reward.api.core.gateway.LevelScoreGateway;
import com.reward.api.core.usecase.level.common.LevelOutputData;
import jakarta.inject.Inject;

import java.util.UUID;

public class DefaultFindLevelGetByCustomerUseCase extends FindLevelGetByCustomerUseCase {

    private final LevelScoreGateway gateway;

    @Inject
    public DefaultFindLevelGetByCustomerUseCase(LevelScoreGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public LevelOutputData execute(UUID customerId) {
        String level = gateway.findByLevelScoreCustomerId(customerId).orElseThrow(() ->
                new DomainException("Error Get Level "));
        return LevelOutputData.from(level);
    }
}

package com.reward.api.core.usecase.customer.retrieve;

import com.reward.api.core.gateway.CustomerGateway;
import com.reward.api.core.usecase.UseCase;
import com.reward.api.core.usecase.customer.common.CustomerOutputData;
import jakarta.inject.Inject;

public abstract class FindCustomerUseCase extends UseCase<FindCustomerCommand, CustomerOutputData> {}

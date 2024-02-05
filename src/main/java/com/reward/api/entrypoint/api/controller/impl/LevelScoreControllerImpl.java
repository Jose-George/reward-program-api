package com.reward.api.entrypoint.api.controller.impl;

import com.reward.api.core.usecase.level.common.CreateLevelCommand;
import com.reward.api.core.usecase.level.common.LevelOutputData;
import com.reward.api.core.usecase.level.create.CreateLevelUseCase;
import com.reward.api.core.usecase.transaction.common.BankTransactionOutput;
import com.reward.api.core.usecase.transaction.create.CreateBankTransactionCommand;
import com.reward.api.core.usecase.transaction.create.CreateBankTransactionUseCase;
import com.reward.api.entrypoint.api.controller.BankTransactionController;
import com.reward.api.entrypoint.api.controller.LevelScoreController;
import com.reward.api.entrypoint.api.model.BankTransactionModel;
import com.reward.api.entrypoint.api.model.LevelModel;
import com.reward.api.entrypoint.api.model.input.BankTransactionInput;
import com.reward.api.entrypoint.api.model.input.LevelInput;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import org.javamoney.moneta.Money;

@Controller("/level")
@Validated
public class LevelScoreControllerImpl implements LevelScoreController {

    private final CreateLevelUseCase createLevelUseCase;

    @Inject
    public LevelScoreControllerImpl(CreateLevelUseCase createLevelUseCase) {
        this.createLevelUseCase = createLevelUseCase;
    }

    @Post("/create")
    @Override
    public HttpResponse<LevelModel> create(@Body @Valid LevelInput levelInput) {
        var levelScore = createLevelUseCase.execute(CreateLevelCommand.with(levelInput.cpf()));
        return HttpResponse.created(mapToLevel(levelScore));
    }

    private static LevelModel mapToLevel(LevelOutputData levelOutputData) {
        return new LevelModel(levelOutputData.getId(), levelOutputData.getLevel());
    }

}

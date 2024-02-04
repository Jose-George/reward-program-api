package com.reward.api.core.usecase.transaction.retrieve;

import com.reward.api.core.usecase.UseCase;
import com.reward.api.core.usecase.transaction.common.BankTransactionOutput;

import java.util.List;

public abstract class FindBankTransactionUseCase extends UseCase<FindBankTransactionCommand, List<BankTransactionOutput>> {
}

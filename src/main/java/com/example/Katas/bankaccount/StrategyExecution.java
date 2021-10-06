package com.example.Katas.bankaccount;

import com.example.Katas.bankaccount.models.Account;
import com.example.Katas.bankaccount.models.Operations;
import org.springframework.stereotype.Component;

@Component
public class StrategyExecution {
    private final DepositOperation depositOperation;
    private final WithdrawalOperation withdrawalOperation;

    public StrategyExecution(final DepositOperation depositOperation, final WithdrawalOperation withdrawalOperation) {
        this.depositOperation = depositOperation;
        this.withdrawalOperation = withdrawalOperation;
    }

    public Account execute(final Account account) {
        return account.getOperation().equals(Operations.DEPOSIT) ?
                depositOperation.makeOperation(account) : withdrawalOperation.makeOperation(account);

    }
}

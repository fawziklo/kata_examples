package com.example.Katas.bankaccount;

import com.example.Katas.bankaccount.models.Account;
import org.springframework.stereotype.Component;

@Component
public class DepositOperation implements OperationStrategy {

    @Override
    public Account makeOperation(final Account myAccount) {
        double newAccountBalance = myAccount.getBalance() + myAccount.getAmount();
        myAccount.setBalance(newAccountBalance);
        return myAccount;
    }

}

package com.example.Katas.bankaccount;

import com.example.Katas.bankaccount.models.Account;

public interface OperationStrategy {
    Account makeOperation(Account account);
}

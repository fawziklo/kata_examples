package com.example.Katas;

import com.example.Katas.bankaccount.DepositOperation;
import com.example.Katas.bankaccount.StrategyExecution;
import com.example.Katas.bankaccount.WithdrawalOperation;
import com.example.Katas.bankaccount.models.Account;
import com.example.Katas.bankaccount.DisplayService;
import com.example.Katas.bankaccount.models.Operations;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BankAccountTest {

    @Test
    public void should_make_deposit_in_my_account() {
        //GIVEN
        Account myAccount = new Account();
        myAccount.setBalance(5000);
        //WHEN
        myAccount.setAmount(1000);
        DepositOperation depositOperation = new DepositOperation();

        //THEN
        Account result = depositOperation.makeOperation(myAccount);

        assertEquals(result.getBalance(), 6000);
    }

    @Test
    public void should_make_withdrawal_from_my_account() {
        //GIVEN
        Account myAccount = new Account();
        myAccount.setBalance(5000);
        //WHEN
        myAccount.setAmount(1000);

        //THEN
        WithdrawalOperation withdrawalOperation = new WithdrawalOperation();
        Account result = withdrawalOperation.makeOperation(myAccount);

        assertEquals(result.getBalance(), 4000);
    }

    @Test
    public void should_print_the_history_of_one_deposit_operation(){
        //GIVEN
        Account myAccount = new Account();

        myAccount.setBalance(5000);
        LocalDateTime timeOp = LocalDateTime.now();
        myAccount.setDate(timeOp);

        //WHEN
        myAccount.setAmount(1000);
        myAccount.setOperation(Operations.DEPOSIT);

        WithdrawalOperation withdrawalOperation = new WithdrawalOperation();
        DepositOperation depositOperation = new DepositOperation();

        StrategyExecution strategyExecution = new StrategyExecution(depositOperation,withdrawalOperation);
        strategyExecution.execute(myAccount);

        List<Account> accountOperations = new ArrayList<>();
        accountOperations.add(myAccount);

        DisplayService displayService = new DisplayService();

        //THEN
        String result = displayService.displayHistoryOperations(accountOperations);

        assertEquals(result,"you've made a DEPOSIT with an amount of 1000.0 at 22:13:00, your actual balance is : 6000.0");
    }
}

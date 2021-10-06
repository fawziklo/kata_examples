package com.example.Katas;

import com.example.Katas.bankaccount.DepositOperation;
import com.example.Katas.bankaccount.DisplayService;
import com.example.Katas.bankaccount.StrategyExecution;
import com.example.Katas.bankaccount.WithdrawalOperation;
import com.example.Katas.bankaccount.models.Account;
import com.example.Katas.bankaccount.models.Operations;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    public void should_print_the_history_of_one_deposit_operation() {
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

        StrategyExecution strategyExecution = new StrategyExecution(depositOperation, withdrawalOperation);
        strategyExecution.execute(myAccount);

        List<Account> accountOperations = new ArrayList<>();
        accountOperations.add(myAccount);

        DisplayService displayService = new DisplayService();

        //THEN
        //List<String> result = displayService.displayHistoryOperations(accountOperations);

        //assertEquals(result.get(0), "you've made a DEPOSIT with an amount of 1000.0 at 22:13:00, your actual balance is : 6000.0");
    }

    @Test
    public void should_print_the_history_of_one_withdrawal_operation() {
        //GIVEN
        Account myAccount = new Account();

        myAccount.setBalance(5000);
        LocalDateTime timeOp = LocalDateTime.now();
        myAccount.setDate(timeOp);

        //WHEN
        myAccount.setAmount(1000);
        myAccount.setOperation(Operations.WITHDRAWAL);

        WithdrawalOperation withdrawalOperation = new WithdrawalOperation();
        DepositOperation depositOperation = new DepositOperation();
        StrategyExecution strategyExecution = new StrategyExecution(depositOperation, withdrawalOperation);

        strategyExecution.execute(myAccount);

        List<Account> accountOperations = new ArrayList<>();
        accountOperations.add(myAccount);

        DisplayService displayService = new DisplayService();

        //THEN
        //List<String> result = displayService.displayHistoryOperations(accountOperations);
        //assertEquals(result.get(0), "you've made a WITHDRAWAL with an amount of 1000.0 at 22:13:00, your actual balance is : 4000.0");
    }

    @Test
    public void should_print_the_history_of_all_operation() {
        //GIVEN
        Account myAccount = new Account();
        WithdrawalOperation withdrawalOperation = new WithdrawalOperation();
        DepositOperation depositOperation = new DepositOperation();
        StrategyExecution strategyExecution = new StrategyExecution(depositOperation, withdrawalOperation);
        List<String> accountOperations = new ArrayList<>();
        DisplayService displayService = new DisplayService();

        myAccount.setBalance(5000);
        Operations[] ops = {Operations.DEPOSIT, Operations.WITHDRAWAL};
        double[] amounts = {1000, 2000};
        String result = "";
        for (int i = 0; i < ops.length; i++) {
            LocalDateTime timeOp = LocalDateTime.now();
            myAccount.setDate(timeOp);

            //WHEN
            myAccount.setAmount(amounts[i]);
            myAccount.setOperation(ops[i]);

            Account updateMyAccount = strategyExecution.execute(myAccount);
            result = displayService.displayHistoryOperations(Arrays.asList(updateMyAccount));
            accountOperations.add(result);
        }



        //THEN
        //List<String result = displayService.displayHistoryOperations(result);
        assertNotNull(result);
        assertEquals(accountOperations.get(0),"you've made a DEPOSIT with an amount of 1000.0 at 22:13:00, your actual balance is : 6000.0");
        assertEquals(accountOperations.get(1),"you've made a WITHDRAWAL with an amount of 2000.0 at 22:13:00, your actual balance is : 4000.0");


    }
}

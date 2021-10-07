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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class BankAccountTest {

    @Test
    public void should_make_deposit_in_my_account() {
        //GIVEN
        Account account = new Account();
        account.setBalance(5000);
        //WHEN
        account.setAmount(1000);
        DepositOperation depositOperation = new DepositOperation();

        //THEN
        Account result = depositOperation.makeOperation(account);

        assertEquals(result.getBalance(), 6000);
    }

    @Test
    public void should_make_withdrawal_from_my_account() {
        //GIVEN
        Account account = new Account();
        account.setBalance(5000);
        //WHEN
        account.setAmount(1000);

        //THEN
        WithdrawalOperation withdrawalOperation = new WithdrawalOperation();
        Account result = withdrawalOperation.makeOperation(account);

        assertEquals(result.getBalance(), 4000);
    }

    @Test
    public void should_print_the_history_of_one_deposit_operation() {
        //GIVEN
        Account account = new Account();
        WithdrawalOperation withdrawalOperation = new WithdrawalOperation();
        DepositOperation depositOperation = new DepositOperation();
        StrategyExecution strategyExecution = new StrategyExecution(depositOperation, withdrawalOperation);
        DisplayService displayService = new DisplayService();

        account.setBalance(5000);
        LocalDateTime opTime = LocalDateTime.now();
        account.setDate(opTime);

        //WHEN
        account.setAmount(1000);
        account.setOperation(Operations.DEPOSIT);

        Account updateAccount = strategyExecution.execute(account);

        //THEN
        String result = displayService.displayHistoryOperations(updateAccount);
        assertEquals(opTime, account.getDate());
        assertEquals(result, "you've made a DEPOSIT with an amount of 1000.0 at 22:13:00, your actual balance is : 6000.0");
    }

    @Test
    public void should_print_the_history_of_one_withdrawal_operation() {
        //GIVEN
        Account account = new Account();
        WithdrawalOperation withdrawalOperation = new WithdrawalOperation();
        DepositOperation depositOperation = new DepositOperation();
        StrategyExecution strategyExecution = new StrategyExecution(depositOperation, withdrawalOperation);
        DisplayService displayService = new DisplayService();

        account.setBalance(5000);
        LocalDateTime opTime = LocalDateTime.now();
        account.setDate(opTime);

        //WHEN
        account.setAmount(1000);
        account.setOperation(Operations.WITHDRAWAL);
        Account updateAccount = strategyExecution.execute(account);

        //THEN
        String result = displayService.displayHistoryOperations(updateAccount);

        assertEquals(opTime, account.getDate());
        assertEquals(result, "you've made a WITHDRAWAL with an amount of 1000.0 at 22:13:00, your actual balance is : 4000.0");
    }

    @Test
    public void should_print_the_history_of_all_operation() {
        //GIVEN
        Account account = new Account();
        WithdrawalOperation withdrawalOperation = new WithdrawalOperation();
        DepositOperation depositOperation = new DepositOperation();
        StrategyExecution strategyExecution = new StrategyExecution(depositOperation, withdrawalOperation);
        List<String> accountOperationsHistory = new ArrayList<>();
        DisplayService displayService = new DisplayService();

        //WHEN
        account.setBalance(5000);
        Operations[] ops = {Operations.DEPOSIT, Operations.WITHDRAWAL};
        double[] amounts = {1000, 2000};
        LocalDateTime opTime = null;

        for (int i = 0; i < ops.length; i++) {
            opTime = LocalDateTime.now();
            account.setDate(opTime);

            account.setAmount(amounts[i]);
            account.setOperation(ops[i]);

            Account updateAccount = strategyExecution.execute(account);
            String opHistory = displayService.displayHistoryOperations(updateAccount);

            accountOperationsHistory.add(opHistory);
        }

        //THEN
        assertNotNull(accountOperationsHistory);
        assertEquals(opTime, account.getDate());
        assertEquals(accountOperationsHistory.get(0), "you've made a DEPOSIT with an amount of 1000.0 at 22:13:00, your actual balance is : 6000.0");
        assertEquals(accountOperationsHistory.get(1), "you've made a WITHDRAWAL with an amount of 2000.0 at 22:13:00, your actual balance is : 4000.0");
    }
}

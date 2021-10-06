package com.example.Katas;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;

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

        //THEN
        Account result = myAccount.makeDeposit(myAccount);

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
        Account result = myAccount.makeWithdrawal(myAccount);

        assertEquals(result.getBalance(), 4000);
    }

    @Test
    public void should_print_the_history_of_all_operations(){
        //GIVEN
        Account myAccount = new Account();
        myAccount.setBalance(5000);
        LocalDateTime timeOp = LocalDateTime.now();
        myAccount.setDate(timeOp);

        //WHEN
        myAccount.setAmount(1000);

        AccountOperations accountOperations = new AccountOperations();

        //THEN



    }
}

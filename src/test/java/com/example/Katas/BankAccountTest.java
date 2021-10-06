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
        myAccount.setDate(LocalDateTime.now());

        //WHEN
        myAccount.setAmount(1000);

        //THEN
        Account result = myAccount.makeDeposit(myAccount);

        assertEquals(result.getBalance(), 6000);
    }
}

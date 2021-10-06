package com.example.Katas;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BankAccountTest {
    private final double DEPOSIT = 20000;

    @Test
    public void should_make_deposit_in_my_account() {
        //GIVEN
        //WHEN
        Account myAccount = new Account();

        //THEN
        Double myDeposit = myAccount.makeDeposit(DEPOSIT);
        assertEquals(myDeposit, 20000);
    }
}

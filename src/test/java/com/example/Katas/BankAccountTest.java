package com.example.Katas;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BankAccountTest {

    @Test
    public void should_make_deposit_in_my_account() {
        Account myAccount = new Account();
        Double myDeposit = myAccount.makeDeposit();
        assertEquals(myDeposit,"2000");
    }
}

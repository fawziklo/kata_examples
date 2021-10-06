package com.example.Katas;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Account {
    private double amount;
    private double balance;
    private LocalDateTime date;
    private Operations operation;


    public Account makeDeposit(final Account myAccount) {
        double newAccountBalance = myAccount.balance + myAccount.amount;
        myAccount.setBalance(newAccountBalance);
        return myAccount;
    }

    public Account makeWithdrawal(Account myAccount) {
        double newAccountBalance = myAccount.balance - myAccount.amount;
        myAccount.setBalance(newAccountBalance);
        return myAccount;
    }
}

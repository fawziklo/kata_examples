package com.example.Katas.bankaccount.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Account {
    private double amount;
    private double balance;
    private LocalDateTime date;
    private Operations operation;
}

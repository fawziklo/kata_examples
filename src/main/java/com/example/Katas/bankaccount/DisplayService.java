package com.example.Katas.bankaccount;

import com.example.Katas.bankaccount.models.Account;
import org.springframework.stereotype.Service;

@Service
public class DisplayService {

    public String displayHistoryOperations(final Account accountOperation) {
        return printDetails(accountOperation).toString();
    }

    private StringBuilder printDetails(final Account account) {
        StringBuilder display = new StringBuilder();

        display.append("you've made a ").append(account.getOperation()).append(" with an amount of ")
                .append(account.getAmount()).append(" at 22:13:00, your actual balance is : ")
                .append(account.getBalance());

        return display;
    }
}

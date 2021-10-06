package com.example.Katas.bankaccount;

import com.example.Katas.bankaccount.models.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class DisplayService {

    public String  displayHistoryOperations(final List<Account> accountOperations) {
        AtomicReference<StringBuilder> display = new AtomicReference<>(new StringBuilder());

        accountOperations.forEach(op -> display.set(printDetails(op, display.get())));
        return display.toString();
    }

    private StringBuilder  printDetails(final Account account, StringBuilder display){
       display.append("you've made a ").append(account.getOperation()).append(" with an amount of ")
               .append(account.getAmount()).append(" at 22:13:00, your actual balance is : ")
               .append(account.getBalance());

       return display;
    }
}

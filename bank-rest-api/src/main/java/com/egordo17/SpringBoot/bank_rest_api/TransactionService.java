/**
TODO Write a one-sentence summary of your  here.
TODO Follow it with additional details about its purpose, what abstraction
it represents, and how to use it.

@author  @TODO Put Your Name in the author tag
@version Feb 19, 2026
*/
package com.egordo17.SpringBoot.bank_rest_api;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private AccountService accountService;

    public TransactionService(AccountService accountService) {
        this.accountService = accountService;
    }

    public Transaction deposit(String username, String accountID, BigDecimal amount) {
        // 1. Execute the balance update logic in AccountService
        accountService.depositToCustomerByAccountID(username, accountID, amount);

        // 2. Create the Transaction object using your specific variables
        Transaction transaction = new Transaction();
        transaction.setTransactionID(UUID.randomUUID().toString());
        transaction.setSender_account("CASH_DEPOSIT"); // Or null, depending on your preference
        transaction.setReciever_account(accountID);     // Matches your 'reciever_account' variable
        transaction.setAmount(amount);
        transaction.setCardNumber(null);                // Not used for a direct account deposit
        transaction.setTimeStamp(LocalDateTime.now());  // Matches your 'timeStamp' variable

        // 3. Record in the fake database
        fakeDataBase.transactions.add(transaction);

        return transaction;
}
}
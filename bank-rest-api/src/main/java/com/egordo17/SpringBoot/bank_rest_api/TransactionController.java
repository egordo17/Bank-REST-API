/**
TODO Write a one-sentence summary of your  here.
TODO Follow it with additional details about its purpose, what abstraction
it represents, and how to use it.

@author  @TODO Put Your Name in the author tag
@version Feb 19, 2026
*/
package com.egordo17.SpringBoot.bank_rest_api;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

   
    @PostMapping("/Transactions/{username}/{accountID}/deposit")
    public ResponseEntity<Transaction> deposit(@PathVariable String username, @PathVariable String accountID, @RequestBody BigDecimal amount) {
        
        Transaction transaction = transactionService.deposit(username, accountID, amount);
        return ResponseEntity.ok(transaction);
    }

   
    @GetMapping("/Transactions/Account/{accountID}")
    public List<Transaction> getTransactionHistory(@PathVariable String accountID) {
        return fakeDataBase.transactions.stream()
                .filter(t -> accountID.equals(t.getSender_account()) || 
                             accountID.equals(t.getReciever_account()))
                .collect(Collectors.toList());
    }

   
    @GetMapping("/Transactions")
    public List<Transaction> getAllTransactions() {
        return fakeDataBase.transactions;
    }
}

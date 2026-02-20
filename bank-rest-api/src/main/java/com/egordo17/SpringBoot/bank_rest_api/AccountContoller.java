
/**
TODO Write a one-sentence summary of your  here.
TODO Follow it with additional details about its purpose, what abstraction
it represents, and how to use it.

@author  @TODO Put Your Name in the author tag
@version Feb 11, 2026
*/
package com.egordo17.SpringBoot.bank_rest_api;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class AccountContoller {
    
    private AccountService accountService;

    public AccountContoller(AccountService accountService){
        this.accountService = accountService;
    }

    @RequestMapping("/Customer/{customerUsername}/Accounts")
    public List<Account> retrieveAllCustomerAccounts(@PathVariable String customerUsername){
        return accountService.retrieveAllCustomerAccounts(customerUsername);
    }

    @RequestMapping("/Customer/{customerUsername}/Accounts/{accountID}")
    public Account retrieveCustomerAccountByID(@PathVariable String customerUsername, @PathVariable String accountID){
        Account account = accountService.retrieveCustomerAccountByID(customerUsername, accountID);

        if(account == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return account;
    }

    @RequestMapping(value = "/Customer/{customerUsername}/Accounts", method = RequestMethod.POST)
    public ResponseEntity<Object> createNewAccount(@PathVariable String customerUsername){
        String savedAccount = accountService.createNewAccount(customerUsername);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{savedAccount}").buildAndExpand(savedAccount).toUri();
        return ResponseEntity.created(location).build();
    }

   @RequestMapping(value = "/Customer/{customerUsername}/Accounts/{accountID}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCustomerAccountByID(@PathVariable String customerUsername, @PathVariable String accountID){
          accountService.deleteCustomerAccountByID(customerUsername, accountID);
          return ResponseEntity.noContent().build();
    }
    @RequestMapping(value = "/Customer/{customerUsername}/Accounts/{accountID}/Deposit", method = RequestMethod.PUT)
    public ResponseEntity<Object> depositToCustomerByAccountID(@PathVariable String customerUsername, @PathVariable String accountID, @PathVariable BigDecimal amount){
        accountService.depositToCustomerByAccountID(customerUsername, accountID, amount);
        return ResponseEntity.ok().build();
    }
    @RequestMapping(value = "/Customer/{customerUsername}/Accounts/{accountID}/Withdraw", method = RequestMethod.PUT)
    public ResponseEntity<Object> withdrawFromCustomerByAccountID(@PathVariable String customerUsername, @PathVariable String accountID, @PathVariable BigDecimal amount){
        accountService.withdrawFromCustomerByAccountID(customerUsername, accountID, amount);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/Customer/{customerUsername}/Accounts/{accountID}/Status", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCustomerAccountStatusByID(@PathVariable String customerUsername, @PathVariable String accountID, @PathVariable AccountStatus accountStatus){
        accountService.updateCustomerAccountStatusByID(customerUsername, accountID, accountStatus);
        return ResponseEntity.ok().build();
    }


    

}

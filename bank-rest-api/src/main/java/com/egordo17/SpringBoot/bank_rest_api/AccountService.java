
/**
TODO Write a one-sentence summary of your  here.
TODO Follow it with additional details about its purpose, what abstraction
it represents, and how to use it.

@author  @TODO Put Your Name in the author tag
@version Feb 11, 2026
*/
package com.egordo17.SpringBoot.bank_rest_api;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AccountService {
   
    
    public List<Account> retrieveAllCustomerAccounts(String customerUsername) {
      
        List<Customer> customers = fakeDataBase.customers;
         Predicate<? super Customer> predicate = c -> c.getCustomerUsername().equalsIgnoreCase(customerUsername);
         Optional<Customer> optional = customers.stream().filter(predicate).findFirst();
         return optional.get().getAccounts();
        
    }
    public Account retrieveCustomerAccountByID(String customerUsername, String accountID) {
        
        Predicate<? super Account> predicate = a -> a.getAccountID().equalsIgnoreCase(accountID);
        Optional<Account> optionalAccount = retrieveAllCustomerAccounts(customerUsername).stream()
                                                        .filter(predicate)
                                                        .findFirst();

        if(optionalAccount.isEmpty()){
            return null;
        }
                                                        
        return optionalAccount.get();
    }

    public String generetdRandomID(){
        SecureRandom secureRandom = new SecureRandom();
        String randomID = new BigInteger(32, secureRandom).toString();
        return randomID;
        }


    public String createNewAccount(String customerUsername) {
        // TODO Auto-generated method stub
        Account newAccount = new Account();

        newAccount.setAccountID(generetdRandomID());
        SecureRandom secureRandom = new SecureRandom();
        int charVal1 = secureRandom.nextInt(65,91);
        int charVal2 = secureRandom.nextInt(65,91);
        int charNum = secureRandom.nextInt(1000, 100001);
        String accountNumber = (char)charVal1 + (char)charVal2 + "-" + charNum;
        newAccount.setAccountNumber(accountNumber);
        newAccount.setBalance(BigDecimal.valueOf(0.00));
        newAccount.setCurrencyType("USD");
        newAccount.setAccountStatus(AccountStatus.ACTIVE);
        Predicate<? super Customer> predicate = c -> c.getCustomerUsername().equalsIgnoreCase(customerUsername);
        Optional<Customer> optional = fakeDataBase.customers.stream().filter(predicate).findFirst();
        optional.get().getAccounts().add(newAccount);
        return newAccount.getAccountID();
    }
    public void deleteCustomerAccountByID(String customerUsername, String accountID) {
        // TODO Auto-generated method stub
        List<Account> accounts = retrieveAllCustomerAccounts(customerUsername);
        if(accounts == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found");
        }
        Predicate<? super Account> predicate = a -> a.getAccountID().equalsIgnoreCase(accountID);
        accounts.removeIf(predicate);
    }
    public void depositToCustomerByAccountID(String customerUsername, String accountID, BigDecimal amount) {
        // TODO Auto-generated method stub
        Account account = retrieveCustomerAccountByID(customerUsername, accountID);
        if(account == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found");
        }
        if(account.getAccountStatus() != AccountStatus.ACTIVE){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Account is not active");
        }
        if(amount.compareTo(BigDecimal.ZERO) <= 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Deposit amount must be greater than zero");
        }

        account.setBalance(account.getBalance().add(amount));
    }

    public void withdrawFromCustomerByAccountID(String customerUsername, String accountID, BigDecimal amount) {
        // TODO Auto-generated method stub
        Account account = retrieveCustomerAccountByID(customerUsername, accountID);
        if(account == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found");
        }
        if(account.getAccountStatus() != AccountStatus.ACTIVE){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Account is not active");
        }
        if(account.getBalance().compareTo(amount) < 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insufficient funds");
        }
        account.setBalance(amount.subtract(account.getBalance()));
    }
    public void updateCustomerAccountStatusByID(String customerUsername, String accountID,
            AccountStatus accountStatus) {
        // TODO Auto-generated method stub
        Account account = retrieveCustomerAccountByID(customerUsername, accountID);
        if(account == null){
            throw new ResponseStatusException(null, "Account not found");
        }
        account.setAccountStatus(accountStatus);
    }

    
   
   
}

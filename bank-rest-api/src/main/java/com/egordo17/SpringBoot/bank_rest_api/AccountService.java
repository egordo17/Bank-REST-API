
/**
TODO Write a one-sentence summary of your  here.
TODO Follow it with additional details about its purpose, what abstraction
it represents, and how to use it.

@author  @TODO Put Your Name in the author tag
@version Feb 11, 2026
*/
package com.egordo17.SpringBoot.bank_rest_api;

import java.io.ObjectInputFilter.Status;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

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
   
   
}

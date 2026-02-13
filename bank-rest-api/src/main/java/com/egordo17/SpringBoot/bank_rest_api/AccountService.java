
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private static List<Account> fakeAccounts = new ArrayList();
    static {
        //Initial Test Data
        fakeAccounts.add(new Account("1", "CH-9920", BigDecimal.valueOf(1250.00), "USD", AccountStatus.ACTIVE));
        fakeAccounts.add(new Account("2", "SV-1104", BigDecimal.valueOf(50000.00), "USD", AccountStatus.ACTIVE));
        fakeAccounts.add(new Account("3", "CH-4452", BigDecimal.valueOf(12.50), "USD", AccountStatus.FROZEN));
    }
    public List<Account> retrieveAllAccounts() {
        // TODO Auto-generated method stub
        return fakeAccounts;
    }
    public Account retrieveAccountByID(String accountID) {
        // TODO Auto-generated method stub
        Predicate<? super Account> predicate = a -> a.getAccountID().equalsIgnoreCase(accountID);
        Optional<Account> optionalAccount = fakeAccounts.stream()
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
    public String createNewAccount() {
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

        fakeAccounts.add(newAccount);
        return newAccount.getAccountID();
    }
}

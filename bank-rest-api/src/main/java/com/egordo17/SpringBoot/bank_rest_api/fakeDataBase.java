
/**
TODO Write a one-sentence summary of your  here.
TODO Follow it with additional details about its purpose, what abstraction
it represents, and how to use it.

@author  @TODO Put Your Name in the author tag
@version Feb 18, 2026
*/
package com.egordo17.SpringBoot.bank_rest_api;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class fakeDataBase {
    
public static List<Customer> customers = new ArrayList<>();
public static List<Card> cards = new ArrayList<>();
public static List<Account> c1Accounts = new ArrayList<>();
public static List<Account> c2Accounts = new ArrayList<>();
public static List<Account> c3Accounts = new ArrayList<>();
public static List<Transaction> transactions;
static{
    Customer c1 = new Customer(
        "Jordan", "Michael", "Smith", 
        "1985-05-12", "SSN", "999-00-1234", "2030-01-01",
        "j.smith@example.com", "555-010-8899", "123 Maple St, Springfield, IL",
        "jsmith85", "P@ssword123",
        "Employed", "Tech Solutions Inc.", 85000, "Salary", c1Accounts
    );
    
    Account c1Account1 = new Account("1", "CH-9920", BigDecimal.valueOf(1250.00), "USD", AccountStatus.ACTIVE);
    c1.getAccounts().add(c1Account1);
    customers.add(c1);
    cards.add(new Card("4532-1111-2222-3333", "1", "12/28", true));
    cards.add(new Card("4111-2222-3333-4444","1", "09/27",true ));
    Customer c2 = new Customer("Elena", "Sofia", "Rodriguez", 
            "1992-11-23", "Passport", "A12345678", "2028-06-15",
            "elena.rod@provider.net", "555-012-4455", "742 Evergreen Terrace, Portland, OR",
            "erodriguez", "Secure!2026",
            "Self-Employed", "Freelance Design", 120000, "Business Revenue", c2Accounts);

    Account c2Account1 = new Account("2", "SV-1104", BigDecimal.valueOf(50000.00), "USD", AccountStatus.ACTIVE);
    Account c2Account2 = new Account("3", "CH-4452", BigDecimal.valueOf(12.50), "USD", AccountStatus.FROZEN);

    c2.getAccounts().add(c2Account1);
    c2.getAccounts().add(c2Account2);
    customers.add(c2);
    cards.add(new Card("4000-8888-9999-0000", "2", "05/29", true));
    cards.add(new Card("5105-4444-5555-6666", "3", "11/27", false));
    Customer c3 = new Customer("Marcus", "Tyrone", "Johnson", 
            "1978-02-04", "Driver's License", "D987654321", "2027-10-10",
            "marcus.j@webmail.com", "555-044-3322", "888 Skyline Blvd, Austin, TX",
            "mjohnson78", "HiddenPath77",
            "Employed", "Global Logistics Corp", 65000, "Salary", c3Accounts);
    customers.add(c3);
    

    
    
}
    
}

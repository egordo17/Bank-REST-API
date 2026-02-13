
/**
TODO Write a one-sentence summary of your  here.
TODO Follow it with additional details about its purpose, what abstraction
it represents, and how to use it.

@author  @TODO Put Your Name in the author tag
@version Feb 13, 2026
*/
package com.egordo17.SpringBoot.bank_rest_api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
@Service
public class CustomerService {

    private static List<Customer> fakeCustomers = new ArrayList();

    static{

        Customer c1 = new Customer(
            "Jordan", "Michael", "Smith", 
            "1985-05-12", "SSN", "999-00-1234", "2030-01-01",
            "j.smith@example.com", "555-010-8899", "123 Maple St, Springfield, IL",
            "jsmith85", "P@ssword123",
            "Employed", "Tech Solutions Inc.", 85000, "Salary"
        );
        fakeCustomers.add(c1);

        Customer c2 = new Customer("Elena", "Sofia", "Rodriguez", 
                "1992-11-23", "Passport", "A12345678", "2028-06-15",
                "elena.rod@provider.net", "555-012-4455", "742 Evergreen Terrace, Portland, OR",
                "erodriguez", "Secure!2026",
                "Self-Employed", "Freelance Design", 120000, "Business Revenue");
        fakeCustomers.add(c2);

        Customer c3 = new Customer("Marcus", "Tyrone", "Johnson", 
                "1978-02-04", "Driver's License", "D987654321", "2027-10-10",
                "marcus.j@webmail.com", "555-044-3322", "888 Skyline Blvd, Austin, TX",
                "mjohnson78", "HiddenPath77",
                "Employed", "Global Logistics Corp", 65000, "Salary");
        fakeCustomers.add(c3);
    }

    public List<Customer> retrieveAllCustomers() {
        
        return fakeCustomers;
    }

    public Customer retrieveCustomerByUsername(String customerUsername) {
        // TODO Auto-generated method stub
        Predicate<? super Customer> predicate = customer -> customer.getCustomerUsername().equalsIgnoreCase(customerUsername);
        Optional<Customer> optional = fakeCustomers.stream().filter(predicate).findFirst();

        if(optional == null){
            return null;
        }
        return optional.get();
    }

    public ResponseEntity<Object> updateCustomerByUsername(String customerUsername, Customer updatedCustomer) {
        
        Customer existingCustomer = retrieveCustomerByUsername(customerUsername);
       
        existingCustomer.setCustomerUsername(updatedCustomer.getCustomerUsername());
        existingCustomer.setPhone_number(updatedCustomer.getPhone_number());
        existingCustomer.setPhysicalAddress(updatedCustomer.getPhysicalAddress());
        existingCustomer.setEmployerName(updatedCustomer.getEmploymentStatus());
        existingCustomer.setIncomeRange(updatedCustomer.getIncomeRange());

        return ResponseEntity.ok().build();
    }

   


}

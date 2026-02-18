
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

    private static List<Customer> fakeCustomers = fakeDataBase.customers;

    
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

    public void registerNewCustomer(Customer newCustomer) {
        // TODO Auto-generated method stub
        fakeCustomers.add(newCustomer);
    }

    public void deleteCustomerByUsername(String customerUsername) {
        // TODO Auto-generated method stub
        List<Customer> fakeCustomers = retrieveAllCustomers();
        if(fakeCustomers == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
        }
        Predicate<? super Customer> predicate = customerUsername1 -> customerUsername1.getCustomerUsername().equalsIgnoreCase(customerUsername);
        fakeCustomers.removeIf(predicate);
    }

    

   


}

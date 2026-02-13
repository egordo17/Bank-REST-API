
/**
TODO Write a one-sentence summary of your  here.
TODO Follow it with additional details about its purpose, what abstraction
it represents, and how to use it.

@author  @TODO Put Your Name in the author tag
@version Feb 13, 2026
*/
package com.egordo17.SpringBoot.bank_rest_api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    
    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    
    @RequestMapping("/Customers")
    public List<Customer> retrieveAllCustomers(){
        return customerService.retrieveAllCustomers();
    }

    @RequestMapping("/Customers/{customerUsername}")
    public Customer retrieveCustomerByUsername(@PathVariable String customerUsername){
        return customerService.retrieveCustomerByUsername(customerUsername);
    }

    @RequestMapping("/Customer/{customerUsername}")
    public ResponseEntity<Object> updateCustomerByUsername(@PathVariable String customerUsername, @PathVariable Customer updatedCustomer){
        customerService.updateCustomerByUsername(customerUsername, updatedCustomer);
        return ResponseEntity.noContent().build();
    }
}

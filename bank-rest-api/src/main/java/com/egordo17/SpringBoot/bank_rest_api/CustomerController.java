
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
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value ="/Customers/Customer/{customerUsername}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCustomerByUsername(@PathVariable String customerUsername, @PathVariable Customer updatedCustomer){
        customerService.updateCustomerByUsername(customerUsername, updatedCustomer);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/Customers/Customer", method = RequestMethod.POST)
    public void registerNewCustomer(@PathVariable Customer newCustomer){
        customerService.registerNewCustomer(newCustomer);
    }

    @RequestMapping(value = "/Customers/Customer/{customerUsername}", method = RequestMethod.DELETE)
    public void deleteCustomerByUsername(@PathVariable String customerUsername){
        customerService.deleteCustomerByUsername(customerUsername);
    }


}

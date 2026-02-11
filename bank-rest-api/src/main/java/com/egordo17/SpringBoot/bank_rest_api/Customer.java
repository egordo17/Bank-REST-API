
/**
TODO Write a one-sentence summary of your  here.
TODO Follow it with additional details about its purpose, what abstraction
it represents, and how to use it.

@author  @TODO Put Your Name in the author tag
@version Feb 04, 2026
*/
package com.egordo17.SpringBoot.bank_rest_api;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Customer {


    //Customers full name
    private String first_name;
    private String middle_name;
    private String last_name;
    //Date of birth
    private String date_of_birth;
    //Government ID
    private String id_type;// SSN , Passport, Driver's License
    private String id_number;
    private String expiry_date;
    //Contact information
    private String email;
    private String phone_number;
    private String physical_address;
 
    private String username;
    private String password;
    //Employment and financial Profile
    private String employment_status;
    private String employer_name;
    private int income_range;
    private String source_of_wealth;

 
 
 
 
}

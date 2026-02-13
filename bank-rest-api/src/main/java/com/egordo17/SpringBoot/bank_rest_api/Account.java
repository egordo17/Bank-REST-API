
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

import java.math.BigDecimal;

import lombok.AllArgsConstructor;


@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Account {
    private String accountID;             
    private String accountNumber;
    private BigDecimal balance;
    private String currencyType;
    private AccountStatus accountStatus;
}

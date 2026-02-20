
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
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;


@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Transaction {
    private String transactionID;
    private String sender_account;
    private String reciever_account;
    private BigDecimal amount;
    private String cardNumber;
    private LocalDateTime timeStamp;

}

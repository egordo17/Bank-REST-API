/**
TODO Write a one-sentence summary of your  here.
TODO Follow it with additional details about its purpose, what abstraction
it represents, and how to use it.

@author  @TODO Put Your Name in the author tag
@version Feb 19, 2026
*/
package com.egordo17.SpringBoot.bank_rest_api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CardController {
    private CardService cardService;

    // 2. Inject the service via Constructor
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @RequestMapping("/Cards")
    public String retrieveAllCardsOfAccount(){
        return retrieveAllCardsOfAccount();
    }

    @RequestMapping(value = "/Cards/{cardNumber}",method = RequestMethod.GET)
    public String retrieveCardByCardNumber(@PathVariable String cardNumber){
        return retrieveCardByCardNumber(cardNumber);
    }
    @RequestMapping(value = "/Cards/Card", method = RequestMethod.PUT)
    public ResponseEntity<Object> issueNewCard(@RequestBody Card newCard){
        CardService.issueNewCard(newCard);
        return ResponseEntity.noContent().build();
    }

     @RequestMapping(value = "/Cards/{cardNumber}", method = RequestMethod.DELETE)
     public ResponseEntity<Object> deleteCardByCardNumber(@PathVariable String cardNumber){
           CardService.deleteCardByCardNumber(cardNumber);
           return ResponseEntity.noContent().build();
     }

     @RequestMapping(value = "/Cards/{cardNumber}/Status", method = RequestMethod.PUT)
     public ResponseEntity<Object> updateCardStatus(@PathVariable String cardNumber, @RequestBody boolean status){
           Card card = cardService.retrieveCardByCardNumber(cardNumber);
           card.setStatus(status);
           return ResponseEntity.noContent().build();
     }


}



/**
TODO Write a one-sentence summary of your  here.
TODO Follow it with additional details about its purpose, what abstraction
it represents, and how to use it.

@author  @TODO Put Your Name in the author tag
@version Feb 19, 2026
*/
package com.egordo17.SpringBoot.bank_rest_api;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;


public class CardService {
    private static List<Card> cardService = fakeDataBase.cards;

    public List<Card> retrieveAllCardsOfAccount() {
        return cardService;
    }

    public Card retrieveCardByCardNumber(String cardNumber) {
        List<Card> cards = fakeDataBase.cards;
        Predicate<? super Card> predicate = c -> c.getCardNumber().equalsIgnoreCase(cardNumber);
        Optional<Card> optional = cards.stream().filter(predicate).findFirst();
        return optional.get(); 
    }

    public static void issueNewCard(Card newCard) {
        // TODO Auto-generated method stub
        cardService.add(newCard);

    }

    public static void deleteCardByCardNumber(String cardNumber) {
        // TODO Auto-generated method stub
        Predicate<? super Card> predicate = c -> c.getCardNumber().equalsIgnoreCase(cardNumber);
        cardService.removeIf(predicate);
    }
}

package com.brianthomas.blackjack;

public class BlackjackApp {
	public static void main(String[] args) {

		Deck deck = new Deck();
		deck.buildDeck();
		deck.shuffleDeck();

		Hand playerHand = new Hand();
		Hand dealerHand = new Hand();

		playerHand.addCard(deck.dealCard());
		dealerHand.addCard(deck.dealCard());
		playerHand.addCard(deck.dealCard());
		dealerHand.addCard(deck.dealCard());

		System.out.println(playerHand.getCardsInHand());
		System.out.println(playerHand.getValueOfHand());
		
		System.out.println("");
		
		System.out.println(dealerHand.getCardsInHand());
		System.out.println(dealerHand.getValueOfHand());

		// for (Card card : deck.getDeck()) {
		// System.out.println(card);
		// }
	}
}

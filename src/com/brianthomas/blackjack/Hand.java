package com.brianthomas.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<Card> hand = new ArrayList<>();
	
	public void addCard(Card card) {
		hand.add(card);
	}
	
	public List<Card> getCardsInHand() {
//		for(Card card : hand) {
//			System.out.println(card);
//		}
		return hand;
	}
	
	public int getValueOfHand() {
		int valueOfHand = 0;
		for(Card card : hand) {
			valueOfHand += card.getValue();
		}
		if(hand.toString().contains("ace") && valueOfHand < 12) {
			valueOfHand += 10;
		}
		return valueOfHand;
	}
}

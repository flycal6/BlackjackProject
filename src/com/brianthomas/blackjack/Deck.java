package com.brianthomas.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck;
	private int numDealt;
	
	public List<Card> getDeck() {
		return deck;
	}

	public int getNumDealt() {
		return numDealt;
	}

	public void buildDeck(){
		deck = new ArrayList<>(52);
		for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                deck.add(new Card(s, r));
            }
        }
	}
	
	public Card dealCard() {
		return deck.remove(0);
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	public int cardsLeft() {
		return (deck.size() - numDealt);
	}
}

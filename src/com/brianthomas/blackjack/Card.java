package com.brianthomas.blackjack;

public class Card implements Comparable<Card> {
	private Suit suit;
	private Rank rank;
	private int value;

	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
		this.value = rank.value;
	}

	public Suit getSuit() {
		return suit;
	}

	public Rank getRank() {
		return rank;
	}

	public int getValue() {
		return value;
	}

	@Override
	public int compareTo(Card other) {
		if (this.rank.compareTo(other.rank) < 0) {
			return -1;
		} else if (this.rank.compareTo(other.rank) > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return (rank + " of " + suit).toLowerCase();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

}

package com.brianthomas.blackjack;

public class Player {
	private Hand hand;
	private String name;
	private double wallet;
	
	
	public Hand getHand() {
		return hand;
	}


	public void setHand(Hand hand) {
		this.hand = hand;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getWallet() {
		return wallet;
	}


	public void setWallet(double wallet) {
		this.wallet = wallet;
	}


	public void placeWager(int wager) {
		
	}
}

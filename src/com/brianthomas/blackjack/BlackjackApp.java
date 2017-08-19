package com.brianthomas.blackjack;

import java.util.Scanner;

public class BlackjackApp {
	public static void main(String[] args) {

		BlackjackApp bj = new BlackjackApp();
		bj.setUpGame();
		
	}

	private void setUpGame() {
		// create a deck and shuffle it
		Deck deck = new Deck();
		deck.buildDeck();
		deck.shuffleDeck();
		
		// Give both the player and dealer hands
		Player player = new Player();
		Hand playerHand = new Hand();
		player.setHand(playerHand);
		
		Hand dealerHand = new Hand();
		
		namePlayer(player);
		System.out.println("Howdy, " + player.getName());
		
		// Deal two cards to player and dealer
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

	private void namePlayer(Player player) {
		Scanner input = new Scanner(System.in);
		System.out.println("What's your name?");
		System.out.print(">> ");
		player.setName(input.nextLine());
		input.close();
	}
}

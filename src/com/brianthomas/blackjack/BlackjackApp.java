package com.brianthomas.blackjack;

import java.util.Scanner;

public class BlackjackApp {
	Deck deck;
	Player player;
	Hand playerHand;
	Hand dealerHand;
	Scanner input = new Scanner(System.in);
	char choice;

	public static void main(String[] args) {

		BlackjackApp bj = new BlackjackApp();
		bj.setUpGame();
		bj.gameLoop();

	}

	private void setUpGame() {

		deck = setUpDeck();

		buildHands();

		namePlayer(player);

		dealCards();

		// for (Card card : deck.getDeck()) {
		// System.out.println(card);
		// }

	}

	private void gameLoop() {
		getValueOfHands();
		checkForBlackJack();
		do {
			askForHit(playerHand);
		}while(choice == 'h');
	}

	private void askForHit(Hand hand) {
		System.out.println("(H)it or (S)tay?");
		System.out.print(">> ");
		choice = input.next().toLowerCase().charAt(0);
		if (choice == 'h') {
			hand.addCard(deck.dealCard());

		}

	}

	private void checkForBlackJack() {
		if (player.getHand().getValueOfHand() == 21 && dealerHand.getValueOfHand() == 21) {
			System.out.println("PUSH");
		} else if (player.getHand().getValueOfHand() == 21) {
			System.out.println(player.getName() + " wins: Blackjack!");
		} else if (dealerHand.getValueOfHand() == 21) {
			System.out.println("Dealer has Blackjack!");
		}

	}

	private void getValueOfHands() {
		System.out.println(playerHand.getCardsInHand());
		System.out.println(playerHand.getValueOfHand());

		System.out.println("");

		System.out.println(dealerHand.getCardsInHand());
		System.out.println(dealerHand.getValueOfHand());

	}

	private void dealCards() {
		// Deal two cards to player and dealer
		playerHand.addCard(deck.dealCard());
		dealerHand.addCard(deck.dealCard());

		playerHand.addCard(deck.dealCard());
		dealerHand.addCard(deck.dealCard());
	}

	private void buildHands() {
		player = new Player();
		playerHand = new Hand();
		player.setHand(playerHand);

		dealerHand = new Hand();

	}

	private Deck setUpDeck() {
		// separated so a new deck can be made and shuffled when not many cards are left
		deck = new Deck();
		deck.buildDeck();
		deck.shuffleDeck();

		return deck;
	}

	private void namePlayer(Player player) {
		System.out.println("What's your name?");
		System.out.print(">> ");

		player.setName(input.nextLine());

		System.out.println("Howdy, " + player.getName());
	}
}

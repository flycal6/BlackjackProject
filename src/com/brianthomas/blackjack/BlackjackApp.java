package com.brianthomas.blackjack;

import java.util.Scanner;

public class BlackjackApp {
	private Deck deck;
	private Player player;
	private Hand playerHand;
	private Hand dealerHand;
	private Scanner input = new Scanner(System.in);
	private char choice;
	private String game = "continue";

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
		} while (choice == 'h' && game == "continue");

		dealerTurn();
	}

	private void dealerTurn() {
		while (dealerHand.getValueOfHand() < 17) {
			System.out.println("Dealer Hits");
			try {
				Thread.sleep(400);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}

			dealerHand.addCard(deck.dealCard());
			getValueOfHands();
		}

	}

	private void askForHit(Hand hand) {
		while (game == "continue") {
			System.out.println("(H)it or (S)tay?");
			System.out.print(">> ");
			choice = input.next().toLowerCase().charAt(0);
			if (choice == 'h') {
				hand.addCard(deck.dealCard());
				getValueOfHands();
				if (hand.getValueOfHand() > 21) {
					game = "bust";
					choice = 's';
					System.out.println("BUST!!!");
				}
			} else {
				break;
			}

		}

	}

	private void checkForBlackJack() {
		if (player.getHand().getValueOfHand() == 21 && dealerHand.getValueOfHand() == 21) {
			System.out.println("PUSH");
		} else if (player.getHand().getValueOfHand() == 21) {
			System.out.println(player.getName() + " wins: Blackjack!");
			game = "playerWin";
		} else if (dealerHand.getValueOfHand() == 21) {
			System.out.println("Dealer has Blackjack!");
			game = "dealerWin";
		}

	}

	private void getValueOfHands() {
		System.out.println("Dealer has:");
		System.out.println(dealerHand.getCardsInHand());
		System.out.println(dealerHand.getValueOfHand());

		System.out.println("\n" + player.getName() + " has:");
		System.out.println(playerHand.getCardsInHand());
		System.out.println(playerHand.getValueOfHand());

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

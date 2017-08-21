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

		getValueOfHands();
		// for (Card card : deck.getDeck()) {
		// System.out.println(card);
		// }

	}

	private void gameLoop() {

		dealerHand.getValueOfHand();
		player.getHand().getValueOfHand();
		checkForBlackJack();
		do {
			askForHit(playerHand);
		} while (choice == 'h' && game == "continue");

		dealerTurn();
	}

	private void dealerTurn() {
		while (dealerHand.getValueOfHand() < 17 && game == "continue") {

			System.out.println(dealerHand.getValueOfHand());
			System.out.println("Dealer Hits");
			try {
				Thread.sleep(400);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			dealerHand.addCard(deck.dealCard());
			showDealerHand();
			if (dealerHand.getValueOfHand() > 21) {
				System.out.println("Dealer BUSTS!!!");
				game = "playerWin";
				break;
			}

		}
		checkForWinner();
	}

	private void checkForWinner() {
		if ((player.getHand().getValueOfHand() < 22)
				&& (player.getHand().getValueOfHand() > dealerHand.getValueOfHand())
				|| (dealerHand.getValueOfHand() > 21)) {
			System.out.println(player.getName() + " Wins!");
		} else if (dealerHand.getValueOfHand() > player.getHand().getValueOfHand()
				&& dealerHand.getValueOfHand() < 22) {
			System.out.println("Dealer Wins!");
		} else if (player.getHand().getValueOfHand() == dealerHand.getValueOfHand()) {
			System.out.println("PUSH");
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

	private void showDealerHand() {
		System.out.println("Dealer has:");
		for (Card card : dealerHand.getCardsInHand()) {
			System.out.println(card);
		}
		System.out.println(dealerHand.getValueOfHand());
	}

	private void getValueOfHands() {
		System.out.println("Dealer is showing:");
		// don't show the first dealer card
		for (int i = 0; i < dealerHand.getCardsInHand().size() - 1; i++)
			System.out.println(dealerHand.getCardsInHand().get(i + 1));

		System.out.println("*********************");
		System.out.println("\n" + player.getName() + " has:");
		for (Card card : playerHand.getCardsInHand()) {
			System.out.println(card);
		}
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
		// System.out.println("What's your name?");
		// System.out.print(">> ");
		//
		// player.setName(input.nextLine());
		//
		// System.out.println("Howdy, " + player.getName());
		player.setName("Player");
	}
}

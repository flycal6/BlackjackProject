package com.brianthomas.blackjack;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BlackjackTests {
	BlackjackApp bj;

	@Before
	public void setUp() throws Exception {
		bj = new BlackjackApp();
	}

	@After
	public void tearDown() throws Exception {
		bj = null;
	}

	@Test
	public void test_Card_object_has_expected_Rank_and_Suit_toString() {
		Card twoSpades = new Card(Suit.SPADES, Rank.TWO);
		String string = twoSpades.toString();
		assertEquals("two of spades", string );
	}
	
	@Test
	public void test_Card_Suit() {
		Card club = new Card(Suit.CLUBS, Rank.ACE);
		Card spade = new Card(Suit.SPADES, Rank.EIGHT);
		Card diamond = new Card(Suit.DIAMONDS, Rank.FIVE);
		Card heart = new Card(Suit.HEARTS, Rank.JACK);
		assertEquals(Suit.CLUBS, club.getSuit());
		assertEquals(Suit.SPADES, spade.getSuit());
		assertEquals(Suit.DIAMONDS, diamond.getSuit());
		assertEquals(Suit.HEARTS, heart.getSuit());
	}
	
	@Test
	public void test_Card_Rank() {
		Card club = new Card(Suit.CLUBS, Rank.ACE);
		Card spade = new Card(Suit.SPADES, Rank.EIGHT);
		Card diamond = new Card(Suit.DIAMONDS, Rank.FIVE);
		Card heart = new Card(Suit.HEARTS, Rank.JACK);
		assertEquals(Rank.ACE, club.getRank());
		assertEquals(Rank.EIGHT, spade.getRank());
		assertEquals(Rank.FIVE, diamond.getRank());
		assertEquals(Rank.JACK, heart.getRank());
	}

}

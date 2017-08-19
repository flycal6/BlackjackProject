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

}

package org.unioulu.tol.sqat.bsc.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat.bsc.BowlingGame;
import org.unioulu.tol.sqat.bsc.Frame;

public class TestBowlingScoreCalculator {

	@Test
	public void testOneFrameCumulativeScoreEqualsFour() {
		Frame first = new Frame(2, 2);
		
		int expected = 2+2;
		int actual = first.score();
		
		assertEquals(expected, actual);
	}

	@Test
	public void testTwoFramesCumulativeScoreEqualsTwelve() {
		BowlingGame game = new BowlingGame();
		Frame first = new Frame(2, 2);
		Frame second = new Frame(2, 6);
		game.addFrame(first);
		game.addFrame(second);
		
		int expected = 2+2+2+6;
		int actual = game.score();
		
		assertEquals(expected, actual);
	}
}

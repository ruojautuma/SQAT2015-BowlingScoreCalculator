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
	
	@Test
	public void testSpareOnThirdFrameCumulativeScoreEqualsNineteen() {
		BowlingGame game = new BowlingGame();
		Frame first = new Frame(1, 1);
		Frame second = new Frame(1, 1);
		Frame third = new Frame(7, 3); //spare
		Frame fourth = new Frame(3, 2);
		game.addFrame(first);
		game.addFrame(second);
		game.addFrame(third);
		game.addFrame(fourth);
		
		int expected = 1+1+1+1+(7+3+3)+3+2;
		int actual = game.score();
		
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testStrikeOnFirstFrameCumulativeScoreEqualsTwentyEight() {
		BowlingGame game = new BowlingGame();
		Frame first = new Frame(10, 0);
		Frame second = new Frame(3, 6);
		game.addFrame(first);
		game.addFrame(second);

		int expected = 10+(3+6)+3+6;
		int actual = game.score();
		
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testSpareOnLastFrameCumulativeScoreEqualsSixteen() {
		BowlingGame game = new BowlingGame();
		for(int i=0;i<9;i++) {
			game.addFrame(new Frame(0,0));
		}
		Frame last = new Frame(9, 1);
		game.addFrame(last);
		game.setBonus(3, 0);
		
		int expected = 9+1+3+3;
		int actual = game.score();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testStrikeOnLastFrameCumulativeScoreEqualsFourty() {
		BowlingGame game = new BowlingGame();
		for(int i=0;i<9;i++) {
			game.addFrame(new Frame(0,0));
		}
		Frame last = new Frame(10, 10);
		game.addFrame(last);
		game.setBonus(10, 0);
		
		int expected = 10+10+10+10;
		int actual = game.score();
		
		assertEquals(expected, actual);		
	}
}

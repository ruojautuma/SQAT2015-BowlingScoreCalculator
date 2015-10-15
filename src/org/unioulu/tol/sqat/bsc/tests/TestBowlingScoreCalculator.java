package org.unioulu.tol.sqat.bsc.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unioulu.tol.sqat.bsc.Frame;

public class TestBowlingScoreCalculator {

	@Test
	public void testOneFrameCumulativeScoreEqualsFour() {
		Frame first = new Frame(2, 2);
		int expected = 2+2;
		int actual = first.score();
		fail("Not yet implemented");
	}

}

package asupekar_ice4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Problem1Test {

	@Test
	void testProblem1() {
		Problem1 prob = new Problem1();
		assertTrue(prob != null);
	}

	@Test
	void testEqualsObject() {
		Problem1 prob = new Problem1();
		Problem1 prob1 = new Problem1();
		assertTrue(prob.equals(prob1));
		Problem1 prob2 = new Problem1();
		prob2.set(4);
		assertFalse(prob.equals(prob2));
	}

	@Test
	void testSet() {
		Problem1 prob = new Problem1();
		prob.set(5);
		assertTrue(prob.get() != 0);
		
	}

	@Test
	void testGet() {
		
	}

	@Test
	void testCompareTo() {
		fail("Not yet implemented");
	}

}

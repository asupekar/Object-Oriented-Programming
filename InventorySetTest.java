package asupekar_hw5;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

public class InventorySetTest {

	InventorySet s = new InventorySet();
	final VideoObj v1 = new VideoObj("A", 2000, "B");
	final VideoObj v1copy = new VideoObj("A", 2000, "B");
	final VideoObj v2 = new VideoObj("B", 2000, "B");

	@Test
	public void testAddNumOwned() {
		assertEquals(0, s.size());
		s.addNumOwned(v1, 1);
		assertEquals(v1, s.get(v1).video);
		assertEquals(1, s.get(v1).numOwned);
		s.addNumOwned(v1, 2);
		assertEquals(3, s.get(v1).numOwned);
		s.addNumOwned(v1, -1);
		assertEquals(2, s.get(v1).numOwned);
		s.addNumOwned(v2, 1);
		assertEquals(2, s.get(v1).numOwned);
		s.addNumOwned(v1copy, 1);
		assertEquals(3, s.get(v1).numOwned);
		assertEquals(2, s.size());
		s.addNumOwned(v1, -3);
		assertEquals(1, s.size());
		try {
			s.addNumOwned(null, 1);
			fail();
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void testSize() {
		assertEquals(0, s.size());
		s.addNumOwned(v1, 1);
		assertEquals(1, s.size());
		s.addNumOwned(v1, 2);
		assertEquals(1, s.size());
		s.addNumOwned(v2, 1);
		assertEquals(2, s.size());
		s.addNumOwned(v2, -1);
		assertEquals(1, s.size());
		s.addNumOwned(v1, -3);
		assertEquals(0, s.size());
		try {
			s.addNumOwned(v1, -3);
			fail();
		} catch (IllegalArgumentException e) {
		}
		assertEquals(0, s.size());
	}

	@Test
	public void testCheckOutCheckIn() {
		try {
			s.checkIn(v1copy);
			fail();
		}catch (IllegalArgumentException e) {
		}
		s.addNumOwned(v1, 1);
		s.checkOut(v1);
		s.checkIn(v1);
		assertEquals(2, s.get(v1).numOwned);
		
		try {
			s.addNumOwned(v1copy, -1);
			s.checkOut(v1copy);
			fail();
		}catch (IllegalArgumentException e) {
		}
		s.addNumOwned(v2, 1);
		s.checkOut(v2);
		assertEquals(1, s.get(v2).numOut);
		assertEquals(1, s.get(v2).numRentals);
	}

	@Test
	public void testClear() {
		s.clear();
		assertEquals(0, s.size());
	}

	@Test
	public void testGet() {
		// Get should return a COPY of the records, not the records themselves.
		s.addNumOwned(v1, 1);
		Record record1 = s.get(v1);
		Record record2 = s.get(v1);
		assertNotSame(record1, record2);
	}

	@Test
	public void testToCollection() {
		// Be sure to test that changing records in the returned
		// collection does not change the original records in the
		// inventory. ToCollection should return a COPY of the records,
		// not the records themselves.
		s.addNumOwned(v1, 1);
		Collection<Record> recordsOne = s.toCollection();
		Collection<Record> recordsTwo = s.toCollection();
		
		assertNotEquals(recordsOne, recordsTwo);
	}
}

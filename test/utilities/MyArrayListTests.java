/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author joekim
 *
 */
class MyArrayListTests {
	
	ListADT <String> list1;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		list1 = new MyArrayList<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		list1 = null;
	}

	/**
	 * Test method for {@link utilities.MyArrayList#size()}.
	 */
	@Test
	void testSize() {
		list1.add("A");
		list1.add("B");
		assertEquals(2, list1.size());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#clear()}.
	 */
	@Test
	void testClear() {
		list1 = null;
	}

	/**
	 * Test method for {@link utilities.MyArrayList#add(string, java.lang.Object)}.
	 */
	@Test
	void testAddIntEEmptyList() {
		boolean actual = list1.add(0, "A");
		assertTrue(actual);
		assertEquals(1, list1.size());
		assertEquals("A", list1.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(string, java.lang.Object)}.
	 */
	@Test
	void testAddIntENonEmptyListStart() {
		list1.add("B");
		boolean actual = list1.add(0, "A");
		assertTrue(actual);
		assertEquals(2, list1.size());
		assertEquals("A", list1.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(string, java.lang.Object)}.
	 */
	@Test
	void testAddIntENonEmptyListMiddle() {
		list1.add("A");
		list1.add("C");
		boolean actual = list1.add(1, "B");
		assertTrue(actual);
		assertEquals(3, list1.size());
		assertEquals("B", list1.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(string, java.lang.Object)}.
	 */
	@Test
	void testAddIntENonEmptyListEnd() {
		list1.add("A");
		list1.add("B");
		boolean actual = list1.add(2, "C");
		assertTrue(actual);
		assertEquals(3, list1.size());
		assertEquals("C", list1.get(2)); 
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(string, java.lang.Object)}.
	 */
	@Test
	void testAddIntENullPointer() {
		try {
			list1.add(0, null);
			fail("NullPointerException didn't throw");
		} catch(NullPointerException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(string, java.lang.Object)}.
	 */
	@Test
	void testAddIntEIndexOutOfBoundsNegative() {
		try {
			list1.add(-1, null);
			fail("IndexOutOfBoundsException didn't throw");
		} catch(IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(string, java.lang.Object)}.
	 */
	@Test
	void testAddIntEIndexOutOfBoundsGreaterThanSize() {
		try {
			list1.add(1, "A");
			fail("IndexOutOfBoundsException didn't throw");
		} catch(IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	void testAddE() {
		list1.add("A");
		list1.add("B");
		boolean actual = list1.add("C");
		assertTrue(actual);
		assertEquals(3, list1.size());
		assertEquals("C", list1.get(2)); 
	}

	/**
	 * Test method for {@link utilities.MyArrayList#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAll() {
		list1.add("A");
		list1.add("B");
		list1.add("C");
		
		ListADT <String> list2 = new MyArrayList<>();
		
		list2.add("D");
		list2.add("E");
		list2.add("F");

		list1.addAll(list2);
		assertEquals(6, list1.size());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#get(string)}.
	 */
	@Test
	void testGet() {
		list1.add("A");
		list1.add("B");
		list1.add("C");

		assertEquals("C", list1.get(2)); 
	}

	/**
	 * Test method for {@link utilities.MyArrayList#remove(string)}.
	 */
	@Test
	void testRemoveInt() {
		list1.add("A");
		list1.add("B");
		list1.add("C");
		list1.remove(1);

		assertEquals(2, list1.size()); 
		assertEquals("C", list1.get(1)); 
	}

	/**
	 * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveE() {
		list1.add("A");
		list1.add("B");
		list1.add("C");
		list1.remove("B");

		assertEquals(2, list1.size()); 
		assertEquals("C", list1.get(1)); 
	}

	/**
	 * Test method for {@link utilities.MyArrayList#set(string, java.lang.Object)}.
	 */
	@Test
	void testSet() {
		list1.add("A");
		list1.add("B");
		list1.add("C");
		list1.set(1, "D");

		assertEquals(3, list1.size()); 
		assertEquals("D", list1.get(1)); 
	}

	/**
	 * Test method for {@link utilities.MyArrayList#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		list1.add("A");
		list1.add("B");
		list1.add("C");
		
		list1.clear();

		assertTrue(list1.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	void testContains() {
		list1.add("A");
		list1.add("B");
		list1.add("C");

		assertEquals(3, list1.size()); 
		assertTrue(list1.contains("C"));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#toArray(E[])}.
	 */
	@Test
	void testToArrayEArray() {
		list1.add("A");
		list1.add("B");
		list1.add("C");
		
		String[] toHold = new String[3];
		list1.toArray(toHold);
		
		assertEquals("A", toHold[0]);
		assertEquals("B", toHold[1]); 
		assertEquals("C", toHold[2]); 
	}

	/**
	 * Test method for {@link utilities.MyArrayList#toArray()}.
	 */
	@Test
	void testToArray() {
		list1.add("A");
		list1.add("B");
		list1.add("C");
		
		Object [] toHold = list1.toArray();
		
		assertEquals("A", toHold[0]);
		assertEquals("B", toHold[1]); 
		assertEquals("C", toHold[2]); 
	}

	/**
	 * Test method for {@link utilities.MyArrayList#iterator()}.
	 */
	@Test
	void testIteratorEmpty() {
		Iterator <String>it = list1.iterator();
		assertFalse(it.hasNext());
		try
		{
			it.next();
			fail("Exception didn't throw");
		}catch (NoSuchElementException e)
		{
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#iterator()}.
	 */
	@Test
	void testIteratorNotEmpty() {
		list1.add("A");
		list1.add("B");
		list1.add("C");
		Iterator <String>it = list1.iterator();
		assertTrue(it.hasNext());
		int i = 0;
		while(it.hasNext())
		{
			assertEquals(list1.get(i), it.next());
			i++;
		}
		assertFalse(it.hasNext());
		try
		{
			it.next();
			fail("Exception didn't throw");
		}catch (NoSuchElementException e)
		{
			assertTrue(true);
		}
	}
}
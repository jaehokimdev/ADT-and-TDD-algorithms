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
class MyStackTests {
	
	private MyStack<String> list;
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		list = new MyStack<String>(10);
		
		this.list.push("A");
		this.list.push("B");
		this.list.push("C");
		this.list.push("D");
		this.list.push("E");

	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		list.clear();
	}

	/**
	 * Test method for {@link utilities.MyStack#push(java.lang.Object)}.
	 */
	@Test
	void testPush() {
		list.push("F");
		assertEquals("F", list.peek());
		assertEquals(6, this.list.size());
	}

	/**
	 * Test method for {@link utilities.MyStack#pop()}.
	 */
	@Test
	void testPop() {
		list.pop();
		
		assertEquals("D", list.peek());
		assertEquals(4, list.size());
		
		list.pop();
		list.pop();
		
		assertEquals("B", list.peek());
		assertEquals(2, list.size());
	}

	/**
	 * Test method for {@link utilities.MyStack#peek()}.
	 */
	@Test
	void testPeek() {
		assertEquals("E", list.peek());
	}

	/**
	 * Test method for {@link utilities.MyStack#clear()}.
	 */
	@Test
	void testClear() {
		list.clear();
		assertTrue(list.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyStack#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		assertFalse(list.isEmpty());
		list.clear();
		assertTrue(list.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyStack#toArray()}.
	 */
	@Test
	void testToArray() {
		Object[] array = list.toArray();
		
		assertEquals("A", array[0]);
		assertEquals("B", array[1]);
		assertEquals("C", array[2]);
		assertEquals("D", array[3]);
		assertEquals("E", array[4]);
	}

	/**
	 * Test method for {@link utilities.MyStack#toArray(E[])}.
	 */
	@Test
	void testToArrayEArray() {
		String[] array = new String[5];
		
		list.toArray(array);
		
		assertEquals("A", array[0]);
		assertEquals("B", array[1]);
		assertEquals("C", array[2]);
		assertEquals("D", array[3]);
		assertEquals("E", array[4]);
	}

	/**
	 * Test method for {@link utilities.MyStack#contains(java.lang.Object)}.
	 */
	@Test
	void testContains() {
		assertTrue(list.contains("A"));
		assertTrue(list.contains("B"));
		assertTrue(list.contains("C"));
		assertTrue(list.contains("D"));
		assertTrue(list.contains("E"));
		
		assertFalse(list.contains("F"));
	}

	/**
	 * Test method for {@link utilities.MyStack#search(java.lang.Object)}.
	 */
	@Test
	void testSearch() {
		assertEquals(1, list.search("E"));
		assertEquals(2, list.search("D"));
		assertEquals(3, list.search("C"));
		assertEquals(4, list.search("B"));
		assertEquals(5, list.search("A"));
	}

	/**
	 * Test method for {@link utilities.MyStack#iterator()}.
	 */
	@Test
	void testIterator() {
		Iterator<String> it = list.iterator();
		
		assertEquals("B", it.next());
		assertEquals("C", it.next());
		assertEquals("D", it.next());
		assertTrue(it.hasNext());
		
	}

	/**
	 * Test method for {@link utilities.MyStack#equals(utilities.StackADT)}.
	 */
	@Test
	void testEqualsStackADTOfE() {
		MyStack<String> that = new MyStack<String>(10);
		
		that.push("A");
		that.push("B");
		that.push("C");
		that.push("D");
		that.push("E");

		assertTrue(list.equals(that));
		
		MyStack<String> that2 = new MyStack<String>(10);
		
		that2.push("A");
		that2.push("A");
		that2.push("C");
		that2.push("D");
		that2.push("E");
		
		assertFalse(list.equals(that2));

	}

	/**
	 * Test method for {@link utilities.MyStack#size()}.
	 */
	@Test
	void testSize() {
		assertEquals(5, list.size());
	}

}

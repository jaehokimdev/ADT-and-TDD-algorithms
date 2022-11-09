/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.EmptyQueueException;

/**
 * @author joekim
 *
 */
class MyQueueTests {
	
	private MyQueue<String> list;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
		this.list = new MyQueue<>();
		
		this.list.enqueue("A");
		this.list.enqueue("B");
		this.list.enqueue("C");
		this.list.enqueue("D");
		this.list.enqueue("E");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		this.list.dequeueAll();
	}

	/**
	 * Test method for {@link utilities.MyQueue#enqueue(java.lang.Object)}.
	 * @throws EmptyQueueException 
	 */
	@Test
	void testEnqueue() throws EmptyQueueException {
		list.dequeueAll();
		
		list.enqueue("A");
		assertEquals("A", list.peek());
		
		list.enqueue("B");
		list.enqueue("C");
		
		assertEquals("A", list.peek());

	}

	/**
	 * Test method for {@link utilities.MyQueue#dequeue()}.
	 * @throws EmptyQueueException 
	 */
	@Test
	void testDequeue() throws EmptyQueueException {
		assertEquals("A", list.peek());
		list.dequeue();
	
		assertEquals("B", list.peek());
		list.dequeue();
		
		assertEquals("C", list.peek());
	}

	/**
	 * Test method for {@link utilities.MyQueue#peek()}.
	 * @throws EmptyQueueException 
	 */
	@Test
	void testPeek() throws EmptyQueueException {
		assertEquals("A", list.peek());
		list.dequeue();
	
		assertEquals("B", list.peek());
		list.dequeue();
		
		assertEquals("C", list.peek());
	}

	/**
	 * Test method for {@link utilities.MyQueue#dequeueAll()}.
	 */
	@Test
	void testDequeueAll() {
		assertFalse(list.isEmpty());
		assertEquals(5, list.size());
		list.dequeueAll();
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}

	/**
	 * Test method for {@link utilities.MyQueue#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		assertFalse(list.isEmpty());
		list.dequeueAll();
		assertTrue(list.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyQueue#iterator()}.
	 */
	@Test
	void testIterator() {
		
		Iterator<String> it = list.iterator();
		
		assertEquals("D", it.next());
		assertEquals("C", it.next());
		assertEquals("B", it.next());
		assertTrue(it.hasNext());
	}

	/**
	 * Test method for {@link utilities.MyQueue#equals(utilities.QueueADT)}.
	 */
	@Test
	void testEqualsQueueADTOfE() {
		MyQueue<String> that = new MyQueue<String>();
		 
		that.enqueue("A");
		that.enqueue("B");
		that.enqueue("C");
		that.enqueue("D");
		that.enqueue("E");
		
		assertTrue(list.equals(that));
	}

	/**
	 * Test method for {@link utilities.MyQueue#toArray()}.
	 */
	@Test
	void testToArray() {
		Object[] array = list.toArray();
		
		assertEquals("E", array[0]);
		assertEquals("D", array[1]);
		assertEquals("C", array[2]);
		assertEquals("B", array[3]);
		assertEquals("A", array[4]);
	}

	/**
	 * Test method for {@link utilities.MyQueue#toArray(E[])}.
	 */
	@Test
	void testToArrayEArray() {
		String[] array = new String[5]; 
		
		list.toArray(array);
		
		assertEquals("E", array[0]);
		assertEquals("D", array[1]);
		assertEquals("C", array[2]);
		assertEquals("B", array[3]);
		assertEquals("A", array[4]);
	}

	/**
	 * Test method for {@link utilities.MyQueue#size()}.
	 */
	@Test
	void testSize() {
		assertEquals(5, this.list.size());
	}

}

/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author joekim
 *
 */
class MyDLLTests {
	
	private MyDLL<Integer> list;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.list = new MyDLL<>();
		
		this.list.add(1);
		this.list.add(2);
		this.list.add(3);
		this.list.add(4);
		this.list.add(5);
	}

	/**
	 * After - Will execute the method after each test. 
	 * @throws java.lang.Exception throws Exception when exception occurred.
	 */
	public void tearDown() throws Exception {
		
		this.list.clear();
	}

	/**
	 * Test method for {@link utility.MyDLL#size()}
	 */
	@Test
	public void testSize() {
		
		assertEquals(5, this.list.size());
	}
	
	/**
	 * Test method for {@link utility.MyDLL#clear()}
	 */
	@Test
	public void testClear()	{
		list.clear();
		assertEquals(0, this.list.size());
	}
	
	/**
	 * Test method for {@link utility.MyDLL#add(Object)}
	 */
	@Test
	public void testAdd()	{

		list.add(6);
		assertEquals(6, list.get(5));
		assertEquals(6, this.list.size());
	}
	
	/**
	 * Test method for {@link utility.MyDLL#add(int, Object)}
	 */
	@Test
	public void testAddWithIndex()	{
		list.add(0, 6);
		
		assertEquals(6, list.get(0));
		assertEquals(1, list.get(1));
		assertEquals(2, list.get(2));
		assertEquals(3, list.get(3));
		assertEquals(4, list.get(4));
		assertEquals(5, list.get(5));
		assertEquals(6, this.list.size());
	}

	/**
	 * Test method for {@link utility.MyDLL#addAll(ListADT)}
	 */
	@Test
	public void testAddAll()	{
		
		MyDLL<Integer> toBeAdded = new MyDLL<>();
		
		toBeAdded.add(6);
		toBeAdded.add(7);
		toBeAdded.add(8);
		toBeAdded.add(9);
		
		assertEquals(5, list.size());
		list.addAll(toBeAdded);
		assertEquals(4, toBeAdded.size());
		
		assertEquals(1, list.get(0));
		assertEquals(2, list.get(1));
		assertEquals(3, list.get(2));
		assertEquals(4, list.get(3));
		assertEquals(5, list.get(4));
		assertEquals(6, list.get(5));
		assertEquals(7, list.get(6));
		assertEquals(8, list.get(7));
		assertEquals(9, list.get(8));
		assertEquals(9, list.size());
		
	}
	
	/**
	 * Test method for {@link utility.MyDLL#get(int)}
	 */
	@Test
	public void testGet()	{
		
		assertEquals(1, list.get(0));
		assertEquals(2, list.get(1));
		assertEquals(3, list.get(2));
		assertEquals(4, list.get(3));
		assertEquals(5, list.get(4));
	}
	
	/**
	 * Test method for {@link utility.MyDLL#remove(int)}
	 */
	@Test
	public void testRemove()	{
		
		list.remove(3);
		
		assertEquals(1, list.get(0));
		assertEquals(2, list.get(1));
		assertEquals(4, list.get(2));
		assertEquals(5, list.get(3));
		assertEquals(4, list.size());
	}
	
	/**
	 * Test method for {@link utility.MyDLL#remove(Object)}
	 */
	@Test
	public void testRemoveElement()	{
		
		list.remove((Integer)2);
		
		assertEquals(1, list.get(0));
		assertEquals(3, list.get(1));
		assertEquals(4, list.get(2));
		assertEquals(5, list.get(3));
		
		assertEquals(4, list.size());
	}
	
	/**
	 * Test method for {@link utility.MyDLL#set(int, Object)}
	 */
	@Test
	public void testSet()	{
		
		list.set(2, 6);
		
		assertEquals(1, list.get(0));
		assertEquals(2, list.get(1));
		assertEquals(6, list.get(2));
		assertEquals(4, list.get(3));
		assertEquals(5, list.get(4));
		
		assertEquals(5, list.size());
	}
	
	/**
	 * Test method for {@link utility.MyDLL#isEmpty()}
	 */
	@Test
	public void testIsEmpty()	{
		
		assertEquals(false, list.isEmpty());
		list.clear();
		assertEquals(true, list.isEmpty());
		
	}
	
	/**
	 * Test method for {@link utility.MyDLL#toArray(Object[])}
	 */
	@Test
	public void testToArrayWithParam()	{
		
		Integer[] listToHold = new Integer[5];
		list.toArray(listToHold);
		
		assertEquals(1, listToHold[0]);
		assertEquals(2, listToHold[1]);
		assertEquals(3, listToHold[2]);
		assertEquals(4, listToHold[3]);
		assertEquals(5, listToHold[4]);
	}
	
	/**
	 * Test method for {@link utility.MyDLL#toArray()}
	 */
	@Test
	public void testToArray()	{
		
		Object[] copiedArray = list.toArray();
		
		assertEquals(1, copiedArray[0]);
		assertEquals(2, copiedArray[1]);
		assertEquals(3, copiedArray[2]);
		assertEquals(4, copiedArray[3]);
		assertEquals(5, copiedArray[4]);
		assertEquals(5, copiedArray.length);
	}
	
	/**
	 * Test method for {@link utility.MyDLL#iterator()}
	 */
	@Test
	public void testIterator()	{
		
		Iterator<Integer> it = list.iterator();
		
		
		assertEquals(2, it.next());
		assertEquals(3, it.next());
		assertEquals(4, it.next());
		assertEquals(true, it.hasNext());
		assertEquals(5, it.next());
		assertEquals(false, it.hasNext());
	}
	
}

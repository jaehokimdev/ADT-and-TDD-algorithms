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
	
	private MyDLL<String> list;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.list = new MyDLL<>();
		
		this.list.add("A");
		this.list.add("B");
		this.list.add("C");
		this.list.add("D");
		this.list.add("E");
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

		list.add("F");
		assertEquals("F", list.get(5));
		assertEquals(6, this.list.size());
	}
	
	/**
	 * Test method for {@link utility.MyDLL#add(int, Object)}
	 */
	@Test
	public void testAddWithIndex()	{
		list.add(0, "F");
		
		assertEquals("F", list.get(0));
		assertEquals("A", list.get(1));
		assertEquals("B", list.get(2));
		assertEquals("C", list.get(3));
		assertEquals("D", list.get(4));
		assertEquals("E", list.get(5));
		assertEquals(6, this.list.size());
	}

	/**
	 * Test method for {@link utility.MyDLL#addAll(ListADT)}
	 */
	@Test
	public void testAddAll()	{
		
		MyDLL<String> toBeAdded = new MyDLL<>();
		
		toBeAdded.add("F");
		toBeAdded.add("G");
		toBeAdded.add("H");
		toBeAdded.add("I");
		
		assertEquals(5, list.size());
		list.addAll(toBeAdded);
		assertEquals(4, toBeAdded.size());
		
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
		assertEquals("D", list.get(3));
		assertEquals("E", list.get(4));
		assertEquals("F", list.get(5));
		assertEquals("G", list.get(6));
		assertEquals("H", list.get(7));
		assertEquals("I", list.get(8));
		assertEquals(9, list.size());
		
	}
	
	/**
	 * Test method for {@link utility.MyDLL#get(int)}
	 */
	@Test
	public void testGet()	{
		
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
		assertEquals("D", list.get(3));
		assertEquals("E", list.get(4));
	}
	
	/**
	 * Test method for {@link utility.MyDLL#remove(int)}
	 */
	@Test
	public void testRemove()	{
		
		list.remove(3);
		
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
		assertEquals("E", list.get(3));
		assertEquals(4, list.size());
	}
	
	/**
	 * Test method for {@link utility.MyDLL#remove(Object)}
	 */
	@Test
	public void testRemoveElement()	{
		
		list.remove("B");
		
		assertEquals("A", list.get(0));
		assertEquals("C", list.get(1));
		assertEquals("D", list.get(2));
		assertEquals("E", list.get(3));
		
		assertEquals(4, list.size());
	}
	
	/**
	 * Test method for {@link utility.MyDLL#set(int, Object)}
	 */
	@Test
	public void testSet()	{
		
		list.set(2, "F");
		
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("F", list.get(2));
		assertEquals("D", list.get(3));
		assertEquals("E", list.get(4));
		
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
	 * Test method for {@link utility.MyDLL#Contains(int)}
	 */
	@Test
	public void testContains()	{
		
		assertFalse(list.contains("I"));
		assertTrue(list.contains("C"));
		
	}
	
	/**
	 * Test method for {@link utility.MyDLL#toArray(Object[])}
	 */
	@Test
	public void testToArrayWithParam()	{
		
		String[] listToHold = new String[5];
		list.toArray(listToHold);
		
		assertEquals("A", listToHold[0]);
		assertEquals("B", listToHold[1]);
		assertEquals("C", listToHold[2]);
		assertEquals("D", listToHold[3]);
		assertEquals("E", listToHold[4]);
	}
	
	/**
	 * Test method for {@link utility.MyDLL#toArray()}
	 */
	@Test
	public void testToArray()	{
		
		Object[] copiedArray = list.toArray();
		
		assertEquals("A", copiedArray[0]);
		assertEquals("B", copiedArray[1]);
		assertEquals("C", copiedArray[2]);
		assertEquals("D", copiedArray[3]);
		assertEquals("E", copiedArray[4]);
		assertEquals(5, copiedArray.length);
	}
	
	/**
	 * Test method for {@link utility.MyDLL#iterator()}
	 */
	@Test
	public void testIterator()	{
		
		Iterator<String> it = list.iterator();
		
		
		assertEquals("B", it.next());
		assertEquals("C", it.next());
		assertEquals("D", it.next());
		assertEquals(true, it.hasNext());
		assertEquals("E", it.next());
		assertEquals(false, it.hasNext());
	}
	
}

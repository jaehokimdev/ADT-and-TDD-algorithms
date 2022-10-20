/**
 * 
 */
package utilities;

import java.util.NoSuchElementException;

/**
 * @author valentinmorales
 *
 */

/**
 * <p>
 * The <code>queueADT</code> interface is designed to be used as a basis for assignment 2 part 1 for  CPRG 311 class at 
 * SAIT. The implementors of this interface will be required to add all the 
 * functionality.
 * </p>
 * 
 * @param <E> The type of elements this queue holds.
 */
public interface QueueADT<E> {
	
	/**
	 * The size method will return the current element count contained 
	 * in the Queue.
	 * 
	 * Precondition: A valid Queue exists.
	 * 
	 * @return The current element count.
	 */
	public int size();
	
	/**
	 * Returns <code>true</code> if this Queue contains no elements.
	 * 
	 * Precondition: A valid Queue exists.
	 * 
	 * @return <code>true</code> if this Queue contains no elements.
	 */
	public boolean isEmpty();
	
	/**
	 * Removes all of the elements from this Queue. This Queue will be empty after
	 * this call returns.
	 * 
	 * Precondition: A valid Queue exists.
	 * 
	 */
	public void clear();
	
	
	/**
	 * Append the specified element to the end of this Queue.
	 * Implementations that support this operation may place limitations 
	 * on what elements may be appended to this queue. In particular, some
	 * implementations will refuse to push <code>null</code> elements.
	 * List classes should clearly specify in their
	 * documentation any restrictions on what elements may be added.
	 * 
	 * Precondition: A valid Queue exists.
	 * 
	 * Postcondition: An element E is appended to the queue and its depth is incremented
	 * 
	 * @param toEnqueue
	 * 			Element to be appended to this queue.
	 * @return true if element is appended successfully.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> and the queue
	 * 			implementation does not support having <code>null</code>
	 * 			elements.
	 */
	public boolean enqueue(E toEnqueue) throws NullPointerException;
	
	
	
	/**
	 * Removes the element at the start of this queue.
	 * Returns the element that was removed from the queue.
	 * 
	 * Precondition: A valid Queue exists.
	 * 
	 * Postcondition: An element E is removed from the queue and its size is decremented
	 * 
	 * @return The removed element.
	 * @throws IndexOutOfBoundsException
	 * 			If the element in the queue does not exist.
	 */
	public E dequeue() throws NoSuchElementException;
	
	
	/**
	 * Returns the element at the start of the queue.
	 * 
	 * Precondition: A valid Queue exists.
	 * 
	 * @return The element at the start of the queue.
	 * @throws NoSuchElementException
	 * 			If the element in the queue does not exist
	 */
	public E peek()throws NoSuchElementException;
}

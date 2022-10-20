/**
 * 
 */
package utilities;

import java.util.EmptyStackException;

/**
 * @author valentinmorales
 *
 */

/**
 * <p>
 * The <code>stackADT</code> interface is designed to be used as a basis for assignment 2 part 1 for  CPRG 311 class at 
 * SAIT. The implementors of this interface will be required to add all the 
 * functionality.
 * </p>
 * 
 * @param <E> The type of elements this stack holds.
 */
public interface StackADT<E> {
	
	/**
	 * The size method will return the current element count contained 
	 * in the stack.
	 * 
	 * Precondition: A valid stack exists.
	 * 
	 * @return The current element count.
	 */
	public int size();
	
	/**
	 * Returns <code>true</code> if this stack contains no elements.
	 * 
	 * Precondition: A valid stack exists.
	 * 
	 * @return <code>true</code> if this stack contains no elements.
	 */
	public boolean isEmpty();
	
	/**
	 * Removes all of the elements from the stack. This stack will be empty after
	 * this call returns.
	 * 
	 * Precondition: A valid stack object exists.
	 */
	public void clear();
	
	
	
	/**
	 * Push the specified element to the top of this stack.
	 * Implementations that support this operation may place limitations 
	 * on what elements may be added to this stack. In particular, some
	 * implementations will refuse to push <code>null</code> elements.
	 * List classes should clearly specify in their
	 * documentation any restrictions on what elements may be added.
	 * 
	 * Precondition: A valid stack exists.
	 * 
	 * Postcondition: An element E is pushed to the stack and its length is incremented.
	 * 
	 * @param toPush
	 * 			Element to be pushed to this stack.
	 * @return true if element is pushed successfully.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> and the stack
	 * 			implementation does not support having <code>null</code>
	 * 			elements.
	 */
	public boolean push(E toPush) throws NullPointerException;
	
	
	/**
	 * Removes the element at the top of this stack.
	 * Returns the element that was removed from the stack.
	 * 
	 * Precondition: A valid stack exists.
	 * 
	 * Postcondition: An element E is removed from the stack and its length is decremented.
	 * 
	 * @return The removed element.
	 * @throws EmptyStackException
	 * 			If the stack is empty.
	 */
	public  E pop() throws EmptyStackException;
	
	
	
	/**
	 * Returns the element at the top of the stack.
	 * 
	 * Precondition: A valid stack exists.
	 * 
	 * @return The element at the top of the stack.
	 * @throws EmptyStackException
	 * 			If the stack is empty
	 */
	public  E peek()throws EmptyStackException;
	

}

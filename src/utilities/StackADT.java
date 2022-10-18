package utilities;

public interface StackADT<E> {
	
	/**
	 * The size method will return the current element count contained 
	 * in the list.
	 * 
	 * @return The current element count.
	 */
	public int size();
	
	/**
	 * Removes all of the elements from this list. This list will be empty after
	 * this call returns.
	 */
	public void clear();
	
	/**
	 * @return <code>true</code> if this list contains no elements.
	 */
	public boolean isEmpty();
	
	/**
	 * Appends the specified element to the top of this list.
	 * Implementations that support this operation may place limitations 
	 * on what elements may be added to this list. In particular, some
	 * implementations will refuse to add <code>null</code> elements.
	 * List classes should clearly specify in their
	 * documentation any restrictions on what elements may be added.
	 * 
	 * @param toAdd
	 * 			Element to be appended to this list.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> and the list
	 * 			implementation does not support having <code>null</code>
	 * 			elements.
	 */
	public void push(E toAdd) throws NullPointerException;
	
	
	public E pop();
	
	
	public E peek();
	
	
	
}

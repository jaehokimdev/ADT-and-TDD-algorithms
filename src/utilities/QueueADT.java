package utilities;

public interface QueueADT<E> {
	
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
	
	
	public void enqueue(E toAdd) throws NullPointerException;
	
	
	public E dequeue();
	
	
	public E peek();
	
	
}

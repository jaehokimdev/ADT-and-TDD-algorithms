package utilities;

import java.util.NoSuchElementException;

public class MyArrayList<E> implements ListADT<E>{ 

	private static final long serialVersionUID = -6641976547739553233L;
	
	//Attributes
	private E [] array;
	private int size;
	
	//Constructors
	public MyArrayList() {
		this(10);
	}
	
	public MyArrayList(int capacity) {
		array = (E[]) new Object[capacity];
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (toAdd == null)
		{
			throw new NullPointerException();
		}
		if (index < 0 || index > size)
		{
			throw new IndexOutOfBoundsException();
		}
		//if array.length == size (array has run out of room)
			//create a new array of larger length
			//copy from original array into the new array
			//set array to the new larger array
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {

		return new ArrayBasedIterator();
	}
	
	private class ArrayBasedIterator implements Iterator<E>
	{
		private int pos;
		
		@Override
		public boolean hasNext() {
			return pos < size;
		}

		@Override
		public E next() throws NoSuchElementException {
			if (pos >= size)
			{
				throw new NoSuchElementException();
			}
			E toReturn = array[pos];
			pos++;
			return toReturn;
		}
		
	}

}

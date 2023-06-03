package utilities;

import java.util.NoSuchElementException;

/**
 * @author Jaeho Kim
 * @version 1.1 
 */

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
		array = null;
		size = 0;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (index < 0 || index > size)
		{
			throw new IndexOutOfBoundsException();
		}
		if (toAdd == null)
		{
			throw new NullPointerException();
		}
	
		if (array.length == size) {
			int newCapacity = (int) array.length * 2;
			E [] array2= (E[]) new Object[newCapacity];
			for (int i = 0; i < array.length; i++) {
				array2[i] = array[i];
			}
			array = array2;
		}
		
		for (int i = size; i > index; i--) {
			array[i] = array[i -1];
		}
		
		array[index] = toAdd;
		size++;
		
		return true;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if (toAdd == null)
		{
			throw new NullPointerException();
		}
		
		array[size] = toAdd;
		size++;
		
		return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		if (toAdd == null)
		{
			throw new NullPointerException();
		}		
		
		for (int i = 0; i < toAdd.size(); i++) {
			array[size + i] = toAdd.get(i); 
		}
		
		size += toAdd.size();
		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}
		
		return array[index];
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}
		
		E removedElement = (E) array[index];
		array[index] = null;
		
		for ( int i = index; i < size - 1; i++) {
			array[i] = array[i + 1];
		}
		
		size--;
		
		return removedElement;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		if (toRemove == null)
		{
			throw new NullPointerException();
		}
		
		for (int i = 0; i < size; i++) {
			
			if (array[i].equals(toRemove)) {
				E removedElement = array[i];
				
				for (int j = i; j < size - 1; j++) {
					array[j] = array[j + 1];
				}
			
			size--;
			return removedElement;
			}
		}
		
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}
		if (toChange == null)
		{
			throw new NullPointerException();
		}
		
		E prev = array[index];
		array[index] = toChange;
		
		return prev;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null)
		{
			throw new NullPointerException();
		}		
		
		for (int i = 0; i < size; i++) {
			if (array[i].equals(toFind)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if (toHold == null)
		{
			throw new NullPointerException();
		}
		
		for (int i = 0; i < size; i++) {
			toHold[i] = array[i];
		}
		
		return toHold;
	}

	@Override
	public Object[] toArray() {
		Object[] array2 = new Object[size];
		
		for (int i = 0; i < size; i++) {
			array2[i] = array[i];
		}
		
		return array2;
	}

	@Override
	public Iterator<E> iterator() {

		return new ArrayBasedIterator();
	}
	
	private class ArrayBasedIterator implements Iterator<E>
	{
		private int pos = 0;
		
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
			
			E toReturn = array[++pos];
			return toReturn;
		}
		
	}

}

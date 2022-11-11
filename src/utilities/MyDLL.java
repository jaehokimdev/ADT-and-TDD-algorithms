package utilities;

import java.util.NoSuchElementException;

public class MyDLL<E> implements ListADT<E> {

	private static final long serialVersionUID = -7140796753013938413L;
	private MyDLLNode<E> head;
	private MyDLLNode<E> tail;
	private int size;
	
	public MyDLL() {
		this.head = null;
		this.tail = null;
		size = 0;
	}
	
	

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		this.head = null;
		this.tail = null;
		size = 0;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		MyDLLNode<E> newNode = new MyDLLNode<E>(toAdd);
		
		if (index == 0 && size == 0) {
			head = newNode;
			tail = newNode;
		} else if(index == 0 && size != 0) {
			newNode.setNext(head);
			head.setPrev(newNode);
			head = newNode;
		} else if(index == size -1) {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		} else {
			MyDLLNode<E> current = head;
			MyDLLNode<E> prev = null;
			
			for(int i = 0; i < index; i++) {
				prev = current;
				current = current.getNext();
			}
			
			prev.setNext(newNode);
			newNode.setPrev(prev);
			newNode.setNext(current);
			current.setPrev(newNode);
		}
		
		size++;
		return true;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		}
		
		MyDLLNode<E> newNode = new MyDLLNode<E>(toAdd);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		}
		
		size++;
		return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		}
		
		for( int i = 0; i < toAdd.size(); i++) {
			add(toAdd.get(i));
		}
		
		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		
		MyDLLNode<E> current = head;
		
		for(int i = 0; i < index; i++) {
			current = current.getNext();
		}
		
		
		return current.getElement();
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {

		E removed = null;
		
		if (size == 1) {
			removed = (E) head;
			head = null;
			tail = null;
		} else if (index == size - 1) {
			removed = (E) tail;
			tail.getPrev().setNext(null);
			tail = tail.getPrev();
		} else {
			MyDLLNode<E> current = head;
			
			for (int i = 0; i < index; i++) {
				current = current.getNext();
			}
			
			removed = current.getElement();
			current.getPrev().setNext(current.getNext());
			current.getNext().setPrev(current.getPrev());
			
		}
		
		size--;
		return removed;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		if (toRemove == null) {
			throw new NullPointerException();
		}

		E removed = null;
		MyDLLNode<E> current = head;
		
		for (int i = 0; i < size - 1; i++) {
			current = current.getNext();
			
			if (current.getElement().equals(toRemove)) {
				if (i == 1) {
					removed = current.getElement();
					head = null;
					tail = null;
					size = 0;
				} else if (i == size - 1) {
					removed = current.getElement();
					tail.getPrev().setNext(null);
					tail = tail.getPrev();
					size--;
				} else {
					removed = current.getElement();
					current.getPrev().setNext(current.getNext());
					current.getNext().setPrev(current.getPrev());
					size--;
				}
			}
		}
		return removed;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (toChange == null) {
			throw new NullPointerException();
		}
		
		if (index > size - 1) {
			throw new IndexOutOfBoundsException();
		}
		
		MyDLLNode<E> newNode = new MyDLLNode<E>(toChange);
		MyDLLNode<E> oldNode = null;
		
		if (index == 0) {
			oldNode = head;
			
			newNode.setNext(head.getNext());
			head.getNext().setPrev(newNode);
			head = newNode;
		} else if (index == size - 1) {
			oldNode = tail;
			
			tail.getPrev().setNext(newNode);
			newNode.setPrev(tail.getPrev());
			tail = newNode;
		} else {			
			MyDLLNode<E> current = head;

			for (int i = 0; i < index; i++) {
				current = current.getNext();
			}
			
			oldNode = current;
			current.getPrev().setNext(newNode);
			newNode.setPrev(current.getPrev());
			current.getNext().setPrev(newNode);
			newNode.setNext(current.getNext());
		}
		
		return (E) oldNode;
	}

	@Override
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		
		if (toFind == null) {
			throw new NullPointerException();
		}
		
		MyDLLNode<E> current = head;		
		
		while(current!=null){
			if (current.getElement().equals(toFind)) {
				System.out.println("End");
				return true;
			}
			
			current = current.getNext();
			
		}
		
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if (toHold == null) {
			throw new NullPointerException();
		}
		
		MyDLLNode<E> current = head;
		
		for (int i = 0; i < size; i++) {
			
			toHold[i] = current.getElement();
			current = current.getNext();
		}
		
		return toHold;
	}

	@Override
	public Object[] toArray() {
		
		Object[] newArray = new Object[size];
		MyDLLNode<E> current = head;

		for (int i = 0; i < size; i++) {
			newArray[i] = current.getElement();
			current = current.getNext();
		}
		
		return newArray;
	}

	@Override
	public Iterator<E> iterator() {
		Iterator<E> it = new Iterator<E>() {
			
			private MyDLLNode<E> current = head;

			@Override
			public boolean hasNext() {
				if (current.getNext() != null) {
					return true;
				}
				
				return false;
			}

			@Override
			public E next() throws NoSuchElementException {
				current = current.getNext();
				
				return current.getElement();
			}
	
		};
		
		return it;
	}

}

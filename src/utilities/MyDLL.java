package utilities;

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
		
		if (head == null) {
			throw new IndexOutOfBoundsException();
		} else if (size == 1) {
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
		E removed = null;
		MyDLLNode<E> current = head;
		
		for (int i = 0; i < size; i++) {
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

}

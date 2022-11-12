package utilities;

import java.util.EmptyStackException;

/**
 * @author Jaeho Kim, Valentin Morales, Ho Chun Sun, Miller Gee 
 * @version 1.1 
 */

public class MyStack<E> implements StackADT<E> {

	private static final long serialVersionUID = -5020374182030896278L;

	private MyArrayList<E> stack;
	private int top;
	
	public MyStack() {
		top = -1;
	}
	
	public MyStack(int length) {
		super();
		stack = new MyArrayList<>(length);
	}
	
	@Override
	public void push(E toAdd) throws NullPointerException {
		
		if (toAdd == null) {
			throw new NullPointerException();
		}
		
		top++;
		stack.add(toAdd);
	}

	@Override
	public E pop() throws EmptyStackException {
		
		top--;
		return stack.remove(stack.size() - 1);
	}

	@Override
	public E peek() throws EmptyStackException {
		
		return stack.get(stack.size() - 1);
	}

	@Override
	public void clear() {
		
		stack.clear();
		
	}

	@Override
	public boolean isEmpty() {

		return stack.isEmpty();
	}

	@Override
	public Object[] toArray() {
		
		return stack.toArray();
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		
		if (holder == null) {
			throw new NullPointerException();
		}

		return stack.toArray(holder);
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		
		if (toFind == null) {
			throw new NullPointerException();
		}

		return stack.contains(toFind);
	}

	@Override
	public int search(E toFind) {

		for (int i = 0; i < stack.size(); i++) {
			if (stack.get(i).equals(toFind)) {
				return (top - i);
			}
		}
		
		return -1;
	}

	@Override
	public Iterator<E> iterator() {

		return stack.iterator();
	}

	@Override
	public boolean equals(StackADT<E> that) {

		Object[] array = that.toArray();
		
		for (int i = 0; i < stack.size(); i++) {
			if (!stack.get(i).equals(array[i])) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public int size() {

		return stack.size();
	}

}

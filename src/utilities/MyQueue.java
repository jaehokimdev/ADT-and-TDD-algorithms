package utilities;

import exceptions.EmptyQueueException;

public class MyQueue<E> implements QueueADT<E>{

	private static final long serialVersionUID = 9044049313499921350L;

	private MyDLL<E> queue;
	
	public MyQueue() {
		queue = new MyDLL<E>();
	}
	
	@Override
	public void enqueue(E toAdd) throws NullPointerException {
		
		if (toAdd == null) {
			throw new NullPointerException();
		}
		
		queue.add(0, toAdd);
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		
		if (queue.size() == 0) {
			throw new EmptyQueueException();
		}
	
		return queue.remove(queue.size() - 1);
	}

	@Override
	public E peek() throws EmptyQueueException {
		
		if (queue.size() == 0) {
			throw new EmptyQueueException();
		}

		return queue.get(queue.size() - 1);
	}

	@Override
	public void dequeueAll() {
		
		queue.clear();
		
	}

	@Override
	public boolean isEmpty() {

		return queue.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		
		return queue.iterator();
	}

	@Override
	public boolean equals(QueueADT<E> that) {
		
		Object[] array = queue.toArray();
		Object[] thatArray = that.toArray();
		
		for (int i = 0; i < size(); i++) {
			if (!array[i].equals(thatArray[i])) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public Object[] toArray() {
		
		return queue.toArray();
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		
		return queue.toArray(holder);
	}

	@Override
	public boolean isFull() {
		
		return false;
	}

	@Override
	public int size() {

		return queue.size();
	}

}

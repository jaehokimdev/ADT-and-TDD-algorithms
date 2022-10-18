package utilities;

public class DLLNode<E> {
	private E element;
	private DLLNode<E> next;
	private DLLNode<E> prev;
	
	
	public DLLNode(E element) {
		super();
		this.element = element;
	}


	public DLLNode(E element, DLLNode<E> next, DLLNode<E> prev) {
		super();
		this.element = element;
		this.next = next;
		this.prev = prev;
	}


	public E getElement() {
		return element;
	}


	public void setElement(E element) {
		this.element = element;
	}


	public DLLNode<E> getNext() {
		return next;
	}


	public void setNext(DLLNode<E> next) {
		this.next = next;
	}


	public DLLNode<E> getPrev() {
		return prev;
	}


	public void setPrev(DLLNode<E> prev) {
		this.prev = prev;
	}
	
}

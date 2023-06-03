package exceptions;

/**
 * @author Jaeho Kim
 * @version 1.1 
 */

public class EmptyQueueException extends Exception{
	public EmptyQueueException() {
		
		System.out.println("EmptyQueueException");
	}
}

********************************************************************************************************
********************************************************************************************************
*******************************************About this program*******************************************
********************************************************************************************************
********************************************************************************************************

This program includes our personal implementation of the following classes
	1.- MyQueue.java
	2.- MyStack.java
	3.- MyArrayList.java
	4.- MyDLL.java

Four interfaces Iterator.java, ListADT.java, Queue.java and StackADT.java are also included. MyDLL and MyArrayList 
implements the ListADT interface, MyQueue impements QueueADT, and MyStack implements StackADT. Furthermore, 
the Iterafor interface is used to override the repective methods in the MyStack and MyArrayList classes.

	
The proper JUnit testing for all four classes is performed in the following files
	1.- MyArrayListTests.java
	2.- MyDLLTests.java
	3.- MyQueueTests.java
	4.- MyStackTests.java

All classes previosuly mentioned are meant to be used in the implementation of the XMLparser. 
The XML parser will check if an XML fill is syntatically correct by ensuring that:	
	* All opening/closing tags have the proper format
	* Every opening tag has its corresponging closing tag and viceversa. Except for selfclosing tags.
	* Only one root tag is present
	* Tags do not intercross

Even thoug the needed testing was performed and passed, we could not finish the XMLparser. 
Hence there is no .jar file to run and try it. We apologize for it.
	
	


/*-Notes from Lecture 10
 * -
 * 
 * 
 * Notes from Lecture 9
 * -To make an interface of any type, insert <T> by the interface identifier.
 * 
 */
//This is an interface. 
public interface QueueI <T> {
//Remember interfaces only contain method signaturues. They basically represent blueprints.
public void enqueue(T aData);//<-- Enqueue adds new element to the end of the queue.
public T dequeue();//<-- dequeue removes the first element from the queue
public T peek();//<-- peek oberseves but doesnt remove the first element in a queue
public void print();//<-- Prints all elements in a queue
public int size();//<-- Wise to put this in all queue interfaces. Particularly for linked lists.


}

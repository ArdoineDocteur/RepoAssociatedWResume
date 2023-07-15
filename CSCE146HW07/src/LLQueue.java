//Linked list Version of Queue. Using the singly generic linked list version to create the queue. May contain the same aspects learned in recent lectures involving generic linked lists.
//NOTE as of 5/31/23: Remember that Queues are FIFO data structures and that Stacks are LIFO data structures.
public class LLQueue <T> implements QueueI<T> 
{	private class ListNode
	{
	T data;
	ListNode link;
	public ListNode(T aData, ListNode aLink)
	{	data=aData;
		link=aLink;
	}
	}
	private ListNode head;
	private ListNode tail;
	private int size;
	//^The reason why we are using current and previous because queues only need the head index and the tail index.
	//Anytime something is enqueued, the size must increase and if something is dequeued(removed from the back of the queue), the size must decrease.
	
	public LLQueue()
	{
		head=tail=null;
	}
	public void enqueue(T aData)
	{	ListNode newNode= new ListNode(aData,null);//<-- Instance/creation of new node with an instance of listNode(edit this note in future)
		//^ newNode is assigned to the head index.
		if(head==null)
		{
			head=tail=newNode;
			size=1;//<-- Doign this when an element is added.
			return;
		}
		tail.link=newNode;
		tail=tail.link;//<-- This and the code in the line above adds the element after the tail reference.
		size++;
	
	}//Tail references in generic linked lists may be useful. Consider adding it to your generic linked list that you created a while ago.
	public T dequeue()
	{	if(head==null)
	{
		return null;//<-- Occurs when head isnt assigned to a memory address
	}
	T ret=head.data;//<-- Element assigned to head
	head=head.link;//<-- Moves head up once which removes ret from it?
	size--;//<-- Decreases size when data is removed from the queue structure.
	return ret;//<-- Returns the stored removed data.
		
	}
	public T peek()
	{	if(head==null)
	{
		return null;
	}return head.data;
		
	}
	public void empty()
	{
		head=null;
	}
	public void print()
	{
		for(ListNode temp=head;temp!=null;temp=temp.link)//<-- I believe this for loop starts from the head and move throughout the entire que until temp becomes null which is when there is no more data left.
		{
			System.out.println(temp.data);//<-- Prints data.
		}
	}
	public int size()
	{
		return this.size;
	}
}
	


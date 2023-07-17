//Updated as of 2/21/23 @ 12:50PM
/*Generic Linked Lists add, remove, etc the same way as regular Linked lists do. 
 * Only difference is that generics contain <T> with T representing as a variable for Object types.
 * Also, one thing to know is that The object type for int and double is Integer and Double(Derived from Integer.parseInt and Double.parseDouble respectively.)
 * -Take the time to analyze the code and add extra notes for better understanding.
 * */
/*Notes from Video Lecture 8
 * -The three files are from Lecture 5(The taco classes) and Lecture 7(The Generic Linked List class).
 * -The notes in this section will be from lecture 8. Every other note is from Lecture 7.
 * 
 */
/*
 * Written by Ardoine Docteur
 */
import java.io.*;
public class GenLL <T>//<-- this is a generic. It is made like a class but it just adds the <T> to it.
{	
	private class ListNode
	{
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink)
		{	//Remember that T is the generic object-type
			data=aData;//<-- Makes the memory address with Type generic store into data
			link=aLink;//<-- Makes the memory address with Type generic store into data
		}
	}
	private ListNode head;//<-- Points to the first element of the linked list.
	private ListNode current;//<-- Pointer allows programmers to access and modify certain part sof the linked list
	private ListNode previous;//<-- Pointer that refers to the element that is one behind the current
	private int size;//<-- Indicates the number of elements, number of nodes, and number of data in the linked list.
	public GenLL()
	{
		head=current=previous=null;
		this.size=0;//<-- Default value for the size.
		
	}
	public void add(T aData)//Remember that T is the "variable for types". 
	{
		ListNode newNode= new ListNode(aData,null);//<-- Pointer is null since it is starting at the head.
				if(head==null)
				{
					head=current=newNode;
					this.size=1;
					return;//Adding, removing, etc generic linked lists is the same as adding,remeoving etc linked lists.
				}
				this.size++;//<-- Occurs when head is not empty aka null.
		ListNode temp=head;
		while(temp.link!=null)
		{
			temp=temp.link;//<-- Moves temp one element forward
// 			temp.link=newNode;//<-- Adds newNode to the end of the linked list?(Refer to previous lecture for more information)<-- I think the placement of this line of code is incorrect.
			
		}temp.link=newNode;//<-- Adds newNode to the end of the linked list?(Refer to previous lecture for more information)
	}
		public void print()
		{
			ListNode temp=head;
			while(temp!=null)
			{
				System.out.println(temp.data);
				temp=temp.link;
			}
						
		}
		public void print2File(String fileName)
		{	try
		{
			PrintWriter pW= new PrintWriter(new FileOutputStream(new File("./"+fileName)));		
			ListNode temp=head;
			while(temp!=null)
			{
				pW.println(temp.data);
				temp=temp.link;
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		}
		public void addAfterCurrent(T aData)
		{
			if(current==null)
			{
				return;//Means current isnt refering to anything
			}
			ListNode newNode= new ListNode(aData,current.link);//<-- THis new node will point to where current is currently pointing to.
			current.link=newNode;//<-- Assigns new Node to current.link
			this.size++;//<-- This is applied because we must increase the size as we add elements.
			
		}
		public T getCurrent()//Accessor for GEneric linked lists. T represents the return type in accessor generic linked lists.
		{
			if(current==null)
			{
				return null;
			}
			return current.data;
		}
		public void setCurrent(T aData)
		{
			if(aData==null || current==null)//<-- Means current is null or current has data that is nonexistent.
			{	
				return;
				
				//Data in mutators for both generic and regular linked lists
			}current.data=aData;
		}
		public void gotoNext()//Moves current forward
		{
			if(current ==null)
			{
				return;
			}
			previous=current;
			current=current.link;
		}
		public void reset()//Points current to head, reseting the pointer
		{	current=head;
			previous=null;//<-- THis only happens since previous is always one behind current. When current is at the head, there should be no previous.
			
		}
		public boolean hasMore()//Indicates if we can go to next pointer. Maybe refer to max?(Refer to previous lecture for more information)
		{
			return current!=null;
		}
		public void removeCurrent()
		{
			if(current==head)//means current is pointing to the head(current and head are pointing to same meory address)
			{
				head=head.link;
				current=head;
			}
			else
			{	//This means current is somewhere else in the linked list
				previous.link=current.link;//refers to current since previous is always one element behind current. This assigns the previous over the element it is behind which moves the element in the middle using the code below it: current=current.link.
				current=null;
			}
			if(this.size>0)//<-- Ensures that we will never have a negative size.
			{
				size--;//<-- This decreases the size when an element form a linked list is removed.
			}
		}//It may be beneficial to have methods that compare the elements in the linked lists. Take time to explore generic linked lists and regular linked lists.
		public int getSize()
		{
			return this.size;
		}//Below, we are creating two methods that allows us to access data from a certain position using two methods.
		public T getAt(int index)//<-- Accessor for accessing the linked list at a certain index.
		{	if(index<0 || index>=size)//<-- Prevents the runtime index out of bounds error since array structures and linked lists are ranged from 0 to size-1.
			{return null;

			}
		ListNode temp=head;//Assigns temp the value of the head
		for(int i=0;i<index;i++)
		{
			temp=temp.link;//moves temp forward
		}
		return temp.data;//<-- This runs which returns the first data of the linked list at the ith(or at the desired index) position. since temp is assigned to head's memory address.(Refer to notes about the 4 special nodes again if you have trouble understanding this.)
		}//The getAt method allows us to get any element at any position. Grants us access at any point in the linked list. 
		public void setAt(int index, T aData)
		{
			if(index<0 || index>=size || aData==null)
			{
				return;//prevents runtime error and ensures that the specified node has some data.
			}
			ListNode temp=head;//Assings temp the value of head to start from beginning.
			for(int i=0;i<index;i++)
			{
				temp=temp.link;//Moves temp forward
			}
			temp.data=aData;//Sets the data at ith(desired index) node. 
		}
		//Here I am going to add a method that removes items at a certain index:
		public void removeAt(T aData)
		{   setCurrent(aData);
			removeCurrent();
		    
		    
		}
		public void Empty()
		{
			head=null;
		}
		//Allows us to modify data. Basically the equivalent of modifying values in an array except with respect to the linked list. Same dynamic applies to the getAt method which allows us to access values.
	}
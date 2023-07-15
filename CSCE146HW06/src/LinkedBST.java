
/*	Notes from Lecture 18(Binary Search Trees Part 2)
 * -(For other notes, refer to blue csce 145 n 146 notebook)
 *	-One of the first rules for a BST is that all of the data in a binary search tree MUST be comparable
 *	-Remember that each node in a binary search tree has AT MOST two children which are the left and right child.
 	NOTE: The notes are from the previous lecture. Currently adding notes from this current lecture, as well as other functionalities. 
 */
import java.util.*;
import java.io.*;
public class LinkedBST<T extends Comparable<T>>//<-- As we know, we can use a generic type so that way we can use this binary search tree with any class. It has extends comparable to satisfy the requirements for a binary search tree. 
{	public static int BSTSize;	
	private class Node//<-- This internal class is also used in the other Linked list data structures.
	{
		T data;
		Node leftChild;
		Node rightChild;
		//^The two instances of node above satisfy the BST's requirement of each node having a left and a right child at MAXIMUM.
		public Node(T aData)//<-- This is the default constructor for the internal class
		{
			data=aData;
			leftChild=rightChild=null;
		}
	}
	
	private Node root;//<-- This is the BST equivalent of the Linked List Data structure's head reference.
	public LinkedBST()//<
	{
		root=null;
	}
	
	public void add(T aData)//<-- This method routes the adding of data into BSTs.
	{	if(root==null)//<-- This checks if the head reference(root) is null.
	{
		root= new Node(aData);
	}
	else
	{// We then recursively add the element.
		add(root,aData);//<-- This is the calling of the private method of type Node below.
		//Remember that recursion is loop like which warrants the need of a halting condition.
	}
	}
	private Node add(Node aNode, T aData)//<-- This will be the method that is called recursively to add data into the BST.
	{
		if(aNode==null)//<-- When this is true, that means the pointer reached a leaf(remember that a leaf is a node with no children[node that contains null references]).
		{
			aNode= new Node(aData);//<-- This line of code constructs a new node and adds it to the BST.
			
		}
		else if(aData.compareTo(aNode.data)<0)//<-- The method compareTo is utilized since the generic extends comparable. Remember that classes are NOT comparable by default. This is why we must specify if it is comparable or not.
		{//^The code in the parentheses above yielded a syntax error because branching statements require boolean expressions that yield true or false.
		 //The compareTo method returns an integer value.
			
		//The boolean expression above says that the data being added was LESS THAN the data @ the node(aNode.data). When this is true, the data is added to the LEFT child node not the RIGHT child node.
			
		aNode.leftChild=add(aNode.leftChild,aData);//<-- This function is called recursively so when the pointer lands on a node that isn't node, it can be added to the BST. 	
		}
		else if(aData.compareTo(aNode.data)>0)
		{
			aNode.rightChild=add(aNode.rightChild,aData);//<-- The same idea applies as the branching statement above. However, this branching statement runs when the value of the data being added is greater than the parent value.
			//The boolean expression above says that the data being added was GREATER THAN the data @ the node(aNode.data). When this is true, the data is added to the RIGHT child node not the LEFT child node.
	
		}
		return aNode;//<-- Returning aNode allows us to recursively call this function until it reaches a leaf(a node with null references).
	}
	public void printPreOrder()//<-- This is one of the traversal types that are used to output data from the BST
	{
		printPreOrder(root);//<-- This allows us to print 
	}
	private void printPreOrder(Node aNode)
	{	if(aNode==null)//<-- WHen printing the values, we have to check if we reach a leaf in our BST. Remember that leaves are nodes with no children nodes. ALso, remember that nodes have, AT THE MOST, two children nodes.
	{	//NOTE: This check is the equivalent to checking if the head reference is null in a linked list.
		return;
	}
	System.out.println(aNode.data);//<-- This is traversal operator: PROCESS
	printPreOrder(aNode.leftChild);//<-- This is traversal operator: LEFT
	printPreOrder(aNode.rightChild);//<-- This is traversal operator: RIGHT
	//****PN: Putting these three operators in the orders shown in blue notebook allows us to create the traversal types which are Pre-order Post-order and In-Order that contain the traversal operators in (PROCESS,LEFT,RIGHT), (LEFT,RIGHT,PROCESS), and (LEFT,PROCESS,RIGHT) respectively.
	}
	public void printInOrder()//<-- This is the traversal type called in-order
	{
		printInOrder(root);//<-- REmember to ALWAYS start at the head reference aka the root.
	}
	private void printInOrder(Node aNode)
	{	if(aNode==null)
	{
		return;//<-- This means that the node is a leaf.
	}
	printInOrder(aNode.leftChild);
	System.out.println(aNode.data);
	printInOrder(aNode.rightChild);
		
	}
	//Printing data to files:
	public void printInOrder2File(PrintWriter fW)
	{
		printInOrder2File(root,fW);
	}
	private void printInOrder2File(Node aNode, PrintWriter fW)
	{	try
	{	
		if(aNode==null)
	{	fW.close();
		return;
	}
	
	printInOrder2File(aNode.leftChild,fW);
	fW.println(aNode.data);
	printInOrder2File(aNode.leftChild,fW);
	
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	private void printPreOrder(Node aNode, PrintWriter fW)
	{	if(aNode==null)
	{
		return;
	}//Finish the rest of the variants for printing data to a file.
		
	}
	
	public void printPostOrder()//<-- This is the traversal type called the Post-Order
	{
		printPostOrder(root);//<-- ALways remember to start @ the head reference aka the root.
	}
	private void printPostOrder(Node aNode)
	{	if(aNode==null)
	{
		return;//<-- When the pointer reaches a leaf.
	}
	printPostOrder(aNode.leftChild);
	printPostOrder(aNode.rightChild);
	System.out.println(aNode.data);
		
	}
	public void getBSTSize()
	{
		getBSTSize(root);
	}
	private void getBSTSize(Node aNode)
	{	if(aNode==null)
	{
		return;
	}BSTSize++;
		getBSTSize(aNode.leftChild);
		getBSTSize(aNode.rightChild);
	}
	public T data(Node aNode)
	{	if(aNode==null)
	{
		return null;
	}
		return aNode.data;
	}
	private Node goToLeft(Node aNode)
	{	if(aNode==null)
	{
		return null;
	}
		return goToLeft(aNode.leftChild);
		
	}
	private Node goToRight(Node aNode)
	{	if(aNode==null)
	{
		return null;
	}
		return goToRight(aNode.rightChild);
	}
	public Node goToRight()
	{	
		return goToRight(root);
	}
	public Node goToLeft()
	{
		return goToLeft(root);
	}
		
	
	public T accessor(T aData)
	{
		return accessor(root, aData);
	}
	private T accessor(Node aNode, T aData)
	{	if(aNode==null)
	{
		return null;//<-- Means we came across a leaf
	}
	else if(aData.compareTo(aData)<0)
	{
		return accessor(aNode.leftChild, aData);
	}
	else if(aData.compareTo(aData)>0)
	{
		return accessor(aNode.rightChild,aData);
	}
	else
	{//When the parent value is equal to the child value:
		return aNode.data;
	}
		
	}
	
	public boolean search(T aData)//<-- This is the method that we use for searching for data in a binary search tree.
	{
		return search(root,aData);
	}
	
	private boolean search(Node aNode, T aData)
	{	if(aNode==null)
	{
		return false;
		//ALWAYS CHECK IF A NODE IS NULL. When this is the case, you have reached a leaf.
	}
	else if(aData.compareTo(aNode.data)<0)//<-- THe boolean expression checks if the node's data is less than the parent's value's data. WHen true, the pointer moves left. When placed in a negating boolean exp, when the node's value is greater than the parent's value, then it moves right.
	{	
		return search(aNode.leftChild,aData);//<-- Goes left in the binary search tree recursively.
	}
	else if(aData.compareTo(aNode.data)>0)
	{	//NOTE: Remember that the boolean for determining if the BST's pointer should go left or right is aData.compareTo(aNode.data)<0 (for left) and aData.compareTo(aNode.data)>0 (for right). PT: I think using only one with a negating boolean exp serves the same purpose.
		return search(aNode.rightChild,aData);
	}
	else
	{
		return true;//<-- This occurs when the values of both the node and the parent are equal.
	}
		
	}
	public Node searchNRet(T aData)
	{
		return searchNRet(root,aData);
	}
	private Node searchNRet(Node aNode, T aData)
	{
		if(aNode==null)
		{
			return null;
			//ALWAYS CHECK IF A NODE IS NULL. When this is the case, you have reached a leaf.
		}
		else if(aData.compareTo(aNode.data)<0)//<-- THe boolean expression checks if the node's data is less than the parent's value's data. WHen true, the pointer moves left. When placed in a negating boolean exp, when the node's value is greater than the parent's value, then it moves right.
		{	
			return searchNRet(aNode.leftChild,aData);//<-- Goes left in the binary search tree recursively.
		}
		else if(aData.compareTo(aNode.data)>0)
		{	//NOTE: Remember that the boolean for determining if the BST's pointer should go left or right is aData.compareTo(aNode.data)<0 (for left) and aData.compareTo(aNode.data)>0 (for right). PT: I think using only one with a negating boolean exp serves the same purpose.
			return searchNRet(aNode.rightChild,aData);
		}
		else
		{
			return aNode;//<-- This occurs when the values of both the node and the parent are equal.
		}
	}
	public void removeLessThan()
	{
		
	}
	private void removeLessThan(Node aNode)
	{	if(aNode==null)
	{
		return;
	}else if(aNode.data.compareTo(aNode.data)<0)
	{
		this.remove(aNode.data);
	}
	else
	{
		removeLessThan(aNode);
	}
		
	}
	public void remove(T aData)//<-- This is used to remove data from BSTs.
	{
		root=remove(root,aData);//<-- If the root is removed, the recusrive call of the function updates the root of the BST.
	}
	private Node remove(Node aNode, T aData)
	{
		//Step 1: Find the node
		if(aNode==null)
		{
			return null;//<-- This means the node is a leaf.
		}
		else if(aData.compareTo(aNode.data)<0)//<-- Checks if the data is less than the parent value
		{
			aNode.leftChild=remove(aNode.leftChild,aData);//<-- Sends pointer left.
		}
		else if(aData.compareTo(aNode.data)>0)
		{
			aNode.rightChild=remove(aNode.rightChild,aData);//<-- Sends pointer right.
		}
		else//<-- WHen true, this means the node was found. Now, we need to determine how many children nodes they have, if they have any.
		{
			if(aNode.rightChild==null)//<-- This means the node doesn't jave a right child.
			{
				return aNode.leftChild;
			}
			else if(aNode.leftChild==null)
			{
				return aNode.rightChild;
			}//The two branching statements above apply when the node ONLY has ONEEEE child node.
			//TODO FIND SMALLEST VALUE:
			
			Node temp=findMinInTree(aNode.rightChild);//<-- This finds the node that has the smallest value in the right subtree.
			aNode.data=temp.data;//<-- This assigns the temp node's data, the smallest value in the tree found, to the current data(which leaves us with a duplicate value).
			//Remember that BSTs CANNOT have duplicate values which is why the next step is removing the duplicate value:
			
			aNode.rightChild=remove(aNode.rightChild,temp.data);//<-- This is used to find the duplicate value and remove it from the BST.
			
		}
		return aNode;//<-- This allows us to backtrack to the parent node and reassign what the child's value may be.
	}
	private Node findMinInTree(Node aNode)
	{	if(aNode==null)
	{
		return null;
	}
	else if(aNode.leftChild==null)
	{//When this is true, this means that Node aNode is the smallest which is why we return aNode.
		return aNode;
		
	}
	else
	{
		return findMinInTree(aNode.leftChild);//<-- When left child node isnt null, it means that aNode isnt the smallest value which warrants recursion to keep running the method until we come across a left child node with a null reference(aka a leaf). 
	}
		
	}
	private Node findMaxInTree(Node aNode)//<-- This method is used to find the biggest value in the BST.
	{	if(aNode==null)
	{
		return null;
	}
	else if(aNode.rightChild==null)
	{
		return aNode;
	}
	else
	{
		return findMaxInTree(aNode.rightChild);
	}
		
	}
	public Node maxValue()
	{
		return findMaxInTree(root);
	}
	public Node minValue()
	{
		return findMinInTree(root);
	}
	public void reset()//<-- This method resets the data inside of a BST.
	{
		root=null;
	}
}


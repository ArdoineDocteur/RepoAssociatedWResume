/*Notes from Lecture 20
 * -The data structure below is the second variant of the heaps.
 * Their structures are very similar. PN: I believe that the min and max
 * heap are opposite in terms of their order of data from the root to the 
 * leaves whether its ascending or descending order.
 */
public class MinHeap<T extends Comparable<T>> 
{	private T[] heap;
	public static final int defaultSize=120;
	private int lastIndex;//<-- This keeps track of the first null element.
//	public int compareToWrd(String aData)
//	{
//		int num=0;
//		String alphabets="abcdefghijklmnopqrstuvwxyz";
//		if(aData.charAt(0)==alphabets.charAt(0))
//	{
//		num=26;
//	}
//	else if(aData.charAt(0)!=alphabets.charAt(0))
//	{	for(int i=0;i<alphabets.length();i++)
//	{	if(aData.charAt(0)==alphabets.charAt(i))
//	{
//		num=26-i;
//		break;
//	}
//		
//	}
//	}
//		return num;
//	}
	public MinHeap()
	{
		init(defaultSize);
	}
	public MinHeap(int size)
	{
		init(size);
	}
	private void init(int size)
	{	if(size>0)
	{
		heap=(T[])(new Comparable[size]);
		lastIndex=0;//<-- The root index of the heap.
	}
	else
	{
		init(defaultSize);
	}
		
	}
	public T peek()
	{
		return heap[0];
	}
	public int getSize()
	{
		return lastIndex;
	}
	public void add(T aData)//<-- This method is used to add data to the MIN heap.
	{	if(lastIndex>=heap.length)
	{	
		return;//<-- THis occurs when the array is full since arrays are random access BUT NOT RESIZABLE DATA STRUCTURES.
	}//After checking if the heap is full, we start the bubble up process: 
	heap[lastIndex]=aData;
	bubbleUp();
	lastIndex++;//<-- When adding data to the heap, we have to make sure that we update the size as well.
		
	}
	private void searchNRet(T aData)
	{
		
	}
	private void bubbleUp()//<-- Algorithm to bubble up through the heap.
	{
		int index=lastIndex;//<-- We start the index @ the last index because the last index is the root.
		while(index>0 && heap[(index-1)/2].compareTo(heap[index])>0)//<-- As in the MAX heap implementation, this boolean expression checks if the child node is greater than the parent node. Remember that, in terms of heaps, the parent index is accessed through (child index-1)/2
		//And the child index is accessed through either (2*parent index)+1 or (2*parent index)+2.	
		{	//The code in this while loop represents the process of bubbling up through the heap.
			T temp= heap[(index-1)/2];//<-- This assigns the contents of heap @ the parent index to the temp with generic type T variable.
			heap[(index-1)/2]=heap[index];
			heap[index]=temp;
			index=(index-1)/2;
			//NOTE: For a min heap, the value of the parent must be LESS than the value of all of its children nodes.(Which is the opposite of the max heap.)
			//Also, remember that the max and min heaps are the same with the EXCEPTION of the placements of the parent and children nodes in terms of their respective values(whether one relationship where the parent's values are greater than the children nodes's values and vice versa).
		}
	}
	public T remove()
	{	if(lastIndex==0)
	{
		return null;//<-- THis is the case when the heap is empty.
	}
	T ret=heap[0];//<-- This assigns the value stored @the root index to T ret.
	heap[0]=heap[lastIndex-1];//<-- This assigns the last non-null value of the heap to the root index. Remember that all array-based data structures have fixed size that range from 0 to their size-1.
	heap[lastIndex-1]=null;//<-- This allows us to reduce the size of the array by one since the goal is to remove a value and its reference from the heap.
	lastIndex--;
	//After setting up the code above, we then initiate the bubble down procedure:
	bubbleDown();
	return ret;	
	}
	public T remove(T aData)
	{	if(lastIndex==0)
	{
		return null;
	}
	heap[0]=heap[lastIndex-1];
	heap[lastIndex-1]=null;
	lastIndex--;
	return bubbleDown(aData);
	}
	private T bubbleDown(T aData)
	{
		int index=0;//<-- This is because step 1 of bubbling down says to start @ the root. PN: This is because, in heaps, data can ONLY BE REMOVED FROM THE ROOT.
		while(index*2+1 < lastIndex && !(heap[index].equals(aData)))//<-- REmember that the index*2+1 refers to the left child node. Remember that when removing data from MIN HEAPS, the goal revolves around finding the children nodes with the smaller values. This could be why we start with the left child index opposed to starting @ the right child index in the MAX HEAP.
		{
			int smallIndex=(index*2)+1;//<-- This assigns the left child node's index to the integer variable smallestIndex.
			if((index*2)+2 < lastIndex && heap[(index*2)+1].compareTo(heap[(index*2)+2])>0)
			{//Here, when true, we compare the left and right child nodes to see who has the smaller value.
				//Also, in the second boolean expression, when true, it means that the left child node has a greater value than the right child node
				//which means that the smaller node is the right child node not the left node. Remember that min heaps focus on finding the smaller values while MAX HEAPS revolve around finding the BIGGER VALUES.
				
			smallIndex=(index*2)+2;//<-- In the blurb above, it explains why the right child node index is the new smallest index.
			}
			if(heap[index].compareTo(heap[smallIndex])>0)
			{	//The boolean exp above compares the value @ the smallest index with the value @ the root. When true, the values @ both indexes must swap places.
				
				T temp= heap[index];
				heap[index]=heap[smallIndex];
				heap[smallIndex]=temp;
			}
			else if(heap[index].equals(aData))
			{
				break;//<-- THis breaks the loop when the value @ the root index(aka the parent node) is smaller than the smallest child node value which means we stop bubbling down.
			}
			index=smallIndex;//<-- This allows the loop to keep going until the desired index is found.
		}
		return heap[index];
	}
		
	
	private void bubbleDown()
	{
		int index=0;//<-- This is because step 1 of bubbling down says to start @ the root. PN: This is because, in heaps, data can ONLY BE REMOVED FROM THE ROOT.
		while(index*2+1 < lastIndex)//<-- REmember that the index*2+1 refers to the left child node. Remember that when removing data from MIN HEAPS, the goal revolves around finding the children nodes with the smaller values. This could be why we start with the left child index opposed to starting @ the right child index in the MAX HEAP.
		{
			int smallIndex=(index*2)+1;//<-- This assigns the left child node's index to the integer variable smallestIndex.
			if((index*2)+2 < lastIndex && heap[(index*2)+1].compareTo(heap[(index*2)+2])>0)
			{//Here, when true, we compare the left and right child nodes to see who has the smaller value.
				//Also, in the second boolean expression, when true, it means that the left child node has a greater value than the right child node
				//which means that the smaller node is the right child node not the left node. Remember that min heaps focus on finding the smaller values while MAX HEAPS revolve around finding the BIGGER VALUES.
				
			smallIndex=(index*2)+2;//<-- In the blurb above, it explains why the right child node index is the new smallest index.
			}
			if(heap[index].compareTo(heap[smallIndex])>0)
			{	//The boolean exp above compares the value @ the smallest index with the value @ the root. When true, the values @ both indexes must swap places.
				
				T temp= heap[index];
				heap[index]=heap[smallIndex];
				heap[smallIndex]=temp;
			}
			else
			{
				break;//<-- THis breaks the loop when the value @ the root index(aka the parent node) is smaller than the smallest child node value which means we stop bubbling down.
			}
			index=smallIndex;//<-- This allows the loop to keep going until the desired index is found.
			}
		}
	
	public void print()//<-- Method for printing the min heap's data
	{	for(T h: heap)
	{
		if(h==null)
		{
			break;
		}
		System.out.println(h);
	}
		
	}
	public void heapSort(T[] array)//<-- This is the method for the heap sort algorithm. The parameter T[] allows us to sort ANY ARRAY WITH ANY DATA TYPE WHICH is extremely useful going forward.
	{	if(array==null)
	{
		return;//<-- THis checks if the array has values
	}
	MinHeap<T>mHeap= new MinHeap<T>(array.length);//<-- This creates an instance inside of the instance of type T[].
	//Doing this allow us to use the methods of the min heap with the values, add to the min heap, and then remove to return an array of sorted values.
	for(int i=0;i<array.length;i++)
	{
		mHeap.add(array[i]);
		//THis for loop adds each value of the T[] to the instance of the mHeap of Type T.
	}
	for(int i=0;i<array.length;i++)
	{
		array[i]=mHeap.remove();//<-- This for loop removes each value that was added which would result in all the values being returned as a sorted array.
	}
	}
	

}

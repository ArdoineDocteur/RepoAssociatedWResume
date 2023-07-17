//Going to try the queue implementation.
import java.util.*;
import java.io.*;
public class SheepCM 
{	public static MinHeap<SheepProperties> mSP= new MinHeap<SheepProperties>(61);
	public static LLQueue<SheepProperties> qSP= new LLQueue<SheepProperties>();
	public static int sCount=0;
	public static SheepCM sCM= new SheepCM();
	public static GenLL<SheepProperties> newS = new GenLL<SheepProperties>();
	public static SheepProperties[]sPA=new SheepProperties[61];
	//Going to get the my generic queue, and use the queue to output the correct schedule.
	public static void addSheepLL(SheepProperties aS)//<-- This method uses a linked list to add sheep's data.
	{
	if(aS!=null)
	{
		newS.add(aS);
	}
	else if(aS==null)
	{
		return;
	}
		
	}
	public static void addSheepQQ(SheepProperties aS)//<-- This method uses a linked list to add sheep's data.
	{
	if(aS!=null)
	{
		qSP.enqueue(aS);
	}
	else if(aS==null)
	{
		return;
	}
		
	}
	public static SheepProperties[] add2ArrayLL(GenLL<SheepProperties> sP)//<-- This transfers the Linked list's data to array data.
	{	for(int i=0;i<sP.getSize();i++)
		{	if(sP.getAt(i).getArrivalTime()==0)
		{	sPA[0]=sP.getAt(i);
		
		}
			sPA[i+1]=sP.getAt(i);
		}
		return sPA;
		
	}
	public static void add2ArrayQQ(LLQueue<SheepProperties> sP)//<-- This transfers the Linked list's data to array data.
	{	int i=0;
		while(qSP.peek()!=null)
		{	
			sPA[i]=sP.dequeue();
		}
		
		
	}
	public static void addSheep2Heap(SheepProperties aS)
	{	if(aS!=null && aS.getArrivalTime()!=0)
	{
		mSP.add(aS);
		newS.removeAt(aS);
	}
	else
	{
		return;
	}
		
	}
	
	public void sheepFileReader(String fileName)
	{	//The file being read is tab delimited.
		try
	{	Scanner fileReader= new Scanner(new File(fileName));
		int i=0;
		while(fileReader.hasNextLine())
		{	String fileLine=fileReader.nextLine();
			String[]splitLines= fileLine.split("\t");
			if(splitLines.length==3)
			{	String sheepName=splitLines[0];
				int shearingTime=Integer.parseInt(splitLines[1]);
				int arrivalTime= Integer.parseInt(splitLines[2]);
				SheepProperties newSheep= new SheepProperties(sheepName, shearingTime, arrivalTime);
//				addSheepLL(newSheep);
//				addSheepQQ(newSheep);
				mSP.add(newSheep);
				System.out.println(newSheep);
				
				
			}
			
		}
		fileReader.close();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	}
	public void sheepSchedulerAttmpt3()
	{	System.out.println(qSP.peek());
		System.out.println(firstSheepQQ());
		int count=firstSheepQQ().getArrivalTime();
//		while(qSP.peek()!=null)
//	{	if(qSP.peek().getArrivalTime()<=count)
//	{	SheepProperties ord=qSP.dequeue();
//		mSP.add(ord);
//		count+=ord.getShearingTime();
//		System.out.println(count);
//		
//	}
//	else
//	{
//		continue;
//	}
//		
//	}
		SheepProperties dog=new SheepProperties();
	while(qSP.peek()!=null)
	{	
		if(qSP.peek().getArrivalTime()>count)
	{	
		System.out.println("adding");
		count+=qSP.dequeue().getShearingTime();
		addSheep2Heap(qSP.dequeue());
//		mSP.print();
	}
	else
	{
			continue;
	}
	}
	
		
		
	}
	public String currSheep(SheepProperties S)
	{	String name="";
		if(S!=null)
		{
			name=S.getName();
		}
		return name;
	}
	public SheepProperties firstSheepLL()
	{	
//		SheepProperties newShp= new SheepProperties();
		SheepProperties test=new SheepProperties();
		for(int i=0;i<newS.getSize();i++)
	{	
		if(newS.getAt(i).getArrivalTime()==0)
		{
			test=newS.getAt(i);
			break;
		}
	}
		
		return test;
	}
	public SheepProperties firstSheepQQ()
	{	LLQueue<SheepProperties> tes=qSP;
		while(tes.peek().getArrivalTime()!=0)
		{	
			tes.dequeue();
		}
		return tes.peek();
		
	}
	public static boolean addRest2Heap()
	{	
		for(int i=0;i<sPA.length;i++)
	{	
		addSheep2Heap(sPA[i]);
	
		if(i==sPA.length-1)
		{
			System.out.println("The rest of the sheep were added to the heap.");
		}
	}
		return mSP.getSize()>0;
	}
	
	public static void print(SheepProperties[] a)
	{	for(int i=0;i<a.length;i++)
	{
		System.out.println(a[i]);
	}
		
	}
	public void sheepSchedulerAtmp2()//<-- This is used to create my sheep schedule.
	{	int count=firstSheepLL().getArrivalTime();
		System.out.println("All sheep have been sheared. Here is your schedule below.");
		
		addSheep2Heap(firstSheepLL());
//		mSP.heapSort(sPA);
		for(int i=0;i<add2ArrayLL(newS).length;i++)
		{
		if(add2ArrayLL(newS)[i].getArrivalTime()>count)
		{
//			System.out.println(sPA[i]);
			mSP.add(add2ArrayLL(newS)[i]);
			count+=add2ArrayLL(newS)[i].getShearingTime();
		}
		else if(add2ArrayLL(newS)[i].getArrivalTime()<=count)
		{
			System.out.println(add2ArrayLL(newS)[i]);
			count+=add2ArrayLL(newS)[i].getShearingTime();
		}
			
		}
			
		
	}
	public void sheepSchedulerAtmp3()
	{	Integer count=firstSheepQQ().getArrivalTime();
		while(qSP.peek()!=null)
		{	SheepProperties reg=qSP.dequeue();
			if(reg.getArrivalTime()>count)
			{	mSP.add(reg);
//				count+=reg.getShearingTime();
				System.out.println(count);
				System.out.println(reg);
			}
			else
			{
//				mSP.add(reg);
			}
			
			
		}
		if(qSP.peek()==null)
		{	System.out.println("All sheep have been sheared. Here is your schedule below.");
			mSP.print();
			
		}
		
	}
	public void sheepSchedulerAtmp4()
	{	System.out.println("All sheep have been sheared. Here is your schedule below.");
		mSP.print();//<-- This is the method that depends strictly on the compareTo method in the sheepProperties.java file. It ensures that 
		//The sheep are ordered based on the comparison between the sum of a sheep's shearing time and arrival time and the arrival time of the sheep that follows.
		//If both comparatives are equal, then they are ordered based on their respective shearing times.
	}
	

}

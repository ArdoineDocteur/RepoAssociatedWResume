//This is a class manager that will use the structured array to add, remove, sort, and read and write to the files when neccessary.
import java.io.*;
import java.util.*;
import java.util.Random;
public class ShowCaseGameCM 
{	private ShowCaseGame[]showcaseGame;
	public static final int BODY_FIELD_AMT=2;
	public static final String DELIM="\t";//<-- The delim is set to this because the file that must be read is in tab delimited format.
	public static final int DEF_SIZE=52;//<-- Maximum amount of items.
	public static ShowCaseGameCM CM= new ShowCaseGameCM();
	public static Random r= new Random();
	public static int sumOfPrices=0;
	public static final int maxItemPrints=5;
	private void init(int size)
	{
		if(size>=1 && size!=52)
		{
			showcaseGame= new ShowCaseGame[size];
		}
		else
		{
			showcaseGame=new ShowCaseGame[DEF_SIZE];
		}
	}
	public ShowCaseGameCM()
	{
		init(DEF_SIZE);
	}
	public ShowCaseGameCM(int size)
	{
		init(size);
	}
	
	public void readPrizeFile(String fileName)
	{	try 
	{	Scanner fileScanner= new Scanner(new File(fileName));
		/*The prize file is tab delimited which means the fileScanner needs
		 * to use the nextLine() delimiter.
		*/
	while(fileScanner.hasNextLine())
	{	String fileLine=fileScanner.nextLine();
		String splitLines[]=fileLine.split(DELIM);
		if(splitLines.length==BODY_FIELD_AMT)
		{	
			String itemName=splitLines[0];
			int itemPrice=Integer.parseInt(splitLines[1]);
			ShowCaseGame aItem=new ShowCaseGame(itemName, itemPrice);
			this.addItems(aItem);
		}
		else
		{	
			continue;
		}
		
		
	}
	fileScanner.close();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	}
	public void addItems(ShowCaseGame sCG)//For adding structures of data from the file.
	{	if(sCG==null)
	{
		return;//means that the instance of the class is non existent
	}
	if(showcaseGame[showcaseGame.length-1] !=null)
	{
		return;//means that the array is full
	}
	for(int i=0;i<showcaseGame.length;i++)
	{
		if(showcaseGame[i]==null)
		{
			showcaseGame[i]=sCG;//Assigns the ShowCaseGame memory address to sCG.
			break;//The break statement breaks the loop as soon as its ran which allows us to add exactly one instance of the ShowCaseGame class.
		}
	}
		
	}
	public void printItems(int sizeStop)//thinking about making parameter here to stop make the items appear in fives instead of all of them at one time.
	{	if(sizeStop!=0)//implemented randomizer but I need it to stop duplicating values. May need a branching statement for it. Thinking about creating a while loop for it.
		{
		for(int i=0;i<showcaseGame.length;i++)
		{	if(showcaseGame[i]==null || i==sizeStop )
		{
			break;
		}
			
		System.out.println(showcaseGame[r.nextInt(sizeStop)]);
		}
		}
	else if(sizeStop==0)
	{	for(int i=0;i<showcaseGame.length;i++)
	{
		if(showcaseGame[i]==null)
		{
			break;
		}
		System.out.println(showcaseGame[i]);
	}
		
	}
	
	}
	public void printItemName(int sizeStop)
	{	ShowCaseGame[]currentSet=new ShowCaseGame[5];//<-- Used to compare the current sets to ensure that the random results dont match.
		boolean repeat=false;
		if(sizeStop!=0)
	{	
		for(int i=0;i<maxItemPrints;i++)
		{	
			if(i>=1)
			{
				repeat=currentSet[r.nextInt(5)]==currentSet[r.nextInt(5)];//<-- This is used to ensure that each item in the set is unique.
			}
			int g=0;
			if(restrictSameValues(g,r.nextInt(52))||repeat==false)
			{	g=r.nextInt(52);
				int h=0;
				if(g!=0)
				{	h=r.nextInt(g);
					System.out.println("Item # "+h+": "+showcaseGame[h].getItemName());
					sumOfPrices+=recieveItemPrice(h);
					currentSet[i]=showcaseGame[h];
				}	
				else
				{
					System.out.println("Item # "+g+": "+showcaseGame[g].getItemName());
					sumOfPrices+=recieveItemPrice(g);
					currentSet[i]=showcaseGame[g];
				}
				if(i==currentSet.length-1 && currentSet[4]==null)
				{
					System.out.println("Item # "+g+": "+showcaseGame[g].getItemName());
					sumOfPrices+=recieveItemPrice(g);
					currentSet[i]=showcaseGame[g];
				}
				
			}
//			if(i==4 && repeat==true)
			
		}
	
	}
	else if(sizeStop==0)
	{
		for(int i=0;i<showcaseGame.length;i++)
		{	if(showcaseGame[i]==null)
		{
			break;
		}System.out.println(showcaseGame[i].getItemName());
			
		}
	}
		
	}
	public int recieveItemPrice(int itemNumber)
	{	
	return showcaseGame[itemNumber].getItemPrice();
	}
	public boolean restrictSameValues(int val1, int val2)//Tried numerous times to prevent my items from duplicating.
	{	if(val1!=val2)
	{
		return true;
	}
	else
	{
		return false;
	}
	
	}
	public static int noDupes(int a)//This method was supposed to prevent dupes from occuring.
	{	if(a!=a)
	{
		return a*=2;
	}
	else
	{
		return a;
	}
		
	}
	public static void WinnerOrLoser(String uI)
	{	if(Integer.parseInt(uI)<=CM.sumOfPrices && Integer.parseInt(uI)>=CM.sumOfPrices-1300)
	{	System.out.println("YOU WIN!");
		
	}
	else
	{
		System.out.println("HA. You LOSE!");
		
	}System.out.println("The actual cost was: "+CM.sumOfPrices);
	CM.sumOfPrices=0;
		
	}
	
	
	
	
	
}
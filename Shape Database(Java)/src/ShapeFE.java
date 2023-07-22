import java.util.Scanner;
public class ShapeFE 
{
public static Scanner u_input= new Scanner(System.in);
public static ShapeCM sCM= new ShapeCM();
public static String userInput;
public static int caseSel;
public static String endUserIP;
public static void main(String[]args)
{	boolean endGame=false;
	boolean inProgress=true;

	
	while(endGame==false)
	{
	while(inProgress==true)
	{
	greeting();
	caseSel=Integer.parseInt(u_input.nextLine());
	u_input.nextLine();
	if(caseSel==0)
	{
		System.out.println("Invalid Input. Try again");
		inProgress=true;
	}
	switch(caseSel)//As of now, all methods work properly, doing a final test to iron out all errors. as of now, all methods work properly, still doing final testing.
	{	case 1: 
		readShapeTree();//<-- Works but only catches the first line in the file. Have to figure out why.(problem fixed)
		inProgress=false;
		break;
		case 2: 
		printTrav();//<-- This doesn't work although data has been printed to console.(currently works now)
		inProgress=false;
		break;
		case 3:
		addShapes();//<-- Works properly unless you enter a circle's radius, need to go to CM to fix.(fix complete)
		inProgress=false;
		break;
		case 4:
		removeShapes();//<-- Removes shapes properly.
		inProgress=false;
		break;
		case 5:
		searchShape();//<-- Implemented, needs testing.(complete)(need to figure out how to get the entire toString to print, fixed issue, now working properly).
		inProgress=false;
		break;
		case 6: 
		findMaxShapeArea();//<-- Implemented, needs testing(complete)(works properly)
		inProgress=false;
		break;
		case 7:
		removeShapesGTDArea();//<-- Implemented, needs testing.(needs work, complete the method works properly now)
		inProgress=false;
		break;
		case 8: 
			printShapeTree2File();//<-- Doesnt work, have to fix(complete, it now works properly)(there are a few bugs, need more testing, COMPLETE!)
			inProgress=false;
			break;
		case 9: 
			System.out.println("Are you ready to quit?");
			userInput=u_input.nextLine();
			if(userInput.equalsIgnoreCase("Yes"))
			{
				System.out.println("Thanks for playing!");
				sCM.resetData();
				System.exit(0);
			}
			else if(userInput.equalsIgnoreCase("no"))
			{	System.out.println("Your wish is granted.");
				inProgress=true;
			}
			else
			{
				System.out.println("Invalid input.");
				inProgress=true;
			}
		default:
			System.out.println("Invalid Entry.");
			inProgress=true;
	}
	
	}
	System.out.println("You have finished completing option #"+caseSel+". Enter yes to continue to the main menu.");
	endUserIP=u_input.nextLine();
	if(endUserIP.equalsIgnoreCase("yes"))
	{	inProgress=true;
		
	}
	else
	{	System.out.println("Invalid Input.");
		inProgress=true;
	}
	//Adding some option that asks player if they wanna start a new game. If true I will call the reset method from the BST.
	}
	
}
	
public static boolean validShape(String s)
{
	return s.equalsIgnoreCase("Circle") || s.equalsIgnoreCase("Right Triangle") || s.equalsIgnoreCase("Rectangle");
}
		
	
	
	

public static void greeting()
{
	System.out.println("Welcome to the shape creator!!");
	System.out.println("Follow the instructions below: ");
	System.out.println("Enter 1 to read a shape tree from a file. \n"+
	"Enter 2 to print a tree traversal to the console.\n"+
	"Enter 3 to add a shape, "
	+ "Enter 4 to remove a shape\n "
	+ "Enter 5 to search for a shape\n "
	+ "Enter 6 to find the shape with the max area\n "
	+ "Enter 7 to remove all shapes greater than the area\n"
	+ "Enter 8 to print the shape tree to the file\n"
	+ "Enter 9 to quit."		
			);
	
}
public static void addShapes()
{	String fileName;
	String shapeName;
	int shapeLength=0;
	int shapeWidth=0;
	int i=0;
	boolean addFile=false;
	//Here I will put the neccessary code for the user to add shapes.
	System.out.println("You are currently about to begin your entry of shapes. Before we get started, if applicable, would you like to reset your previous entries on your user file?");
	userInput=u_input.nextLine();
	if(userInput.equalsIgnoreCase("yes"))
	{	System.out.println("Your data file's info has been reset.");
		addFile=false;
	}
	else if(userInput.equalsIgnoreCase("no"))
	{
		System.out.println("Okay. Your data file's info has not been reset.");
		addFile=true;
	}
	else
	{
		System.out.println("Invalid Input. Return to the main menu and try again.");
		return;
	}
	System.out.println("Enter the name of your shape. It must be either a right triangle, circle, or Rectangle");
	userInput=u_input.nextLine();
	if(validShape(userInput)==true)
	{	shapeName=userInput;
		System.out.println("Excellent, now enter both the length and width of your shape, if applicable. Ensure that you leave one space between both numbers.");		
		userInput=u_input.nextLine();
		if(userInput!=null)
		{	String[]numSplit=userInput.split(" ");
			if(numSplit.length==2)
			{
			shapeLength=Integer.parseInt(numSplit[0]);
			shapeWidth=Integer.parseInt(numSplit[1]);
			if(shapeName.equalsIgnoreCase("Circle"))
			{
				shapeLength=Integer.parseInt(numSplit[0]);
				shapeWidth=0;
			}
			
			}
			ShapeProperties userEntry= new ShapeProperties(shapeName,numSplit,sCM.FormAreas(shapeName, shapeLength, shapeWidth));
			sCM.addShapes(userEntry);
			if(addFile==true)
			{	
				sCM.write2ShapeFile(userEntry, true);
			}
			else if(!addFile)
			{
				sCM.write2ShapeFile(userEntry, false);
			}
			
			System.out.println("Your added shape information is: "+userEntry);
			
		}
	}
	else
	{
		System.out.println("Invalid input. Go back to the main screen to try again.");
	}sCM.printContent("In-Order");
}//For my addShapes method, I need to have the data add to a user file by default just in case they want to print their trees to a file.
public static void removeShapes()
{	String shapeName;
	String shapeInformation;
	sCM.printContent("In-Order");
	System.out.println("Using the information above, Enter the shape name you would like to remove.");
	shapeName=u_input.nextLine();
	if(shapeName!=null)
	{	
//		System.out.println("Currently searching for "+userInput+".....");
		System.out.println("Nice, enter the two numbers that equal the area of shape: "+shapeName+" that you want to remove. Remember to leave a space between the values.");
		shapeInformation=u_input.nextLine();
		if(shapeInformation!=null)
		{	String[]spL=shapeInformation.split(" ");
			ShapeProperties remoVIN= new ShapeProperties(shapeName,spL,sCM.FormAreas(shapeName, Double.parseDouble(spL[0]), Double.parseDouble(spL[1])));
			System.out.println("Currently removing: "+shapeName);
			sCM.removeShapes(remoVIN);
			System.out.println(remoVIN.toString()+"\t"+" has been removed.");
		}
		
	}
	else
	{	System.out.println("Invalid Input. Go back to the main screen to try again.");
		
	}
	
}
public static void readShapeTree()
{	String add;
	boolean addFile=false;
	System.out.println("You are currently about to begin your entry of shapes via file entry.");
	System.out.println("Before we get started, would you like to add this data to your user file?");
	add=u_input.nextLine();
	if(add.equalsIgnoreCase("yes"))
	{	System.out.println("Your file entry will be be apart of your user file.");
		addFile=true;
	}
	else if(add.equalsIgnoreCase("no"))
	{	System.out.println("Your file entry will not apart of your user file.");
		addFile=false;
	}
	else
	{
		System.out.println("Invalid input. Go to the main menu to try again.");
		return;
	}
	System.out.println("What is the name of the file you are entering?");
	userInput=u_input.nextLine();
	if(userInput!=null || userInput!="\s*")
	{	System.out.println("Your file name was: "+userInput);
		sCM.readShapeFile(userInput,addFile);
		
	}
}
public static void searchShape()
{	String shapeName;
	String shapeInfo;
	System.out.println("Welcome to the shape searcher. By the way, if you are searching a shape make sure you have already entered in a shape file.");
	System.out.println("Enter the name of your desired shape.");
	shapeName=u_input.nextLine();
	if(shapeName!=null && shapeName.equalsIgnoreCase("Circle"))
	{	System.out.println("Excellent, now enter the radius of the circle.");
		shapeInfo=u_input.nextLine();
		System.out.println("Excellent, I am currently searching...");
		String[]dataS= {shapeInfo,"0"};
		ShapeProperties searchingC= new ShapeProperties(shapeName,dataS,sCM.FormAreas(shapeName,Double.parseDouble(shapeInfo),0));
		sCM.searchShapes(searchingC);
	}
	else if(shapeName!=null && !(shapeName.equalsIgnoreCase("Circle")))
	{
		System.out.println("Excellent, now enter both the length and width of the "+shapeName+".");
		shapeInfo=u_input.nextLine();
		System.out.println("Excellent, I am currently searching...");
		String[]dataS=shapeInfo.split(" ");
		ShapeProperties searchingNC= new ShapeProperties(shapeName,dataS,sCM.FormAreas(shapeName,Double.parseDouble(dataS[0]),Double.parseDouble(dataS[1])));
		sCM.searchShapes(searchingNC);
	}

}
public static void findMaxShapeArea()
{
	sCM.MaxArea();
}


public static void removeShapesGTDArea()
{	//I can probably create a method similar to the max area to get this done.
	String[]shapes= new String[2];
	String[]test= {"Removal","Removal"};
	double Area;
	System.out.println("You are currently removing all shapes that are greater than the area you input.");
	System.out.println("Enter an area.");
	Area=u_input.nextDouble();
	if(Area>0)
	{	
		sCM.removeShapesArea(Area);
	}
	else if(!(Area>0))
	{
		System.out.println("Invalid Input. Go to main menu to try again.");
		return;
	}
}
public static void printShapeTree2File()
{	System.out.println("You are currently printing your shapes to a file.");
	System.out.println("Enter a name for your file.");
	userInput=u_input.nextLine();
	if(userInput!=null)
	sCM.printToShapeFile(userInput);

	
}
public static void printTrav()
{ System.out.println("Welcome to the printer! You have three options.");
	System.out.println("1) Print Pre-Order"+"\n"+"2) Print In-Order"+"\n"+"3) Print Post-Order");
	userInput=u_input.nextLine();
	if(Integer.parseInt(userInput)<=3 && Integer.parseInt(userInput)>0)
	{	if(userInput.equalsIgnoreCase("1"))
		sCM.printContent("Pre-Order");
	else if(userInput.equalsIgnoreCase("2"))
	{
		sCM.printContent("In-Order");
	}
	else if(userInput.equalsIgnoreCase("3"))
	{
		sCM.printContent("Post-Order");
	}
	}
	else
	{
		System.out.println("Invalid Input. Go to main menu to try again.");
		return;
	}
	
	
	
}




	
	
}

/*	Methods needed for Class Manager:
 * FileReader, FileWriter, addShape(complete), removeShape(may be complete) ShapeInfo Printer(complete), and maybe more.
 * Also, need to instantiate the BST as well as other variables that I may need for
 * my project to work.  
 * 
 * 
 */
import java.util.*;
import java.io.*;
public class ShapeCM 
{	
	public static LinkedBST<ShapeProperties> sBST= new LinkedBST<ShapeProperties>();
	public static LinkedBST<String> Shapes= new LinkedBST<String>();
	public static ShapeCM sCM= new ShapeCM();
	public static double shapeArea=0;
	//Will use the method below to set the areas for the shapes.
		public static double FormAreas(String shape, double length, double width )
	    {	double Area=0;
	    	if(shape.equalsIgnoreCase("Rectangle") && length>0 && width>0)
	    {
	    	  Area=length*width;
	    }
	    else if(shape.equalsIgnoreCase("Right Triangle") && length>0 && width>0)
	    {
	    	 Area=(length*width)/2;
	    }
	    else if(shape.equalsIgnoreCase("Circle") && length>0)
	    {
	    	Area=Math.PI*(Math.pow(length, 2));
	    }
	    	return Area;
	    }

	public void resetData()
	{
		sBST.reset();
	}
	public static void addShapes(ShapeProperties s)
	{
		Shapes.add(s.getShape());
		sBST.add(s);
	}
	public static void removeShapes(ShapeProperties shapeName)
	{	
		Shapes.remove(shapeName.getShape());
		sBST.remove(shapeName);
	}
	public void searchShapes(ShapeProperties searchS)
	{	
		if(Shapes.search(searchS.getShape())==true && sBST.search(searchS))
		{	System.out.println("Your shape exists.");
			System.out.println(sBST.data(sBST.searchNRet(searchS)));			
		//Have to figure out how to make a method that accepts some shapeName and then searches for values with that specific shape name and
		//there respective areas:
		}
		else
		{
			System.out.println("Shape does not exist in the database.");
		}
		
	}
	public void removeShapesArea(double area)
	{	while(sBST.maxValue()!=null && sBST.data(sBST.maxValue())!=null && sBST.data(sBST.maxValue()).getArea()>=area)
	{
		sCM.removeShapes(sBST.data(sBST.maxValue()));
	}
	if(sBST.maxValue()==null || sBST.data(sBST.maxValue())==null)
	{
		System.out.println("There is no data to evaluate. Go add shapes manually or via file entry in the main menu.");
		return;
	}
	else if(!(sBST.data(sBST.maxValue()).getArea()>=area))
	{
		System.out.println("All of the shapes greater than the area "+area+" have been removed.");
		sCM.printContent("In-Order");
	}
	}	
		
	public void MaxArea()
	{	if(sBST.maxValue()!=null)
		{sBST.maxValue();
		System.out.println("The Shape with the max area is: "+sBST.data(sBST.maxValue()).toString());
		}else
		{
		System.out.println("There is no max value because there is no data available. Go add shapes manually or via file entry in the main menu.");
		return;
		}
	}
	public void readShapeFile(String fileName, boolean append)
	{	try
	{	Scanner fileReader= new Scanner(new File(fileName));
		PrintWriter fileWriter= new PrintWriter(new FileOutputStream(new File("./userData.txt"),append));
		while(fileReader.hasNextLine())
		{	String fileLine=fileReader.nextLine();
			String[]splitLines=fileLine.split("\t");
//			System.out.println(fileLine);
			if(splitLines.length==3)
			{	
				String shapeName=splitLines[0];
				String shapeLength=splitLines[1];
				String shapeWidth=splitLines[2];
				String[]dataE= {shapeLength,shapeWidth};
				
				ShapeProperties newS= new ShapeProperties(shapeName,dataE,FormAreas(shapeName,Double.parseDouble(shapeLength),Double.parseDouble(shapeWidth)));
				System.out.println(newS);
				fileWriter.println(newS);
				addShapes(newS);
			}
			else if(splitLines.length==2)
			{	String shapeName=splitLines[0];
				String radius=splitLines[1];
				String[]dataC= {radius,"0"};
				ShapeProperties newS= new ShapeProperties(shapeName,dataC,FormAreas(shapeName,Double.parseDouble(radius),0));
				System.out.println(newS);
				fileWriter.println(newS);
				addShapes(newS);
			}
			
		}fileReader.close();
		fileWriter.close();
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
		
	}
	
	public void write2ShapeFile(ShapeProperties userInput,boolean append)
	{	//When making my method for writing to a shape file in the FE, i am thinking about using a for loop with arrays to add different instances of shapeProperties to the file.
		try
	{	//Append determines to overwrite or add to the current file.
		PrintWriter fileWriter= new PrintWriter(new FileOutputStream(new File("./userData.txt"),append));//<-- This creates a default file when the user wants to write data to a file.
			//Have to figure out how to implement the fileWriters using BSTs.
			fileWriter.println(userInput);
			//Some method from BST that allows me to move to the next node in order. May involve the functionality of the printInOrder traversal type.
			//not sure if permissible but if I use a linked list, store the ShapeProperties in it, and then use its data for the params of the BST's search it may help solve my issue.
		
		fileWriter.close();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
		
	}
	public void printToShapeFile(String fileName)//<-- Complete, just need to test. Tested, the shape info is still not printing to the file, have to figure out why.
	{	try
	{	Scanner fileReader= new Scanner(new File("./userData.txt"));
		PrintWriter fileWriter= new PrintWriter(new FileOutputStream(new File(fileName),true));
		while(fileReader.hasNextLine())
	{	String fileLine=fileReader.nextLine();
		System.out.println(fileLine);
		fileWriter.println(fileLine);
		
	}fileReader.close();
	fileWriter.close();
	
}catch(Exception e)
{
	e.printStackTrace();
}
	
	}
	
	public void printContent(String choice)//<-- Although methods run properly, the method here, doesnt work correctly must figure out why.
	{	if(sBST.maxValue()==null)
	{
		System.out.println("There is no data to print. Go to main menu to add data to output.");
		return;
	}
	else
	{
		if(choice.equalsIgnoreCase("Pre-Order"))
	{
		sBST.printPreOrder();
	}
	else if(choice.equalsIgnoreCase("In-Order"))
	{
		sBST.printInOrder();
	}
	else if(choice.equalsIgnoreCase("Post-Order"))
	{
		sBST.printPostOrder();
	}
		
	}
	
	}
	public void emptyData()
	{
		sBST.reset();
	}
	public static void main(String[]args)
	{
		sCM.printToShapeFile("Dollar.txt");
	}
}

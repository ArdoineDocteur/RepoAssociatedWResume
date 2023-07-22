/*Objective:Write a program where a user can maintain a collection of shapes that are organized by their area using a
 *  binary search tree data structure. The program must be able to add/remove shapes, read/write to shape files, 
 *  search for shapes, and perform a variety of other operations.
 * 
 * 
 * Report tab:
 * -3/26/23 @ 8:54 PM: Currently harping on a way to create an accessor for my BST.
 * -3/27/23 @ 3:48PM: Created a few new methods in generic BST, currently testing out my FE.
 * However, I have a problem with my file reader. Also, need to make some while loop that keeps the
 * program running after a method has finished.
 * -3/28/23 @ 11:45PM: Solved most of the issues above, refer to notes beside methods for additional info
 * as well as bugs that need to be fixed.

 *Current Problems: 
 *-Need to finish setting up CM, as well as implementing the BST correctly.(complete, currently testing)
 *-Need to figure out how to access data @ certain points in the BST. Thinking about
 *doing it how I would do it regularly except that I would put the specified data through
 *the search method and then return the node that it found.(Have implemented new methods to solve this, nearly complete, currently testing)
 *-Need to finish creating my front end.(complete)
 *-There is a problem with my file reader. It is giving a runtime error.
 *
 *-There is an issue with my read shape CM method, and there is an issue for adding data to my binary tree after data is entered.
 *Important Notes: 
 *-UI needs to be user friendly. Specifically, it must allow the user to add, remove,
 *search, find the shape with the maximum area, remove all shapes greater than a certain
 *area, read from a shape file, and wirte to a shape file.
 *-User must also be able to print the data to the console in either of the three traversal of their choice.
 *-The three valid shapes are the circle, rectangle, and right triangle.
 *Formulas for Area for these three shapes: circle(pi*r^2), right triangle((b*h)/2), and rectangle(l*w)
 *Ideas: 
 *-Using the case format for my FE.
 *-Make a binary search tree specifically for the shapes, and another for the formulas for the areas of the shapes? 
 	-Currently trying to implement getters and setters inside of my BST.
 */

//Rn, my properties class will contain the shape name, and then shape information.
public class ShapeProperties implements Comparable<ShapeProperties>  
{
    //Will use the method below to set the areas for the shapes.
	
	public int compareTo(ShapeProperties shapeName)
    {	
		return (int)this.getArea()-(int)shapeName.getArea();	
    }

	private String shape;
	private String shapeInfo;
	private double Area;
	public ShapeProperties()
	{	this.shape="";
		this.shapeInfo="";
		this.Area=0;
	}
	public ShapeProperties(String sH, String sI[], double A)
	{	
		this.setShape(sH);
		this.setShapeInfo(sI);
		this.setArea(A);
	}
	public String getShape()
	{
		return this.shape;
	}
	public void setShape(String sH)
	{	
		if(sH.equalsIgnoreCase("Circle") || sH.equalsIgnoreCase("Right Triangle") || sH.equalsIgnoreCase("Rectangle"))
	{
		this.shape=sH;
	}
	else
	{
		this.shape="Invalid Shape";
	}
		
	}
	
	public String getShapeInfo()
	{	
		return this.shapeInfo;
	}
	public void setShapeInfo(String[] sI)
	{	if(sI!=null && !(this.shape.equalsIgnoreCase("circle")))
	{	this.shapeInfo=sI[0]+" "+sI[1];
		
	}
	else if(sI!=null && (this.shape.equalsIgnoreCase("circle")))
	{
		this.shapeInfo=sI[0];
	}
	else
	{
		this.shapeInfo="Invalid Input";
	}
	
		
	}
	public double getArea()
	{
		return this.Area;
	}
	
	public void setArea(double A)
	{	if(A>0)
	{
		this.Area=A;
	}
	else
	{
		this.Area=0;
	}
		
	}
	
	public boolean equals(ShapeProperties sP)
	{	
		return sP!=null && this.shape.equals(sP.getShape()) && this.shapeInfo.equals(sP.getShape()) && this.Area==sP.getArea();
	}
	public String toString()
	{	String output="";
		if(this.shape.equalsIgnoreCase("Circle"))
		output="Shape Name: "+this.shape+" Shape Information: "+"Radius: "+this.shapeInfo+" Shape Area: "+this.Area;
	else if(!(this.shape.equalsIgnoreCase("circle")))
		output="Shape Name: "+this.shape+" Shape Information: "+"Length and Width: "+this.shapeInfo+" Shape Area: "+this.Area;
	return output;
	}

	
}

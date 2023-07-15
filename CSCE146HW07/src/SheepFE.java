//Ardoine Docteur
import java.util.Scanner;
public class SheepFE 
{	public static Scanner u_input= new Scanner(System.in);
	public static String userInput;
	public static SheepCM sCM= new SheepCM();
	public static void main(String[]args)
	{
	
	boolean startMenu=true;
	while(startMenu==true)
	{
	greetings();
	userInput=u_input.nextLine();
	boolean inProgress=false;
	switch(Integer.parseInt(userInput))
	{
		
	case 1:
		inProgress=true;
		startMenu=false;
		break;
	case 2:
		System.out.println("Are you ready to quit?");
		userInput=u_input.nextLine();
		if(userInput.equalsIgnoreCase("yes"))
		{	System.out.println("Your wish is granted");
			System.exit(0);
			
		}
		else if(userInput.equalsIgnoreCase("no"))
		{	System.out.println("Your wish is granted");
			startMenu=true;
			
		}
		break;
	
	}
	
	while(inProgress==true)
	{
		SSScheduler();
		startMenu=true;
		inProgress=false;
	}
	}
	
	}
	
	
	public static void greetings()
	{	System.out.println("Welcome to the sheep shearing scheduler.\n Follow the instructions below.");
		System.out.println("Enter 1 to begin adding sheep.\n Enter 2 to quit.");
	}
	public static void SSScheduler()
	{	String fileEntry;
		System.out.println("Start by entering your file that you want to read in. If you would like to return to the main menu, enter \"main\".");
		fileEntry=u_input.nextLine();
		if(fileEntry.equalsIgnoreCase("main"))
		{	System.out.println("Returning to main menu");
			return;
		}
		System.out.println("Excellent! Your read in information is below: ");
		sCM.sheepFileReader(fileEntry);
		System.out.println("Are you satisfied with your information?");
		userInput=u_input.nextLine();
		if(userInput.equalsIgnoreCase("yes"))
		{	System.out.println("Excellent! Currently starting your scheduler.");
			sCM.sheepSchedulerAtmp4();
			System.out.println("Your schedule has been printed, returning to main menu...");
		}
		else if(userInput.equalsIgnoreCase("no"))
		{	System.out.println("Okay. Return to the main menu to read in a new file.");
			return;
			
		}
		
	}

}


import java.util.Scanner;
import java.util.Random;
public class ShowCaseGameFE 
{	public static ShowCaseGame sh= new ShowCaseGame();
	public static Scanner u_input= new Scanner(System.in);
	public static ShowCaseGameCM CM= new ShowCaseGameCM();
	public static final int DEFAULT_NUMBER_OF_PRINTS=5;
	
	
	public static void main(String[]args)
	{	CM.readPrizeFile("./prizeList.txt");
		String userInput;
		boolean isPlaying=false;
		
		int soP=CM.sumOfPrices;
		System.out.println("Welcome tooooooooo SHOWCASE!");
		System.out.println("How are you feeling today challenger?");
		userInput=u_input.nextLine();
		u_input.nextLine();//<-- Fix-up
		boolean startScreen=false;
		if(userInput!=null)
		{startScreen=true;
			while(startScreen==true)
			{
			System.out.println("However you are feeling, I GUARANTEE that you will be better after participating in my game show!");
			System.out.println("Are you ready to play?!");
			{	userInput=u_input.nextLine();
				if(userInput.equalsIgnoreCase("yes"))
				{	System.out.println("Great! Let's begin.");
					CM.printItemName(DEFAULT_NUMBER_OF_PRINTS);
					isPlaying=true;
					startScreen=false;
					
				}
				else if(userInput.equalsIgnoreCase("no"))
				{
					System.out.println("Come back when you are ready.");
					startScreen=true;
				}
				else
				{
					System.out.println("Invalid Input. Try again.");
					startScreen=true;
				}
			
			}
		}
			
		}
		while(isPlaying==true)
		{
			
		System.out.println("With that out of the way, start by observing the five items from the text above.");
		System.out.println("Now, guess the sum of all the items. If your guess is between the exact amount and $1300 below, you win!");
		userInput=u_input.nextLine();
		if(Integer.parseInt(userInput)>=0)
		{CM.WinnerOrLoser(userInput);
		
		}
		else
		{	System.out.println("Invalid Input. Try Again.");
			isPlaying=true;
		}
		soP=0;
		System.out.println("Would you like to keep playing?");
		userInput=u_input.nextLine();
		if(userInput.equalsIgnoreCase("Yes"))
		{	System.out.println("Good Luck!");
			CM.printItemName(DEFAULT_NUMBER_OF_PRINTS);
			isPlaying=true;
			
		}
		else if(userInput.equalsIgnoreCase("no"))
		{
			System.out.println("Thanks for playing!");
			isPlaying=false;
			System.exit(0);
		}
		
		}
	}
}

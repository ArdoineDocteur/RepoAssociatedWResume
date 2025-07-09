/* Purpose: Purpose of this file is to house the code neccessary to carry out the logic required to make the project work. 
 * Initial Thoughts before coding: 1) Thinking about using a class diagram to display the classes and member vars required to make game work[in progress]. 2) Need to transform the rules of the Yachtzee game into a list of properties of the program to plan it properly. 3) Write psuedocode that abstractly describes how the user's input travels through the game and is interpreted by the system. 4) (cont here if applicable)
 *
 *
 *
 * - Properties of the game: a) Has dice[meaning it has 6 differnet vals], b) each Dice must be able to be rolled at most 3 times[but can generalize to n times], c) The dice results are joint sets that are used to acheive a total score, d) Game requires 13 rounds[but can generalize to o times], e) There is a set of scoring categories that affect how the results of the 5 dice are used to produce a score[meaning a 3-bit bool value may be needed to traverse these], e) (cont here if applciable)
 *   - Versions of how user input is processed through program: v1) User decides to turn on system. System responds by running it initializer function which is responsible for setting up the environment by adhering to the steps that belong to tuple K. After setting up environment, system lets the user know that it is ready for them to execute the first step a that belongs to tuple J. The steps in tuple J will be used to navigate user to start their first game. NOTE: Before we continue, tuple K = ([cont here bywriting the steps that the system needs the user to execute to setup environment],), and tuple J = () ([cont here bywriting the steps that the system needs the user to execute to navigate user from 'initial state' to playing the game itself],)
 * - Small Report: Finish implementation of first version of project. Create macros that reference the input of the switches so the program is similar to a plug-n-play when actual testing begins. Also, update classDiagram such that class used here is reflected in the diagram. 
 *   - NOTES: 1) A stage member var needs to be used so program can react to switch inputs BASED ON STAGES of the game. This limits the buttons we need to facilitate game, as well as creates reusability. This means we only need k + 1 buttons, where k = number of buttons to bridge interaction between game and system, and (k + 1)th button will be the reset button. 2) Thought about allowing multiple players since prog is built to handle that. 
 * RESOURCES FOR INTEGRATION WITH HARDWARE CIRCUIT: 1) https://docs.arduino.cc/learn/electronics/lcd-displays/, 2) (cont here if applicable)
 * NOTE: 1) There are 7 scoring conditions, 2) Manipulate code to have random number scrolling on displays, and THENNN have the actual number print out. 3) Tilt sensor input will be input for a RS-flip-flop. 4), need to ensure that all allocated memory is deleted when user decides to press the reset button. 50 Need to store unsorted version of dice in user object so the correct order of vals are displayed on the HEX. 
 * */
	// TASK: FIX all of the compiler errors referenced by vs code's intellisense. [COMPLETE, only thing causing currrent errors is presence of usleep which uses unistd module which is exclusive to microcontrollers and linux OSs]. UPDATE: Finished code, now sending to linux remote shell to test out and debug more.  ALSO, to see how to do user input in C, use the following grep command: `grep -E "user input" ../*/*C/*.c -A 14`. UPDATE #2: Fixed all bugs associated with code so that it's compilable on linux machine. NOTE: After running, found that line-up for main code is causing a seg fault. Need to iteratively debug to understand why this is the case. [NOTE: Turns out, I failed to allocate memory in some places. This is due to the absence of the imps for the setters in numerous objects]. UPDATE #3: Fixed setter funcs issues. Currently, need ot look for places where memroy is NOT allocated as it should be. UPDATE #4: At this point, I believe everything irrespective to the main function works properly. Only problem right now is only coming from the main function. To debug, I will start testing each part of the main that I have now in a new main function to find the problem. UPDATE #4: Bugs fixed. Now need to implement while loops that cause the output to appear every 5 seconds for each output that'll be to user. UPDATE #5: Prog works properly, all the way up until it gets to the dice rolling stage. UPDATE #6: Prog works properly now. Need to implement func that causes the program to loop through each round. ALSO, need to write function calls that will reference the functions used from Jojo's code IN THIS file. At this point, focus will be going towards making the powerpoint. ALSO: Need to add member vars and funcs to class diagram thing so it can be used during presentation.
	// UPDATE #7: Found that the roll function isn't running in one of the for loops which explains why the scores default to 0. Need to figure out why this is going on. UPDATE #8: Found that the FOR LOOP ITSELF referenced in UPDATE #7 isn't running. I believe this may be due to its terminanting coniditon. Will investigate in next session.  UPDATE #9: Turns out the setScore function is causing an infinite loop. Need to figure out why. UPDATE #10: Turns out the sort function is causing the infinite loop. UPDATE #11: Problem FIXED. Now need to learn how to measure the average response times for the software. 


#include <iostream>
#include <cstdlib>
#include <ctime>		   
#include <unistd.h> //<-- required for usleep func. so uncommentn when all errors EXCEPT usleep ones are fixed. 
   // body of header files required to display data to outside user
  
   // end of body of header files required to display data to outside user
#define SWITCH1 0 //(cont here)

#define SWITCH2 0 //(cont here)
#define SWITCH3 0 //(cont here)
#define SWITCH4 0 //(cont here)
		  // NOTE: Not sure about number of switches required, need to ask team. 




class Dice {
	private:
		// Insert members here

	public:
		// insert public members here

		Dice(int newResult = 1): result(1) {	
	setResult(newResult);
	// call setters
  // Insert content for body of constructor here: 
		}
		// ~Dice() {} //<-- deconstructor to deallocate memory.  <-- not needed
		int result;
		int getResult(){return result;}
		void setResult(int newResult) {
                  result = newResult > 0 ? newResult : result;
		}
		void roll() {
			// Will consist of: 1) Calling rand function that obtains ranodm number via mod operator, and seeded random[For info, refer to local directory using grep and going to Learning C++ dir], 2) (cont here if applicable)
			printf("\n Callled Roll Function \n");
			// srand(time(0));
			result = (rand() % 6) + 1; //<-- returns a number between 1 and 6
			printf("Added result for dice. The result for this dice was: %d", (rand() % 6) + 1);
			// At this point, number is sent to hex display function that randomizes and then prints out the number. 
		}
};
class Player {
	private:


	public:
	Dice* allDices_;
		int* score; //<-- since this is subject to change when user decides to go round and after round. 
		bool isYatzeeStreak;
	        int* originalDiceOrder;
		int num_dices_;
		int num_of_diffs_two = 0;
		explicit Player(int startScore = 0, int num_dices = 5): num_dices_(5), score(nullptr) {
		  score = new int{startScore};
		  allDices_ = new Dice[num_dices_];
		  originalDiceOrder = new int[num_dices_];
}
		~Player() {
		    delete[] allDices_;//<-- [] used to delete ARRAY of dynamically allocated memory. 
		    delete score;
		    delete[] originalDiceOrder;
		} //<-- deconstructor to deallocate memory when needed
		int getScore(){return *score;}
		int getNum_dices(){return num_dices_;}
		bool getYatzeeStreak() {return isYatzeeStreak;}
		void sortDiceResults() {
			for(int i = 0; i < num_dices_;++i) {
				originalDiceOrder[i] = allDices_[i].getResult(); //<-- stores original order for user later. Particularly, so it can be used to display the dice results in the correct order. 
			   for(int j = 0; j < num_dices_ - i - 1;++i) {
				   // NOTE: Before swapping, cases for small straight, and large straight are established via bool values.  
				   num_of_diffs_two = allDices_[j].getResult() - allDices_[j+1].getResult() == -2 || allDices_[j].getResult() - allDices_[j+1].getResult() == 2 ? num_of_diffs_two : num_of_diffs_two + 1; //<-- line of code increments num of adjacent differences if the difference is two. 
				   if(allDices_[j].getResult() > allDices_[j+1].getResult()) {
				   Dice temp = allDices_[j];
				   allDices_[j] = allDices_[j+1];
				   allDices_[j+1] = temp;
				   }
			   }
			}
		}
		void setScore(int newScore) {
			printf("\n Starting Sorting the Dice....\n");
			if(newScore) {
*score = newScore > 0 ? newScore : *score;
			}
			sortDiceResults(); //<-- this sorts the results so the values can queried properly. 
			// return;
			/*
			 * Three of a Kind: If you have three dice showing the same number, score the total of all five dice. [This chance is voided if there are more than 3 distinct results]
Four of a Kind: If you have four dice showing the same number, score the total of all five dice. [This chance is voided if there are more than 2 distinct results]
Full House: If you have a trio and a pair, you score 25 points. 
Small Straight: If you have four consecutive numbers, you score 30 points. [This chance is voided IFF any TWO adjacent pairs have a difference of two]
Large Straight: If you have five consecutive numbers, you score 40 points. [This chance is voided IFF any adjacent pair has a difference of two]
Yahtzee: If you have five dice showing the same number, you score 50 points. [This chance is voided IFF more than one number appear in the dice results]
Chance: If you don't have any specific combinations for the above boxes, score the total of all five dice. 
Yahtzee Bonus: For each additional Yahtzee (after the first), you get a 100-point bonus. [This is voided if Yahtzee streak dies out]

^^ Game rules that need ot be implemented via case statements here. May require passing in a Dice* param since the values will be compared. ALSO IMPT: Need to find specifc traits that void the respective scoring cases. Which can be done by finding the complement of the sentence. 
*/

			// responsible for setting the results based on the scoring category. 
			// all modes are bijective to: {Yatzhee,4 of a kind, 3 of a kind, Large Straight, small straight, Full House}
			int num_same = 0, currNumComparator; //<-- currNumComparator refs the number that is checked for dupes which increments num_same for each dupe. 
			for(int i = 0; i < num_dices_;++i) {
				// Idea: 1) Obtain dice results for each user, 2) through each acquirement, check for distinctness with other results to figure out score category, 3) Return score using formula referenced by said category. IDEA #2: Thinking about having this be the body of the setScore function for Players such that score is already computed and this portion is only used for printing. Would make code cleaner. 
				// NOTE: To make this process easier, sorting the dice results beforehand is KEY. this will be a method that the player objects contain. 
				// After sorting, go through all results, in a nested for loop. 
				allDices_[i].getResult();
				// NOTE: Ditching use of case statements and using if-else pairs instead. 
				for(int j = 0; j < num_dices_ - 1;++j) {
					currNumComparator = allDices_[0].getResult() == allDices_[j].getResult() ? allDices_[0].getResult() : allDices_[j].getResult(); 
					num_same = currNumComparator == allDices_[j].getResult() ? num_same + 1 : num_same;
					// ^^ Code above keeps track of duplicates. 







			}
			switch(5 - num_same/*<-- refs the number of distinct results*/) {
				case 0:
					  // Possible combinations: 1) Chance, 2) (cont here if applicable)
					for(int i = 0; i < num_dices_;++i) {
					*score += allDices_[i].getResult();
					}
					  
					// "code to execute if expression == 0"
				break;
				case 1:
					  // Possible combinations: 1) Four of a Kind, 2) (cont here if applicable)
					for(int i = 0; i < num_dices_;++i) {
					*score += allDices_[i].getResult();
					}
					// "code to execute if expression == 1"
				break;
				case 2:
					  // Possible combinations: 1) Chance, 2) Full House (cont here if applicable)
					  *score = 25;
					// "code to execute if expression == 2"
				break;
				case 3:
					  // Possible combinations: 1) Three of a kind

					for(int i = 0; i < num_dices_;++i) {
					*score += allDices_[i].getResult();
					}
					// "code to execute if expression == 3"
				break;
				case 4:

					  // Possible combinations: 1) (cont here if applicable)

					// "code to execute if expression == 4"
				break;
				case 5:
					  // Possible combinations: 1) Yatzee (cont here if applicable)
				if(!isYatzeeStreak) {
				*score = 50;
				} else {
					// Adheres to cases where we have additional yatzee's. 
					*score += 50;
				}

					// "code to execute if expression == 5"
				break;
				default:
				if(num_of_diffs_two <= 1) {
				*score = 40; 

				} else {
					*score = 0;
					for(int i = 0; i < num_dices_;++i) {
					
					*score += allDices_[i].getResult();
					}

				}

				break;
				  
			  }
		       // allDices_->setResult(); <-- PN: Not sure why this needs to be here rn. 
		  }
		}
		void setNum_dices(int newDiceNum) {
		  num_dices_ = newDiceNum > 0 ? newDiceNum : num_dices_;
		  if(allDices_) {
		  delete[] allDices_;
		  allDices_ = new Dice[num_dices_];

		  } else {
		  allDices_ = new Dice[num_dices_];
		  }
		  // Designed func such that it wipes previous dice completely if setter is called after it has been called once before during program. 
		}


};
class Game {
	private:
		// Insert members here
		int rounds;
		int stage;
		int num_players_;
		int num_dice_;
	public:
		// public members here as well as getters and setters

		Player* all_players_;
		Game(int newRounds = 1, int currStage = 1, int num_dice = 1, int num_players = 1) : rounds(1), num_dice_(1), num_players_(1)  {
	  all_players_ = new Player[num_players_]; 
	  setNum_players(num_players);
	  setNum_dices(num_dice);
	  setRounds(newRounds);

}
		~Game();
		int getRounds(){return rounds;}
		int getStage(){return stage;}
		int getNum_players(){return num_players_;}
		int getNum_dices() {return num_dice_;};
		void setRounds(int newRoundNum) {
                  rounds = newRoundNum > 0 ? newRoundNum : rounds;
		}
		void setStage(int newStage){
		  stage = newStage > 0 ? newStage : stage;
		}
		void setNum_players(int newNumPlayers) {
		  num_players_ = newNumPlayers > 0 ? newNumPlayers : num_players_;
		}
		void setNum_dices(int newDiceCount) {
		  num_dice_ = newDiceCount > 0 ? newDiceCount : num_dice_;
		}
		void reset(); //<-- responsible for resetting game variables and decrementing the number of rounds. If num rounds == 0, then this should execute the endOfGame function
		void setPlayerScore(int index, int score) {
			(all_players_ + index)->setScore((all_players_ + index) == nullptr ? (all_players_ + index)->getScore() : score);
				// PN: Need to format other setters simialr to this. 
		}
};
Game::~Game() {
	delete[] all_players_;
	// deallocates memory when needed

}




void setup() {
   // "set up the LCD's numebr of cols and rows: 
   // "Print a message to the LCD."
	//^^ uncomment code above when c++ version of this works properly.[c++ version works decently. Merely logic errors at this point. lcd stuff also implemented as well. Uncommet this, when testing on arduino. 
}
int main() {
	// NOTE: Remember that the main func will need a while loop that awaits input to to external input accordingly. 
	// Version 1 implementation of program
	// Desc: v1) User decides to turn on system. System responds by running it initializer function which is responsible for setting up the environment by adhering to the steps that belong to tuple K. After setting up environment, system lets the user know that it is ready for them to execute the first step a that belongs to tuple J. The steps in tuple J will be used to navigate user to start their first game. NOTE: Before we continue, tuple J = (Select the number of rounds you want, Select the number of dice you want to use to obtain score, Choose the scoring category [cont here bywriting the steps that the system needs the user to execute to navigate user from 'initial state' to playing the game itself],), and tuple K = ( Press switch d \in tuple O to begin the dice roll(s)[each roll will happen sequentially for ease of use], system 'rolls' the dice and returns the result for each dice rolled, system outputs the results for each dice in an array, each result is output with a delay of g to add an anxious effect to playing the game.
	Game onlyGame;
	 printf("Hello World! Welcome To Yatchzee!");
		char inp0[100];
                bool stage0 = false; 
		  printf("When you are ready, press the switch to start the game. For computer version, press a to start the switch");
		scanf("%s", inp0);
		usleep(2e6);

		
		// PN: Could put delay here to prevent loop from running constantly to give user time to start the game. This can be a conditional delay via an if statement to support users that respond to instructions quickly. 
	while(true) {
	// Here is body that will be able to react to user input and make decisions based on particular inputs. This body will consist of many function calls, and very few control statements. First version in regards to user input consist of at least 2 switches that allow user to start the game and allow user to toggle between number of rounds. 
	if(!SWITCH1) {
         // This means game was started which means Game object must be instantiated. 
		printf("Starting Game \n");
		
		// PN: Could put delay here to prevent loop from running constantly to give user time to start the game. This can be a conditional delay via an if statement to support users that respond to instructions quickly. 
		// At this point, steps that lie in tuple J are executed by user via request by the system: 

		printf("Select the number of rounds you want to play \n");
		// PN: Here, this number can be incremented using a button succeeding SWITCH1 that rotates back to 1 when the limit is established
		// body of reacting to user's request
		int response0;
		scanf("%d", &response0);
		onlyGame.setRounds(response0);
		printf("You are about to play %d rounds \n", response0);
		  // will consist of calling setter of member var of Game obj at the LEAST
		// end of body of reacting to user's request
		//
		// Insert delay if statement here
		if(true) {
			usleep(2e6); //<-- since this takes in \mu s. 

		}
		printf("Select the number of dice | enter number of dice if using c++ program \n");
		// Insert delay if statement here
		if(true) {
			usleep(2e6); //<-- since this takes in \mu s. 

		}
		// PN: Here, this number can be incremented using a button succeeding SWITCH1 that rotates back to 1 when the limit is established
		int response1;
		if(SWITCH2) {
		// body of reacting to user's request
		  // will consist of calling setter of member var of Game obj at the LEAST
		scanf("%d", &response1);
		onlyGame.setNum_dices(response1);//<-- this func will also allocate memory of that size as well, as well as deleting the previous allocated memory. 
		// end of body of reacting to user's request
		}//
		// Insert delay if statement here
		if(true) {
			usleep(2e6); //<-- since this takes in \mu s. 

		}
		// NOTE: AT this point of program, user is ready to interact with the program. The dice intreaction will go as follows: 1) For loop usde to iterate through each dice roll which calls roll func and stores the dice's result, 
		printf("Are you ready to roll your <<num>> dice? | Press switch n if on microcontroller & Press 1 if on computer  \n"); 

			int response3;
			scanf("%d", &response3);
			if(false/*<-- replace with switch */ || response3/*<-- since this will always be a nonzero value*/) {
		for(int i = 0; i < onlyGame.getRounds();++i) {
			printf("Completing Round %d \n", i);
			// Insert delay if statement here
			if(true) {
				usleep(2e6); //<-- since this takes in \mu s. 

			}
			printf("We are now about to roll the dice!");

				for(int i = 0; i < onlyGame.getNum_players();++i) {
				printf("Going through player %d \n",i);
				  for(int j = 0; j < (onlyGame.all_players_ + i)->getNum_dices();++j) {
				  printf("READY TO ROLLLLL UP \n");
					// Rolling each die and also stores the results of die to each player
					(onlyGame.all_players_ + i)->allDices_[j].roll();
					(onlyGame.all_players_ + i)->setScore(0); //<-- executes the scoring conditions from the yathzee game. 
					printf("%d \n",(onlyGame.all_players_ + i)->getScore());

				  }
				  printf("Finished going through player %d \n", i);
				}
				// At this point, all dices have been rolled and results must be evaluated according to the score category. 
				// At this point, scores are ready to be printed out. 

				printf("Here are the score results! \n");
				for(int i = 0;i < onlyGame.getNum_players();++i) {

					printf("PLAYER %d | SCORE: %d \n" ,i,(onlyGame.all_players_ + i)->getScore());
				}
				printf("Would you like to play the next round? Enter 1 for yes | enter 0 for no \n");
		if(true) {
			usleep(5e6); //<-- since this takes in \mu s. aka us

		}
		int response5;
		scanf("%d",&response5);
				
				if(response5) {
					// loops resets back to beginning
				} else {
					printf("Exiting round loop\n");
					break;
					//exit(0);
				}
				// At this point, loop resets back to beginning.

			}
				printf("Would you like to play again? Enter 1 for yes | enter 0 for no \n");
		int response6;
		scanf("%d",&response6);
		if(response6) {
		// loops resets back to beginning
		} else {
		  printf("Exiting game \n");
		  exit(0);
		}

	  }

	}
     }



	// end of Version 1 implementation of program

  return 0;
}

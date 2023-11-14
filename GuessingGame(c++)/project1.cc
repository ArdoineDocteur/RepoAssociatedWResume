/* Objective: Create a Guessing Game, instructions located in Guessing Game.txt file. Due 10/5/23 @ 11:59PM[Submit to Mr. Leonard's Email]
Subobjectives:
- 1) Create a user environment that directly tells the user the req instructions.(complete)
- 2) Use an unique pointer array to output the user's entries.(complete)
Ideas:
- Will make unique pointer array of type int.
- Initial plan is to write everything in main method. After the logic is implemented correctly, I will split the code
into files, and WILL create a makefile for running the program as well.
- Make sure to explain the coding logic effectively using a decent amount of comments.
- Going to make a simple makefile for the project as well.
- IMPT: May have to consider a case where user inputs another data type other than a number. Will use a try and catch block for that.
Report Tab:
- [9/29/23 @ 1:27AM]Basically made a basic interface, and made the fundamental part of the guessing game. Now, I need to learn how the unique pointer works and implement it
in the program.
- [9/29/23 @ 5:48PM] Finished implementing the logic in my program. Now I need to figure out how I want to refactor my code to make it as efficient as possible. Also, need to create
header file so I can put the function declaration inside of, as well as create a file that contains the function as well. Also, thought about making my program able to accept args from
the terminal.
- [10/1/23 @ 11:23PM] Code is finished, refactoring code is nearly complete. Just putting final touches, submitting code @ the end of 10/3/23.
- [10/2/23 @ 8:58PM] Double-checking code, created makefile, need to test on linux terminal on linux labs computers. ALso, transported proj to linux lab computer, currently working on making the makefile
work.
Approaches to take when presenting this code to someone:
-Could start off by talking about the purpose of the project. 
- Also could be useful to talk about the thought process when doing the project, and then cross-referencing the logic with the actual code
used in the program.
-Could hone in on the easiest things that were easy to complete, and then transition smoothly into increasingly harder things I had to implement in my code.
- Notes learned from this experience lie in the "Notes from Code Review".txt file.
*/
#include "HelperFunctions.h"
#include <iostream>
const int kMaxInputs = 10;
int main(int argv, char* argc[]) {
  std::srand(time(0));// Ensures that rand() generates a random number each time the executable in executed.
  int rand_num = (std::rand() % 100) + 1;// Used the rand function and the mod operator to generate numbers between 1-100.
  int user_input_counter = 0;
  int user_attempt = 0;
  std::unique_ptr input_storage=std::make_unique<int[]>(kMaxInputs);// Here, I use the unique_ptr object to dynamically allocate an array on the heap. 
  std::cout << "Welcome to the Number Guesser Program!" << std::endl;
  while ( user_attempt != rand_num) { 
    std::cout << "Enter guess #" << (user_input_counter)+1 << ": ";
    std::cin >> user_attempt;// Used to derive input from user through terminal.
    if ( user_attempt > 0 && user_attempt <= 100) {// This if-else statement validates or invalidates user attempt. 
    input_storage[user_input_counter] = user_attempt;// Indexed array of instance of unique_ptr object and added each attempt to the array for future display.
    ++user_input_counter;// Tracks the attempts
    std::cout << ( user_attempt < rand_num ? "Guessed too low" : "Guessed too high") << std::endl;// Used a ternary operator
    
    } else if (user_attempt < 0 || user_attempt > 100) {
      std::cout << "Invalid Input. Enter a number between 1 and 100." << std::endl;
    
    }
     else {
      std::cout << "Invalid Input. Entered a value other than a number. Exiting program." << std::endl;
      break; 
    }
    if ( user_input_counter == kMaxInputs ) {
        std::cout << "Ran out of attempts! \n";
        std::cout << "The randomly generated number was: " << "[" << rand_num << "]. ";
        std::cout << "Your previous attempts were the following: \n";
        PrintValsInArray(input_storage, user_input_counter);// Function call for outputting user's attempts.
    }
    else if ( user_attempt == rand_num ) { 
        std::cout << "Great Job! Your guess was correct! Your previous attempts lie as follows: \n";
        PrintValsInArray(input_storage, user_input_counter);
    }
  } 
    return 0;
}

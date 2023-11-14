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

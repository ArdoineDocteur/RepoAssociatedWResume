#include "HelperFunctions.h"
#include <iostream>
#include <ctime>// Used this library to access the time function
#include <cstdlib>// This c++ library is used to access the rand function to generate the random number.
void PrintValsInArray(std::unique_ptr<int[]>& a, int size) {// Passed the unique_ptr instance of type int[] via reference
  for( int i = 0; i < size ; ++i )
    std::cout << a[i] << std::endl;
}
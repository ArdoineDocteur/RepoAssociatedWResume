/* This will contain my function declarations. */
#ifndef _HELPERFUNCTIONS_H
#define _HELPERFUNCTIONS_H
#include <memory>// Used to access the unique_ptr object
void PrintValsInArray(std::unique_ptr<int[]>& array, int size);
#endif
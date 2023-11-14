HelperFunctions.o : HelperFunctions.cc HelperFunctions.h
		g++ -c $< -std=c++17 -Wall -I .
project1 : project1.cc HelperFunctions.o
		g++ $^ -std=c++17 -Wall -o $@
		Executable Created! with the name $@
clean:
		rm HelperFunctions.o project1.o
#Objective: This project will be used to carry out project idea 0 which is creating a terminal system 
# Create a Terminal System for modifying the appearance of a HTML file. 
#NOTE: This will heavily involve modifying css code that lies on the HTML file or in the HTML style tag. 
# Plan: 1) Going to create the basis of the terminal, and the first command I will create will be the 'exit' command which will be used to exit the terminal(complete). 2) Next, based on the commands I have written on 
# by blueprint thus far, I will create the objects for these commands(complete). 3) Since I have created the commands, the current goal is to implement error handling and the regex required for a valuable user input(1/2). 4) After 
# doing that, then I can implement the try and catch block so I can read in the submitted files into the terminal.  5) Make sure everything works and test it out. 6) Once everything works as intended, upload this version to github, and 
# then brainstorm more features and commandlets to add to this terminal. Whilst completing this, adhere to your blueprint in green folder. Also, once you are near completion you need to start writing the documentation for using this terminal 
# system. 
# Ideas:
# - To create the clear command functionality, I can create a function that prints certain output to a string, and then, when the user enters clear or cls, the string is reset to "" which empties the terminal.
# - When the user enters a css statement w/o specifying -modify, you could say sum along the lines of: "You forgot -modify! Try it again".
# Notes from this experience: 
#-To implement REGEX expressions in your python programs, it requires the import of python's re module. This module contains a compile("<<REGEX Exp>>") function that is used to facilitate a regex pattern for matching 
# strings in your programs. The object that the compile method returns contains a match("<<String to compare to REGEX Expression>>") which returns a boolean value based on if the string matches the regex or doesn't match 
# the regex. 
#-As learned from python, python has try and catch blocks which can be used when reading in files into your programs. Refer to practiceS5 in Relearning Python Directory for more information.
# - Utilizing the substring operator, : , in python is useful in cases where you are looking for certain characters in a file BUT you want to access PARTICULAR characters within that string. This helped me with accessing the statements 
# for the css code and helped me exclude the curly braces.
# - To write files from your programs, you can use the <<open(filepath)>>.write(<<string value>>,'<<x or w?>>'). Refer to code below for more information.
# - The print function, in python[and possibly other langs], have another paramter which takes in a file object which allows you to write items to the file. Refer to code in the 
# cmds.py file to see it in action.
#Current Regex exps that I plan on using: 1) Theoretical REGEX for valid form of arguments -> \w+(\s-\w{1,3})*. 2) Theoretical REGEX for parsing through CSS Code 
# on html files -> {(\w+[-]*\w*\s)+:[(\d+px) | (\w+)];\n*}.
# Report Tab: 
# -[9/9/23] Implemented some new commands, fixed my REGEX EXP issue with user entries, however file reading is messed up. After the file reading is fixed, I will implement the neccessary code for modifying css code in html OR .css files.
# -[9/10/23] Fixed the file reading, made the file reading exclusive to .css and .html files only, and curly working on making the regex work for the css code, and then splitting it by ';'s, and then saving it to an array/python list for future modifications.
# -[9/16/23] Improved REGEX Exp, works decently, just need to figure out how to index the values properly and exclude the curly braces in the css code, thought about the use of multi-dim arrays since there could be cases where there are multiple css classes. Began implementing 
# a basic component of error handling. Will need to improve error handling to adhere to cases where users input commands that DO NOT exist in the terminal system. [9/17/23] @ 3:21PM: Still working on the previous tasks, made a little bit of progress. I believe the 
# re module documentation may be helpful in solving my regex issue. Also, may need to create another regex expression for accessing css code within curly braces[WHILST EXCLUDING THE CURLY BRACES].
# -***(Very impt, sets tone for rest of project)[10/1/23] Fixed REGEX Expression issue. Used the substring idea to solve my problem. Also, implemented function that returns the index where the curly braces are. Going forward, from this point, I plan to create a new command for modifying css statements. My command 
# will have the ability to access a certain statement in the css class, and either modify it or change it entirely. For the modification part, may be useful to have a feature that splits the property-value pair and gives user the ability to 
# modify the css property value or pair w/o writing an ENTIRELY different function. 
# [10/1/23 @ 1:57PM] Began implementing my css modification ideas. Finished the ability to access css statements from the passed in file via command line. Next step is to address the modification feature for css statements via the command line.
# [10/7/23 @ 1:08AM] Finsihed creating the modification feature for css statements via command line. Currently in the process of figuring out how to dynamically create a file that contains the modified content by the user in terminal. From this 
# point, I may implement a way to access certain css classes via indexing. HOwever, I will start creating the documentation for the commands for my terminal as well. Also, need to split code into different files for easier comprehension and access.
# [10/8/23 @ 10:32PM] Solved problem for writing in files. Files output as intended, need to add feature where user is able to name their files, might needa give user option to override their file of choice. When printing, having problem where items are printed with uneccessary whitespace, need to figure out how to remove that
# excess whitespace. Pondered on the idea to faciliate the abiilty for users to create their own scripts for my terminal so they can do certain things[Not relevant but just a thought]. Going forward, follow objective from previous report, and begin creating a list of bugs in program that need to be addressed in future. 
# [10/14/23 @ 3:46PM] Added feature that allows user to name their own files. Put a comment where it would be a great place to inquire if user wants to override previous file. Began listing bugs in program that need to be fixed. 
# going forward, will be wise to do more bug searching, begin splitting code into modules, and implement the idea involving allowing users to access different css classes via 2-d lists aka arrays. Also, here I began refactoring and splitting my code into multiple files.
# [11/4/23 @ 5:00PM] FINALLY GOT THE PRINTING TO WORK! In printer, figured out a way to allow user to create their own ids for their css class creations. Still need to work on giving users the ability to access multiple css classes on a file using a 2-d array. Also, need to think of most of the things that users can do 
# wrong to create certain exceptions aka custom error handling for. Lastly, I need to finish writing documentation for this project via the docs.txt document. In addition, I need to give user an option to add css classes to existing css files which I believe can be acheived once I implement my accessing multiple css classes idea 
# using 2-d arrays[this may also involve the use of regex as well]. IMPT: One idea that came quickly was using the amount of times the } bracket appears in a css file to determine the number of css classes in a css file.
# [11/5/23 @ 1:30PM] Began implementing my 2-d array idea for accessing multiple css classes. Also, nearly finished writing the documentation for the project in my .txt file.
# [11/11/23 @ 2:23AM] Implemented my 2-d array idea for accessing multiple css classes. Deployment went decent, however there are several issues that need to be fixed. Some of these issues include: 1) The curly brace needs to be omitted when a certain css class is output via the cssManip command which can be done
# using the curlybracefinder helper function that I created(complete, modified the helper function), 2) The amount of classes counted on a file is inaccurate by one(could involve how im splitting data via semicolons?), 3) There is a compiler error when attempting to output the modded file onto a new file entirely(complete, had to ensure that the 2-d array member var was returned). Going forward, at least for the next session, take the time to find all of the bugs that need to be
# fixed after your implementation. In addition, continue brainstorming things that users may do to create exceptions for them. After that, take the time to finish documentation for your commands.   @ 3:10PM: Successfully finished implementing my 2-d array idea and it worked. @ This point, I need to finsih debugging my code and 
# Work on completing my error handling for my program. In addition, I need to finish writing my documentation for my code.
# [11/12/23 @ 12:54AM] Created some exceptions functions for my custom exception object. Fixed issue involving the amount of classes counted on a file's inaccuracy. Still need to work on adjusting everything else, and need to finish writing documentation. @ 11/13/23 @ 1:09AM, continued working on error handling.
# [11/13/23 @ 11:28PM] Worked on placing my exceptions in the code that displays the terminal. My next goal is completing documentation, and then ironing out the final discrepencies, and then I will be finished. The error handling is nearly complete.
# [11/14/23 @ 8:35PM] Finished writing documentation. Currently in the process of ironing out the final discrepencies. IMPT: Once time permits, may have one of my friends test out my program to ensure that it works as 
# intended, as well as ensure that my documentation is written effectively. Also, after this is finished, prevent the program from outputting semicolons following back braces when writing to the desired file. 
# [11/16/23 @ 11:21PM] PROGRAM IS COMPLETE AND READY FOR PUSH TO GITHUB! Implemented functionality for preventing the program from outputting semicolons following back braces. Still in the process of ironing out the discrepencies. However, next time you open this, upload this project
# github, and then start working on your outline for your presentation.
# Debugging Problems that need to be addressed: 
# - For some reason, if their are space-separated values in a css statement it reads that statement and then stops reading the others. Need to figure out why.
# - Need to implement an exception when user inputs a filepath that doesn't exist, and raise it. Could do inside of the curr class not sure though. IMPT: This is implicitly handled when user does the curr -sub command, but I need to specify it nevertheless for the best UI experience.
# - Also, need to see how to access keyboard events in python so that way my program doesn't crash when user presses enter key on accident when there's an empty shell prompt(complete, however I do still need to look up how to access keyboard events in python).
import cmds as cm, secmain #<-- Example of importing files in python. In contrast to c++, importing files don't req the file extension .py . We simply put the identifier and that is it.
print("""Welcome to the html coloring book! 
          To get started, submit the filepath to your html file 
          that you would like to modify!
          """)      
def main():
    curUser=cm.curr()
    while(True):
        uI: str=input("dCS-> ")#<-- At this point, my goal is to implement the REGEX required to faciliate terminal commands which is what I wrote on the blueprint.
        if(secmain.userInpParser(uI,curUser)==0):
            break
main()

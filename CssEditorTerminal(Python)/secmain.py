import cmds as cm, re, exceptions 
correctUI=re.compile("\w+(\s-\w{1,3})*")#<-- Regex exp responsible for ensuring that the user inputs data in a argument space-delimited format.
reforCSS=re.compile("\.\w+\n*{\s*(\w+(-\w+)*)+:\s*(\D+|\d+px)+;\n*}")#<-- Regex exp responsible for ensuring css code is available in the css file.
def IsCmd(inp: str) -> bool:
    a: bool=False
    validCmdlets=["curr","exit","cssManip"]
    for i in validCmdlets:
        if(inp.split(" ")[0] == i):
          return True
    return False
def allCmds():
    return "curr\nexit\ncssManip"
def cssIDFinder(filePath: str):
    container = []
    counter = 0
    info = filePath
    if(info.__contains__(".") and info.__contains__("{")):
        for i in info:
                # Two conditionals responsible for providing the indexes for accessing the css class id.
                if(i == "."):
                    container.append(counter+1)
                elif(i == "{"):
                    container.append(counter-1)
                counter+=1
    return container

def curlyBraceFinder(filePath: str, isFP = True) -> list:
    container=[] #<-- Used to contain the index where the first curly brace is and the last curly brace is.
    counter = 0
    if(isFP == True):#<-- Boolean used for allowing regular string sequences AND files themselves being read in which is very convienient.
        try:
        # Inserting file reader here.
            file=open(filePath)
            info=file.read()
            if(info.__contains__("{") and info.__contains__("}")):
                print("Finding curly Braces")
                for i in info:
                    if(i == '{'):
                        container.append(counter+1) #<-- +1 makes sure the first curly brace isn't included.
                    elif(i == '}'):
                        container.append(counter)
                    counter+=1
        except FileNotFoundError:
            print("File Doesn't Exist!")
    elif(isFP == False):
        frontBrace = False
        backBrace = False
        for i in range(len(filePath)):
            if(filePath[i] == '{'):
                        frontBrace = True
                        container.append(counter+1)
            elif(filePath[i] == '}'):
                    backBrace = True
                    container.append(counter)
            counter+=1
        container.append(0) if frontBrace == False else container
        container.append(len(filePath)-1) if backBrace == False else container
    print("No css code found!") if len(container) == 1 else print("")#<-- Uses the size of the counter to see if there is proper css code in css file. If there is, the length of the container should ALWAYS be at least 2.
    return container#<-- Returns list with two whole numbers resp for providing the indexes where each text start whilst excluding the curly braces.    
def userInpParser(uI: str="",dyn=cm.curr(), dyn1=cm.cssManip()):
    #The purpose of this method is for parsing through user input and running the neccessary commands as requested.
    if (uI == ""):#<-- If user uses enter key w/o typing, the shell won't crash.
        return  
    successfulcmd = True
    if(correctUI.match(uI)!=None):
        try:
            if((uI.__contains__(" ")==False) and uI.__eq__("exit")==False):
                raise exceptions.IncorrectUserInputException(f"Incorrect Formatting. Remember that arguments are space-delimited. Some commands to choose from are: \n{allCmds()}")
            elif(IsCmd(uI)==False):
                raise exceptions.IncorrectUserInputException(f""" Cmdlet: {uI} does not exist. To try again, input another command. A list of existent commands are below:
{allCmds()}                
""")
            elif(IsCmd(uI)==True):
                uIsplit=uI.split(" ")#<-- Using this to access the arguments as requested.
        except exceptions.IncorrectUserInputException as error:#<-- Implemented basic error handling, will improve in future.
            print(error)
            return
        cmdlets={"cls": 0,"exit": 0, "curr": dyn, "cssManip": dyn1}
        if(uIsplit[0]=="exit"):
        #Here, I will run the exit object which will exit the terminal.
            return 0
        try:
            if(uIsplit[1] == ""):
                raise exceptions.IncorrectUserInputException(exceptions.missingArg(1))
            elif(uIsplit[1].__contains__("-") == False):
                raise exceptions.IncorrectUserInputException(exceptions.missingDash(uIsplit[1]))
        except exceptions.IncorrectUserInputException as error:
            print(error)
            return
            
        if(uIsplit[1]=="-h"):
            cmdlets.get(uIsplit[0]).HELP()

        elif(uIsplit[0]=="curr" and uIsplit[1]=="-mod"):
            try:
                if(uIsplit[2] == "" or uIsplit[2].__contains__(".") == False):
                    successfulcmd = False
                    if(uIsplit[2] == ""):
                        raise exceptions.IncorrectUserInputException(exceptions.missingArg(2))
                    elif(uIsplit[2].__contains__(".") == False):
                        raise exceptions.IncorrectUserInputException("Invalid input. Please enter a file with a file extension.")
                cmdlets.get(uIsplit[0]).setFilePath(uIsplit[2])#<-- This will be used to set the file path.

            except exceptions.IncorrectUserInputException as error:
                print(error)
                return
        elif(uIsplit[0]=="curr" and uIsplit[1]=="-p"):
            print(cmdlets.get(uIsplit[0]).getFilePath());    
        
        elif(uIsplit[0]=="curr" and uIsplit[1]=="-sub"):
            try:
                fileTwoRead=cmdlets.get(uIsplit[0]).getFilePath()
                if(fileTwoRead == "Default"):
                    raise exceptions.IncorrectUserInputException("Default value selected. Modify filepath using the curr -mod <<filepath>>")
            except exceptions.IncorrectUserInputException as error:
                print(error)
                return
            if(fileTwoRead.split('.')[1]=="css"):
                try:
                    filepath=cmdlets.get(uIsplit[0]).getFilePath()
                    file=open(filepath)
                    content=file.read()
                    allCSSClasses: str = str(content).split("}")#<-- This will be an array that holds all of the css classes inside of a file.
                    dyn1.setNumOfCSS(len(allCSSClasses))#<-- Responsible for ensuring that there is enough space to hold ALL of the css classes in the file given.
                    allCSSClasses: str = str(content).split("}")[:dyn1.numOfCSS-1]#<-- This will be an array that holds all of the css classes inside of a file.
                    # After establishing this, I will modify the body of the if statement slightly.
                    #Here I split the .css file into matches and then split the matches using ';'.
                    test2dstey: list=[]
                    if(reforCSS.match(content)!=None):
                        print("Doing the matches...")
                        for i in range(len(allCSSClasses)):
                            test2dstey.append(allCSSClasses[i][curlyBraceFinder(allCSSClasses[i], False)[0]:curlyBraceFinder(allCSSClasses[i], False)[1]].split(";"))#<-- Stores the css statements in each class.
                            dyn1.nameStore.append(allCSSClasses[i][cssIDFinder(allCSSClasses[i])[0]:cssIDFinder(allCSSClasses[i])[1]])#<-- Stores the original css identifiers.
                        cmdlets.get("cssManip").setArrayOfInfo(test2dstey)#<-- Gives user the ability to modify ALL the css classes and their respective statements in the file they passed in.
                        for i in range(len(test2dstey)):#<-- Resp for printing out each css class separately.
                            for k in range(len(test2dstey[i])):
                                print(test2dstey[i][k])
                                print("\n-----------")
                    print(content)
                except FileNotFoundError:
                    print("File Does not Exist! Pass in another filepath as an argument.")
                    return
                file.close()
            else:
                print("Incorrect file format. Only files with .css extensions are permissible.")
                return;    
        elif(uIsplit[0]=="cssManip" and uIsplit[1]=="-ret"):
                if(uIsplit[2] == ""):
                    successfulcmd = False
                    try:
                        raise exceptions.IncorrectUserInputException(exceptions.missingArg(2))
                    except exceptions.IncorrectUserInputException as error:
                        print(error)
                        return
                print("start")
                classSelect=int(input(f"Pass in the css class number that you want to edit ranged from 0 to {cmdlets.get('cssManip').getNumOfCSS()-1}: "))
                #Here, I will call the function responsible for returning the css statement @ a particular index.
                if(len(uIsplit)>=4 and (int(uIsplit[2])>=0 and int(uIsplit[2]) < len(cmdlets.get("cssManip").getArrayOfInfo(False,False,classSelect)))):
                    # Here, I will allow user to modify a statement @ the index given.
                    if(uIsplit[3] == "-modify" and len(uIsplit[4]) != 0):
                        print(cmdlets.get("cssManip").modifyStatement(int(uIsplit[2]), uIsplit[4], True,classSelect))
                elif((int(uIsplit[2])>=0 and int(uIsplit[2]) < len(cmdlets.get("cssManip").getArrayOfInfo(False,False,classSelect))) and len(uIsplit[2]) != 0):
                    print(cmdlets.get("cssManip").getArrayOfInfo(False,False,classSelect)[int(uIsplit[2])])
                elif(int(uIsplit[2]) >= len(cmdlets.get("cssManip").getArrayOfInfo(False, False, classSelect))):
                    successfulcmd = False
                    try:
                        raise exceptions.IncorrectUserInputException(exceptions.outOfIndex(int(uIsplit[2]),len(cmdlets.get("cssManip").getArrayOfInfo(False, False, classSelect))))
                        # Line above is responsible for telling the user that the index they requested to see was out of bounds of the css statements of the css class they chose from the css file.
                    except exceptions.IncorrectUserInputException as error:
                        print(error)    
                else:
                    print("Incorrect format")
                    return
        elif(uIsplit[0] == "cssManip" and uIsplit[1]=="-p"):
            classSelect=int(input(f"Pass in the css class number that you want to edit ranged from 0 to {cmdlets.get('cssManip').getNumOfCSS()-1}: "))
            cmdlets.get("cssManip").getArrayOfInfo(True, False, classSelect)
        elif(uIsplit[0] == "cssManip" and uIsplit[1] == "-sub"):
            print("Beginning process of uploading copy of file with modified css code")
            userResp=int(input("Are you okay with this? 1) Yes 2) No: "))
            if(userResp == 1):
                print("Continuing process")
                fileName: str = input("Enter your desired file name for this entry:[NOTE: You don't have to insert a file extension for your css file!] ")
                ent = 0; arrOfNames: str = dyn1.nameStore#<-- 
                nameChange: int = int(input("Would you like to change the names of your css class ids? 1) Yes 2) No: "))
                if(nameChange == 1):

                    while( ent < (dyn1.numOfCSS-1)):#<-- -1 is there to compensate for inaccuracy in amt of css classes on a file.
                        cssClassId: str = input(f"Great! Now enter the name for your css class #{ent}: ")
                        arrOfNames[ent] = cssClassId
                        ent+=1
                elif(nameChange == 2):#<-- If this is the case, the original names are not modified.
                    print("Request Granted!")
                #Below I will implement the file writer:
                try: 
                    filepath=f"./{fileName}.css"#<-- May cause an error if user enters something that doesn't make sense.
                    file=open(filepath, "w")
                    cmdlets.get("cssManip").outputModdedFile(arrOfNames, file)
                except FileNotFoundError:
                    print("File Does not Exist!")
                file.close()
            elif(userResp == 2):
                print("Exiting process")
                return
        print("Command Successful.") if successfulcmd == True else print("Command Unsuccessful")                
    else:
        print("Command unsuccessful")

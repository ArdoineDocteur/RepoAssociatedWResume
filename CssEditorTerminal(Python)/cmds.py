# THis will be a module-isk file that contains the commands for my terminal program.
import exceptions as exc
class curr:
    def __init__(self):
        self.fP: str="Default"
        # self.fileContent#<-- Eventually, will use this to access the content of the file directly.
    def getFilePath(self):
        return self.fP
    def setFilePath(self, newFP):
        #Needa have if statement to ensure that filepath exists
        self.fP=newFP
    def setContent() -> str:
        print("File Content")
    def HELP():
        return """ :HELP:
    -This Commandlet is responsible for outputting the filepath to the html file that is being modified.
    """
class cssManip:
    count = 0
    def __init__(self, numofclasses = 1):
        self.currFile="Empty"
        self.arrayOfInfo=[[]]# <-- Changing Identifier later on.
        self.nameStore = []#<-- Stores the css ids from the read in file from the curr command.
        k = 0
        while(k < numofclasses):
            self.arrayOfInfo[k].append([])#<-- This is responsible for adding an array for each css class in the file that was submitted.
            k+=1
        self.numOfCSS = len(self.arrayOfInfo)#<-- Contains the number of css classes on a css file.
    def setNumOfCSS(self,num: int):
        self.numOfCSS = num if num > self.numOfCSS else self.numOfCSS
        if(num > self.numOfCSS):
            for i in range(self.numOfCSS,num):
                for j in len(self.arrayOfInfo[i]):
                    self.arrayOfInfo[j]=list()#<-- Adds spaces for the css classes on a file.
        else:
            return#<-- this is here to prevent uneccessary copies, and to prevent decreasing the accessible css classes on a css file. 
    def getNumOfCSS(self):
        return self.numOfCSS
    def getCurrFile(self):
        return self.currFile
    def setCurrFile(self, newCurrFile):
        #Needa have an if statement to ensure that currFile exists
        self.currFile=newCurrFile
    #@ This point, I will create methods responsible for printing the contents of the currFile, modifying the contents of the currFile, and accessing certain css statements in the curr file.
    def outputCurrFile(self) -> None:
        try:
            file=open(self.currFile)
            content=file.read().split("\n")
            for i in content:
                print(i)
        except FileNotFoundError:
            print("Filepath doesn't exist!")
            return 
    def getArrayOfInfo(self, output: bool, full = False, cssClassNum: int = 0) -> list:
        try:
            if(cssClassNum < 0 or cssClassNum >= len(self.arrayOfInfo)):
                raise exc.IncorrectUserInputException(exc.outOfIndex(cssClassNum, len(self.arrayOfInfo))) 
        except exc.IncorrectUserInputException as error:
            print(error)
            return
        if(output == True):
            for i in range(len(self.arrayOfInfo[cssClassNum])):#<-- Resp for acccessing first class my default or whatever user requests.
                print(f"|------CSS Class #{cssClassNum}: -----|\n") if i == 0 else print("")
                print(self.arrayOfInfo[cssClassNum][i])
        return self.arrayOfInfo[cssClassNum if full == False and (cssClassNum >=0 and cssClassNum < self.numOfCSS) else 0] if full == False else self.arrayOfInfo#<-- Returns the ENTIRE array if full is True. This is done for outputting the modded file properly in last function below.
    def setArrayOfInfo(self, newArr: list):
        self.arrayOfInfo=newArr
        print(self.arrayOfInfo)
    def modifyStatement(self, index, replacement_css_statement: str, retrieve: bool=False, classNum = 0):
        if(replacement_css_statement.__contains__(":") == False):
            print("Invalid Input. Follow directions below. Press q to exit prompts.")
            cssProp = input("Enter your css property: ")
            if(cssProp == "q"):
                return 
            cssVal = input("Great, now enter your css value for your selected property: ")
            print("css property-value pair replaced")
            replacement_css_statement = f"{cssProp} : {cssVal}"
        # searcher=self.arrayOfInfo
        searcher = self.arrayOfInfo[classNum]#<-- Self-explanatory.
        searcher[index]=replacement_css_statement
        if(retrieve == True):
            return searcher[index]
    def outputModdedFile(self, idCC: list, s):
        # idCC is used for user to name css class in their css file.
        # IMPT: For new version, I will give user opportunity to name each css class in a file before printing it out and store their results in an array.
        pusher=self.getArrayOfInfo(False,True)#<-- Returns the entire 2-d array consisting of all css classes and their respective css statements in the passed in css file.
        for j in range(len(pusher)):
            for k in range(len(pusher[j])):
                pusher[j][k]+=(';' if str(pusher[j][k]).__contains__(';') == False and str(pusher[j][k]).__contains__('{') == False and str(pusher[j][k]).__contains__('}') == False else '')#<-- Ensures each css line of code is lined up neatly and has an appended semicolon.
                if(k == 0 and j < len(idCC)):#<-- conditional responsible for assigning new names or modifying names of css classes in a file.
                    print("."+f"{idCC[j]}"+"{"+pusher[j][k], file = s)
                elif(k == len(pusher[j])-1):
                    print("\n}"+str(pusher[j][k]).split(";")[1], file = s)#<-- Prevents semicolon from being appended on back braces[ } ]
                else:
                    print(pusher[j][k], file = s)    

#THis will contain the classes responsible for handling the logic errors induced by users.
# Exception creations/ideas that I thought about:
# - Can create an exception if user enters the wrong filepath instead of the program crashing completely.
class IncorrectUserInputException(Exception):
    userInp: str#<-- This will be used to handle when user inputs something incorrectly. May need to think bout this more. IMPT: Instaed, I can create regular functions whose bodies
        # self.userInp#<-- This will be used to handle when user inputs something incorrectly. May need to think bout this more. IMPT: Instaed, I can create regular functions whose bodies
        # Are purely responsible for printing out indications of logical errors.
        #Using a try n catch block in this statement to read the file's content and return it as a regular string. 
    pass
def missingArg(index = -1):#<-- This is used to throw an exception when user misses an argument when typing commands in terminal.
        return (f"Missing an argument @ index {index}." if index > 0 else "")
        # Optional: Could use conditionals to print out different things based on the command used.
def outOfIndex(index: int, size: int):
        return "Index out of bounds, unable to execute command as requested"
def filePathDNE(file):
        raise FileNotFoundError(f"The file @ the following filepath does not exist: {file}")
def missingDash(cmdlet: str):
        return (f"Invalid input. Did you mean -{cmdlet} ?")
    
    
    

class IncorrectUserInputException(Exception):
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
    
    
    

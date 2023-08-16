echo "Welcome to the script!
1) To download your vs-code, type in dl-vscode.
2) To download vs-code with the C++ compilers, type in dl-vscode -publisherID 'ms-vscode' -extensionID 'cpptools-extension-pack'   
3) IMPT: If Visual Studio code is currently not on your system, you will have to run dl-vscode before running the code on
line 2). Also, if you want to install other extensions for vscode type in dl-vscode -publisherID '<<publisher id>>' -extensionID '<<extensionID>>'     

"
function dl-vscode
{ [cmdletBinding()]param([Parameter()][string]$publisherID, [Parameter()][string]$extensionID)
  $deter=Test-Path -Path "~\appdata\local\programs\Microsoft VS Code"
  
  if($deter -eq 0)#Boolean exp checking if the exe to start vs code exists.
{ 
  & '~\OneDrive\Desktop\Google Chrome.lnk' "https://code.visualstudio.com/sha/download?build=stable&os=win32-x64-user"
  echo "Downloading Setup executable..."
  sleep -Seconds 30 #<-- This will be used to delay the program so the vscode setup executable has time to install.
  cd ~\Downloads;start VSCodeUserSetup-x64-1.78.0.exe
  echo "Undergoing VSCode Setup..."
  #At this point, the user will undergo the required steps to install the program. In the setup function, I will the program wait, and then run the function again with the required parameters.
  return #<-- I am using this to download the base vs code first, before downloading the extensions.
  #Conditional works as intended!
  }
  
  elseif($deter -eq 1)
  { echo "Currently Adding requested Extension..."
  $checkExists=(code --list-extensions) #<-- I am using this to iterate, to check if the requested extension is already installed. 
    #After setup is done, I will check for the exe file for the application, and then I will start downloading the neccessary extensions.
    foreach ($pack in $checkExists)
    { if($pack -eq "ms-vscode.cpptools-extension-pack")
    { echo "Extension for C++ is already installed!";return

    }
                 
    }
    #if the requested extension doesn't exist already, then: 
    code --install-extension "$publisherID.$extensionID" #<-- This installs the extension in code.
    if($publisherID -eq "ms-vscode" -and $extensionID -eq "cpptools-extension-pack")
    { #Here, is where I will get the zip folder using wget, unzip it, place the compiler folder in a custom compiler dir, and then add the neccessary env variables.
      #Also, this may be the place where I use git to pull the .vscode directory for the JSON configuration files for my compiler(s).  
      & '~\OneDrive\desktop\Google Chrome.lnk' https://github.com/brechtsanders/winlibs_mingw/releases/download/13.1.0-16.0.4-11.0.0-ucrt-r4/winlibs-x86_64-posix-seh-gcc-13.1.0-llvm-16.0.4-mingw-w64ucrt-11.0.0-r4.zip
      sleep -seconds 90
      cd ~/downloads;tar -xkf winlibs-x86_64-posix-seh-gcc-13.1.0-llvm-16.0.4-mingw-w64ucrt-11.0.0-r4.zip
      cd winlibs-x86_64-posix-seh-gcc-13.1.0-llvm-16.0.4-mingw-w64ucrt-11.0.0-r4; mv mingw64 /Windows/System32 #<-- This is used to put the c++ compilers in a certain directory which will be added to the environment variables for the computer.
      $checker=$env:Path -split ";"
      for($i=0;$i -lt $checker.Length;$i++)
      { if($checker[$i] -eq "C:\System32\cmd.exe")
        { break

        }
        elseif($checker[$i] -ne "C:\System32\cmd.exe" -and $i -eq $checker.Length-1)
        { 
        #$checker.Add("C:\Windows\System32\cmd.exe")
        #Alternate way: 
        echo "You need this path in your env:path variables. It is clipped to your clipboard."
        $e=(~)
        $user=pwd ~;
        echo " Steps to take for modifying environment variables:
        1) Double-Click Path under 'User variables for <<Your username>>'
        2) Press 'New'
        3) Input ctrl+v. Make sure to delete this part '∩╗┐' off of the text.
        4) Then press okay. You have 45 seconds to complete the steps as requested before the script continues.
        "
        "C:\Windows\System32\cmd.exe" | clip
        rundll32 sysdm.cpl,EditEnvironmentVariables
        sleep -seconds 45
        $i=0;#<-- This is used to reset the loop.
        }
        elseif($checker[$i] -ne "C:\Windows\System32\mingw64\bin" -and $i -eq $checker.Length-1)
        {
          #$checker.Add("C:\Windows\System32\mingw64\bin")
          #Alternate way: 
          echo " Steps to take for modifying environment variables:
        1) Double-Click Path under 'User variables for <<Your username>>'
        2) Press 'New'
        3) Input ctrl+v. Make sure to delete this part '∩╗┐' off of the text.
        4) Then press okay. You have 45 seconds to complete the steps as requested before the script continues.
        "
        "C:\Windows\System32\mingw64\bin" | clip
        rundll32 sysdm.cpl,EditEnvironmentVariables
        sleep -seconds 45#<-- This is used to reset the loop.
        $i=0;  
        }  

      }
      
      echo "Extension and the neccessary compilers were installed as requested."
      echo "The neccessary JSON files for your c++ compilers are in the webpage in front of you."
      & '~\OneDrive\Desktop\Google Chrome.lnk' https://drive.google.com/drive/folders/1C5YiAqTlOrBZZ0m5s0GkC6rJ3u7xeNmP
              

    } 
  }




  
   
  
}
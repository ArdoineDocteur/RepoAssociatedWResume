/*NOTE: THe purpose of this file is to host all of the javascript code needed for the rockPaperScissors project to work.
NOTE: In the advanced functions, implemented the keydown event so that the user can play the rockPaperScissors game. For
future reference, if you want to use the onkey attribute for user interaction, query the body of the page, as shown below.
*/

Scores={userScore: 0, computerScore: 0, ties: 0};//<-- This line of code allow us to directly saves the score as needed.
// localStorage.setItem('Score', JSON.stringify(Scores));//<-- Here, we rely on the JSON.stringify method to convert our object into a string that can be used to be able to use the localStorage object permanent data saving.
let permScore=JSON.parse(localStorage.getItem('Score')) || {userScore: 0, computerScore: 0, ties: 0};
//  This if statement is commented out because its purpose is fufilled using the default operator above. 
//    if(!permScore)
// {
//     Scores={
//         userScore: 0, computerScore: 0, ties: 0
//     };
// }

document.body.addEventListener('keydown',(event) => { //<-- This is used to allow the user to play the game via the keyboard. When checking for key input, ensure that the parameters, of either the reg function or the arrow function, contains the keyword 'event'.
computerChoice=pickComputerMove();
if(event.key==='r')
{   userChoice='Rock';

}
else if(event.key==='s')
{
    userChoice='scissors';
}
else if(event.key==='p')
{   
    userChoice='paper';
    
}
playGame(userChoice,computerChoice);
winner(userChoice,computerChoice,result);
    // console.log("keydown");
});
console.log(localStorage.getItem('message'));//<-- THis line of code is used for accessing values that are in localStorage. The syntax for accessing values in localStorage is: localStorage.getItem(<<key to value you want to access>>).
let userChoice='';
let computerChoice='';
let result='';
let count=0;
localStorage.setItem('message','hello');//<-- Remember that localstorage only supports strings. This line of code is for setting values in the localstorage.
//The syntax for setting items in local storage is: localStorage.setItem('<<key>>','<<value>>'). Also remember that localstorage ONLY SUPPORTS STRINGS!
    
    function pickComputerMove()
{   const randomNumber=Math.random();
    if(randomNumber>0 && randomNumber<=0.33)
{
    console.log('Computer picked rock.');
    computerChoice='Rock';
}
else if(randomNumber>0.33 && randomNumber<=0.66)
{
    console.log('Computer picked Scissors');
    computerChoice='Scissors';
}
else
{
    console.log('Computer picked Paper');
    computerChoice='Paper';
}

return computerChoice;
}
function winner(uC, cC, res)
{
    if(res==='User Wins!')
    {
        Scores.userScore++;
        permScore.userScore++;
    }
    else if(res==='Computer Wins!')
    {
        Scores.computerScore++;
        permScore.computerScore++;
    }
    else
    {
        Scores.ties++;
        permScore.ties++;
    }
    // alert(`You picked: ${uC}. The Computer picked: ${cC}. Result: ${res}
    // Wins: ${permScore.userScore}, Losses: ${permScore.computerScore}, Ties: ${permScore.ties}
    // `); NOTE: Commented this out because it was redudant since the score will always appear on the page.
    
    document.querySelector('.game-result').innerHTML=`${res}
    
    You: ${iconDisplay(uC)} - Computer: ${iconDisplay(cC)}
    
    <div style= "display: inline-block; padding-left: 10px;">Wins: ${permScore.userScore}, Losses: ${permScore.computerScore}, Ties: ${permScore.ties}</div> 
    `;//<-- Here I used the document object's query selector property to modify the result text in the html tag paragraph with the class game-result to output the results of the game.
    localStorage.setItem('Score', JSON.stringify(permScore));//<-- Here, we rely on the JSON.stringify method to convert our object into a string that can be used to be able to use the localStorage object permanent data saving.
    
    
    
}
function iconDisplay(opt)
{   let choice=String(opt).toLowerCase();
    let selector=document.querySelector('.user-choices');
    // console.log(selector.innerHTML);    
if(choice==='rock')
{   
    return `<img style="width: 50px; height: 50px;
    padding: -5px;
    " src="Icons4Projects/rock-emoji.png" class="rock-size">`;
}
else if( choice==='scissors')
{   return `<img style="width: 50px; height: 50px;
    padding: -5px;
    " src="Icons4Projects/scissors-emoji.png" class="scissors-size">`;
}
else if(choice==='paper')
{   return `<img style="width: 50px; height: 50px;
    padding: -5px;
    " src="Icons4Projects/paper-emoji.png" class="rock-size">`;
}

}
let intervalID;
function autoPlay(isPlaying=true)
{   if(isPlaying===true)
    intervalID=setInterval(() => { winner(pickComputerMove(),pickComputerMove(),String(playGame(pickComputerMove(),pickComputerMove())))
    },1000);//<-- NOTE: In order to use the setInterval integrated func properly, YOU MUST call the function using the first
    //param above. THe function id way doesn't work as intended. Also, another thing to know is that the setInterval function returns an integer.
    //NOTE: Here, we replaced function() {} with => {}, to make our code a little neater. What was previously there: setInterval(function(){ winner(pickComputerMove(),pickComputerMove(),String(playGame(pickComputerMove(),pickComputerMove())))
    //},1000);
    else
    clearInterval(intervalID);//<-- This function is used to halt the setInterval. The syntax for this is: clearInterval(<<setInterval func(or id)>>). Refer to the code above for reference.
}
//NOTE: When using arrow functions, NEVER RELY HEAVILY ON ARROW FUNCTIONS! Only use them when the functionality is EXTREMELY comprehensible.
function playGame(choice,computerChoice)
{   choice=choice.toLowerCase();
    computerChoice=computerChoice.toLowerCase();
    if(choice==='rock')
{
    if(computerChoice==='paper')
{
    // console.log('Computer wins!');
    result='Computer Wins!';
}
else if(computerChoice==='scissors')
{
    // console.log('User Wins!');
    result='User Wins!';
}
else if(computerChoice==='rock')
{
    // console.log('It is a tie!');
    result='It is a tie!';
}
}
else if(choice==='scissors')
{
    if(computerChoice==='rock')
{
    // console.log('Computer wins!');
    result='Computer Wins!';
}
else if(computerChoice==='paper')
{
    // console.log('User Wins!');
    result='User Wins!';
}
else if(computerChoice==='scissors')
{
    // console.log('It is a tie!');
    result='It is a tie!';
}
}
else if(choice==='paper')
{
    if(computerChoice==='scissors')
{
    // console.log('Computer wins!');
    result='Computer Wins!';
}
else if(computerChoice==='rock')
{
    // console.log('User Wins!');
    result='User Wins!';
}
else if(computerChoice==='paper')
{
    // console.log('It is a tie!');
    result='It is a tie!';
}
return result;
}

}
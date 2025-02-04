
function Task(name,dueDate)//<-- This function is used to create custom objects to modify values with. PN: It is similar to creating classes in java and using the class as an object to create more unique versions of them.
{   this.name=name;
    this.dueDate=dueDate;
}
let TaskStorage=Array(Task);
let count=0;
function addTasks(txtBoxNum)
{   //PN: This is an example of using an object and then manipulating it to create new property values of the same object type.
    
    let output=document.querySelector('.js-user-output');
    let newTask= new Task();//<-- PN: Here, I use the new keyword to create a dynamic instance of the task object so I can create unique versions. The new keyword here has the same purpose that it has in java.
    newTask.name=document.querySelector(`.js-user-input${Number(txtBoxNum)}`).value;//<-- Remember that to get input from the html input tag, you need to the property .value AFTER YOU use the querySelector method.;
    newTask.dueDate=document.querySelector(`.js-due-date-UI${Number(txtBoxNum)}`).value;
    /* TaskStorage.push(newTask.value)//<-- This is used to add a value to the end of the array. As said before, this treats the array like the Queue data structure.
    NOTE: The reason why this line of code is commented out is because 
    */
    TaskStorage.push(newTask);
    output.innerText=`${newTask}`;
    document.querySelector(`.js-user-input${Number(txtBoxNum)}`).value='';//<-- This allows us to reset the text box everytime we submit an entry.
    document.querySelector(`.js-due-date-UI${Number(txtBoxNum)}`).value='';//<-- This allows us to reset the text box everytime we submit an entry.
    // console.log(output.innerText);
}
// document.body
document.body.addEventListener('keydown',(event) => {
    // console.log(event.key);
    if(event.key==='Enter')
    {
        addTasks(0);
        displayTasks();
    }
})
function displayTasks()
{   
        let displayTDLhtml='';//<-- Used to create the accumulator pattern for appending the values to display to user.
        for(let i=1;i<TaskStorage.length;i++)
        {   const {name,dueDate}=TaskStorage[i];//<-- This is an example of deconstructing in javascript. We learned about this in a previous lecture. THis is useful when you want to access the properties of an object and limit the typing of syntax.
            //The line of code above is the same as doing: TaskStorage[i].name and TaskStorage[i].dueDate on separate lines. THIS IS VERY IMPT!
            //In the HTML variable, we used divs to separate each element into three parts to fufill our display needs.
            html=`
            <div style="padding: 10px;">Task Name: ${name}</div>
            <div style="padding: 10px; display: inline-block;">Task Desc: ${dueDate}</div>
            <div><button class="delete-button"
            >Delete</button></div>
            `//<-- On this line of code, we create html code and insert each value inside of the body of the html paragraph tag to display to the user.
            //In the code above, we take advantage of modifying the html code through js by adding the delete button for delete options for users to see.
            displayTDLhtml+=html;
            //NOTE: During the advanced functions lecture, we removed the onclick attribute and replaced it with the code @ the end of the page via eventListeners.
        }
        /* Another way to implement the for loop above via the forEach method: PN: Personally, I prefer the regular for loop, but the forEach loop is also good to know as well.
        TaskStorage.forEach(function(val,index){
            // index+=1;
            const {name,dueDate}=val;//<-- This is an example of deconstructing in javascript. We learned about this in a previous lecture. THis is useful when you want to access the properties of an object and limit the typing of syntax.
            //The line of code above is the same as doing: TaskStorage[i].name and TaskStorage[i].dueDate on separate lines. THIS IS VERY IMPT!
            //In the HTML variable, we used divs to separate each element into three parts to fufill our display needs.
            html=`
            <div style="padding: 10px;">Task Name: ${name}</div>
            <div style="padding: 10px; display: inline-block;">Task Desc: ${dueDate}</div>
            <div><button class="delete-button"
            onclick="TaskStorage.splice(${index},1);//<-- NOTE: The actual syntax for the array's splice method is: <<array id>>.splice(<<index of value you wanna remove>>,<<amount of values to remove @ that index(PN: Could be refering to properties inside of that one index? Nevetheless, in most cases, just set the amount of values to 1.)>>)
            displayTasks();//<-- This allows the user to see the updated tasks after removing the particular task.
            "
            >Delete</button></div>
            `//<-- On this line of code, we create html code and insert each value inside of the body of the html paragraph tag to display to the user.
            //In the code above, we take advantage of modifying the html code through js by adding the delete button for delete options for users to see.
            displayTDLhtml+=html;   
        })
        */
        // console.log(displayTDLhtml);
        document.querySelector('.js-user-output').innerHTML=displayTDLhtml;//<-- This line of code is used append the html string created from the for loop into the div with the class name .js-user-output which allows us to display the user's entries.
        console.log(document.querySelectorAll('.delete-button'));//<-- Here we use querySelectorAll which allows us to access all the elements that contain the dlete class. Due to its array-like structure, we use a for loop to delete a certain amount of tasks after a keydown.
        document.querySelectorAll('.delete-button').forEach((deleteButton,index) => {   //<-- We use a forEaech loop to achieve our goal above.
            deleteButton.addEventListener('click',() => {
                TaskStorage.splice(`${index}`,1);//<-- NOTE: The actual syntax for the array's splice method is: <<array id>>.splice(<<index of value you wanna remove>>,<<amount of values to remove @ that index(PN: Could be refering to properties inside of that one index? Nevertheless, in most cases, just set the amount of values to 1.)>>)
            displayTasks();//<-- This allows the user to see the updated tasks after removing the particular task.
            })
        });        
}





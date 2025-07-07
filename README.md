[Purpose]: <> "The purpose of this document is to house the formatting scheme for my readme file for my git remote repo associated with my resume."

# Project List
IP = In Progress

## Computer Science

### Personal Projects
#### [SetupScript: Windows Powershell](https://github.com/ArdoineDocteur/RepoAssociatedWResume/blob/main/vs-codeWtihC%2B%2BCompilersScript.ps1)

Purpose: Created a powershell script to setup a new computer with documents that lie on older computer. 

#### [Rock Paper Scissors Game: Javascript, HTML, CSS]()
Purpose: Create a Rock Paper Scissors Game using vanilla javascript, HTML, and CSS. 

#### [ToDoList: Javascript, HTML, CSS]()
Purpose: Create a simple To-do List application using vanilla javascript, HTML, and CSS. 
#### [CssEditorTerminal : Python](https://github.com/ArdoineDocteur/RepoAssociatedWResume/tree/main/CssEditorTerminal(Python))

Purpose: Create a Terminal System for modifying the appearance of a HTML file.
```txt
Abstract Representation of vision for project

1) First you must figure out the command args you would like to use 
to make certain changes to the appearance such as 
background color, text color, etc. 
Also may need to figure out the command arg needed 
to target certain lines of code in a css file.

2) Figure out the REGEX required to target css code.
 
3) Think of the modification features that you will provide, 
and the menu blueprint to output to the user. NOTE: Thinking about using the command line 
where the user enters the filepath to the html file of their choosing.

4) If you'd like, you can create a class that contains a 
css selector selection and an array[list] of modifcations 
for that particular css selection.

```
#### [Guessing Game : C++](https://github.com/ArdoineDocteur/RepoAssociatedWResume/tree/main/GuessingGame(c%2B%2B))

Purpose: Created a guessing game using dynamic memory allocation through the use of unique pointers using C++
```txt
Abstract Representation of vision for project

Subobjectives:
- 1) Create a user environment that directly tells the user the req instructions
- 2) Use an unique pointer array to output the user's entries.
Ideas:
- Will make unique pointer array of type int.
- Initial plan is to write everything in main method. After the logic is implemented correctly, I will split the code
into files, and WILL create a makefile for running the program as well.
- Make sure to explain the coding logic effectively using a decent amount of comments.
- Going to make a simple makefile for the project as well.
- IMPT: May have to consider a case where user inputs another data type other than a number. Will use a try and catch block for that.
```
#### [Chore App : MERN](https://github.com/Darnell-Chen/SMS-RemindR)
- Brief Description: SMS RemindR is a web app that allows you to schedule notifications via SMS, Email, and Discord. Built using the MERN stack, it features both a backend and frontend framework to ensure seamless operation and user experience.


#### [Grocery Sales Web Scraper: Python][IP]

Purpose: Creating a web scraping project using Python that can help people save money when they go to the grocery store. This project benefits those who are regular IGA Grocery Shoppers.
```txt
Abstract Representation of Vision for Project
1) The first step is to find an integrated python module that allows you to use some sort of querying system, that is similar to Javascript, with the exception that you can provide a link to a website to be that dynamic DOM object to query in.[Link to article that talks about 7 libraries that are useful for web scraping: https://www.projectpro.io/article/python-libraries-for-web-scraping/625#:~:text=Requests%2C%20BeautifulSoup%2C%20Scrapy%2C%20and,for%20web%20scraping%20in%20Python.]
2) After this, take the time to surf the website and find information of importance that is uploaded daily. Once this is found, understand the purpose of the display and then create a class that allows you to display this information in a more linear way.
3) Once the object is created, use the web scraping, by targeting certain information to create objects that are formatted in a format that can be displayed in tabular or tab-delimited format in a text file.
4) Once the data is formatted, create a search engine, using REGEX, which is responsible for pulling up data that is relative to the data retreived from the website.
```

[Personal Note]: <> "Can Make Project Title into a hyperlink referencing the directory containing the project. Inside of that directory, I can display my roadmap as a markdown document. The markdown document can also contain the instructions to run the project. If the roadmap wasn't used for the project, then I can go to project executables directory and derive my pre-alpha roadmap from there."

#### [ Task Manager : MERN Stack][IP]

Purpose: Create a task manager program using React.js for the frontend, and using MongoDB as the database for the Task Manager.
```txt
Abstract Representation of Vision for Project
1) Before you start coding, draw your blueprint on paper or using google drawing(complete, blueprint in green folder in blue bookbag)
2) Ensure that you have the neccessary HTML/JSX markup that fulfills your needs as far as blueprints[Implement in html first, and then use the JSX converter online]
3) Figure out what each button's purpose will be[could be useful to think of some simple things such as checking for amount of tasks, checking the priority of tasks,(add more features here as ideas come along]
4) Figure out the custom objects you may need, the data structure you want to use, and implement these via javascript for your backend dev. IMPT: Based on the purpose of this idea, I believe using a Min Heap or a BST could be extremely useful. Therefore, refer to blue CSCE 146 notebook and the data structures directory from that class for more information. a) Once you know what objects you may need, create a UML diagram before you begin coding. It is highly recommended to create the classes needed, along with their member functions, in the .ts or .js file, and then create the UML diagram from there.
5) Once the blueprint is established, implement minute features such as transitions to make the UI feel satisfying through the use of css and
,if possible, use JQuery.
6) Once subobjective 4) is completed, then I need to figure out the tables that I will
need for my database so that user data is properly handled, and its access is seemless.
```
[Personal Note]: <> "Can Make Project Title into a hyperlink referencing the directory containing the project. Inside of that directory, I can display my roadmap as a markdown document. The markdown document can also contain the instructions to run the project. If the roadmap wasn't used for the project, then I can go to project executables directory and derive my pre-alpha roadmap from there."

[PN]: <> "IMPT: Next project to add is the creating website-based database for job applicants for different organizations"
#### [Job Ocean : MEAN Stack][IP]

Purpose: Creating website-based database for job applicants for different organizations
```mermaid
flowchart TB
  %% (cont here by ideating process of entity navigating through the system OR the system navigating through itself)
%% Body of nodes and edges that describe interface 
description["description"] --> descIntf0["User is forced to choose whether they're an applicant or administrator, when creating their account and when attempting to login. "] --> descIntf0.1["If user chooses administrator, User is asked &forall;y &in; {Organization, Admin Username, Admin password, (cont here if applicable)} through the form of a credential screen"] --> descIntf0.2["User is met with a screen that allows them to do x where x &in; {surf through all job-applicants,change organization[which would cater to people who run multiple businesses], logout, (cont here if applicable)"] --> descIntf0.3["User is able to go into more detail about job-applicants"] --> descIntf0.4["User is able to accept or reject job-applicants"] --> descIntf0.5["User is able to set stages of job-applicant process"] -->  descIntf0.6["User is able to send direct feedback to the job-applicant"] -->   descIntf0.7["User is able to communicate with other adminstrators. And if user is a job-applicant, they're also able to communicate with other job-applicants"] --> descIntf0.8["User is able to receive notification x where x &sube; {messages, interviews, rejections, round upgrades, (cont here if applicable)}"]

%% --> descIntf0.9["(cont here if applicable, thought(s) before stopping: 1) Implementing heavy cybersecurity for program, 2) At this point, it seems like everything required for this to work is present. Thus, currently want to add things that convenience users. 3) At this point, seems like everything to support the user is acheived using the aforementioned process"]

%% (cont here, after implementing other subgraphs in code)
%% end of nodes and edges that desc interface


    %% Code below addresses particular cases in regards to user interactions: 
    deci0["User decides to login to check the statuses of their applications"] --> deci0.1["User logs in as an applicant"] --> deci0.2["User navigates to a toolbar to see the statuses of their applications"]
    deci1["User decides to login to check the number of applicants to a particular job"] --> deci1.1["User logs in as an administrator"] --> deci1.2["User goes to job section"] --> deci1.3["User selects the job that they posted"] --> deci1.4["User observes the number of applicants for that job with the option to look at all applicants that applied"]
     deci2["User decides to create an account "] --> deci2.1["User clicks button on initial state page and is redirected to page to create an account"]
    %%(cont here IF Applicable) -->
     deci3["User decides to logout "] --> deci3.1["User accesses toolbar to logout[means, need to have toolbar as one of static state(s)]"]
    %%(cont here) -->
     deci4["User decides to create an admin account with an intention to join an existing organization to help manage applicants"] --> deci4.1["User navigates to initial state and then creates an account and then joins the existing organization referenced by a dropdown menu"]
     %%(cont here IF Applicable) -->
    deci5["User decides to send dm to anoother job applicant"[note should be a synonym of dm that hosts the connection between job applicants and admins. Should be a certain order or indicator that differentiates the regular dm and the non-regular dm]] 
   %%  (cont here) --> 
    deci7["User decides to delete account"]
    %% (cont here) -->
    %% Also, brainstorm some paritcular use cases for this application. 





    %%  end of Code that addresses particular cases in regards to user interactions: 


    %% Feature(s) succeeding this point are optional
    %% PN: The stuff above will be the template that I use to map out func of future projects!

    %% body of how system will react to implicit and explicit requests by user via http. 
    subgraph systemReactions
      direction TB
      subgraph rel-Sets-rep
      direction TB
      %% (cont here by modifying inptu below by making it general to prep it for specialization w.r.t the idea at hand). UPDATE #1: 100% complete
      respIntf0["System receives data x that determines y, resulting in (x,y) where x &in; set of 2-tuples containing username and password and sends a bool value if (x,y) &in; &rho; where &rho; = x &in; U(users) in database."] --> respIntf0.1["System sends data z that determines a, resulting in (z,a) where z &in; U(users) and a &in; {U(job applications), current organization, profile, direct messages, (cont here if applicable) <insert elements relevant to assigning membership to user>} and sends a bool value if (z,a) &in; &rho; where &rho; = z is a y."] 
      respIntf0.1 --> respIntf0.1.0["System receives data from user x requesting access to w, resulting in data retreival from database referencing data associated with w where w &in; {<insert elements relevant to data that is requested by user(s)}"] --> respInf0.1.1["If (x,w) &nin; &cup;<sub>1 &le; i &le; n</sub> &rho;<sub>i</sub>, then user isn't valid. The n relations are as follows: { x wants to see organization(s) w that are hiring on job board, x wants to see message(s) w received, x wants to see message(s) w sent, <insert the relations between data and user requests that permit the request and retrieval of the data>}"]
      respIntf0.1 --> respIntf0.2["System receives data from user x requesting modification to u, resulting in data update from database referencing data associated with u where u &in; { AboutSection(x), StatusesOfMessages(x), FavoritedJobs(x), FavoritedOrganizations(x), (cont here IF applicable) <insert elements that are properties(x) associated with user x>}"]
      respIntf0.1 --> respIntf0.3["System receives data from user x requesting DELETION to u, resulting in data DELETION from database referencing data associated with u where u &in; { messages(x), FavoritedJobs(x), FavoritedOrganizations(x), (cont here) <insert elements that are properties(x) associated with user x>}"]
      respIntf0.1 --> respIntf0.4["System receives data from user x requesting CREATION to u, resulting in data CREATION and adding it to database referencing data associated with u where u &in; { messages(x),FavoritedJobs(x), FavoritedOrganizations(x),  <insert elements that are properties(x) associated with user x>}"]
      end
      subgraph regularVersion
      direction TB
        respIntf0["in prog"]

      end
      %% (cont here with non-rel-sets-rep)
      %% (cont here at descIntf0.2.1[by addressing all cases where data may be modified]) 
      %%, need to go back to UX desc and think about how relations can be used to describe modifying data, creating data, and deleting data[basically using relations to allow CRUD operations])[NOTE: In future, when writing powerpoint, goal is to transform these relations into nodes and edges to ensure that anyone can understand this process][Note as of 6/13/25: This was complete, this will be the approach taken for the rest of the backend procedures going forward. Will also have relation-sets verison as a subgraph and have the expanded, non-relation-sets version as a subgraph. 
      end

    %%end of body of how system will react to implicit and explicit requests by user via http



%% end of body of Flowchart 1

```

[Personal Note]: <> "Can Make Project Title into a hyperlink referencing the directory containing the project. Inside of that directory, I can display my roadmap as a markdown document. The markdown document can also contain the instructions to run the project. If the roadmap wasn't used for the project, then I can go to project executables directory and derive my pre-alpha roadmap from there."


#### [TeachMe : MERN Stack][IP]

Purpose: Build an app specifically for keeping track of both tutors, clients and their respective needs---

### School Projects 

#### [Geometric Shape Generator : C++](https://github.com/ArdoineDocteur/RepoAssociatedWResume/tree/main/Geometric%20Shape%20Generator(C%2B%2B))

Objective: [Implement three classes to output geometric shapes in the
CSCE240_Program6 namespace](https://github.com/ArdoineDocteur/RepoAssociatedWResume/blob/main/Geometric%20Shape%20Generator(C%2B%2B)/Programming-Assignment-6.pdf)

---
[Personal Note]: <> "Thought about having readme files in the respective project dirs that have instructions for testing out the respective programs. Thought about utilizing docker skills by making dockerfiles for setting up envs, as well as utilizing scripting skills to have program execution be seamless and handless for testing out[will revise later, but you should get the point]"

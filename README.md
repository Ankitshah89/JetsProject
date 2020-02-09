## Jets Project (Week 3 Skill Distillery)



#### Overview 
This application creates a fleet of jets with different capabilities. There is a menu to use your jets and access information about them.   
 
Jets project is primarily  designed to utilize and implement the various concepts of Object Oriented Programming fundamentals (OOP) :  _Abstraction_ , _Inheritance_ ,
 _Polymorphism_ , _Encapsulation_ .  
  
This application loads a text file which is composed of various types of aircrafts with their attributes(model, range, speed, price, type). Each aircraft is created as an **Object** and stored in an **ArrayList** in a class called Airfield. There are different categories of aircrafts or jets :  _FighterJets_  ,  _CargoJets_  and  _PassengerJets_ .
Each of these types have their own **class**, **subclasses**, and a **abstract class** called Jets. I implemented an **interface** to group methods for specific classes and not duplicate code.  
  
The main method (JetApplication) calls the run method where the user is prompted with a menu of option to select from:  
  
**1.** **List fleet**  
**2.** **Fly all jets**  
**3.** **View fastest jet**  
**4.** **View jet with longest range**  
**5.** **Load all Cargo Jets**  
**6.** **Dogfight!!**  
**7.** **Add a jet to Fleet**  
**8.** **Remove a jet from Fleet**  
**9.** **Quit**  

The menu is displayed until the user chooses to exit(Quit).  

I used the following **UML Diagram** to help me develop my classes and interfaces.  


<img src = "https://raw.githubusercontent.com/SkillDistillery/SD25/master/java2/Jets/images/UMLJets.png?token=AML5DWKSCM2GYO3FEBIFLGS6JDAFC">

As we can see above,  _JetApplication_  is the main method that launches the application and  _Jet_  is the parent class. All the subclasses implements the inheritance mechanism to reuse the codes.

#### Technologies/ Concepts Used
- Abstraction
- Inheritance
- Polymorphism
- Encapsulation  
- Interface
- Buffered reader and file reader to get information from a file
- ArrayList
- Exception Handling
- Java / Github/ Eclipse / StackOverflow

#### Lessons Learned
 This project enabled me to better understand the fundamentals of OOP. Being able to understand the link between all the parent class and subclasses and how we can call the methods to utilize and implement codes from the parent class was fascinating. I have only one static method in my main application and I was able to use encapsulation mechanism to properly hide the data. This project allowed me to  better understand of the use of  abstract methods, overrides, and interfaces. I also enjoyed playing around and figuring out the structures and characteristics of different types of lists and ArrayLists.  
 
Overall this was a fun project where not only did I learn a lot, I was also able to explain my thought process clearly to my colleagues. I do have a few stretch goals, which I will implement in the future.


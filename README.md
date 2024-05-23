# Java-SpringBoot-H2Database-OlympicGames

The objective of the Olympic Games Application project is to build a REST API based Web Application that allows the user to access information stored in a relational database.

Please find below the detailed step-by-step documenting the entire development of this project.

------------------------------------------------ // ------------------------------------------------

Introduction:


For this project I decided to use a theme and bring data linked to sport and more specifically about the Olympic Games. It's a subject that I really like and even though it is an event that takes place every four years, it will always be something current, especially this year(2024) when we will have another edition of the Olympic Games in France in August.

I collected and created a .sql file with data from all the Olympic Games that have already been held or are planned to happen, with a total of around 95 entries or id(s) of six different types of games:

 Standard Olympic Games, Winter Olympic Games, Summer Youth Olympic Games, Winter Youth Olympic Games, Summer Paralympic Games and Winter Paralympic Games..

------------------------------------------------ // ------------------------------------------------

Understanding the Project and Its Requirements: 


Talking about the main objective of the Olympic Games Application project, which is to build a REST API based Web Application that allows the user to access information stored in a relational database.

Having access to data means being able to consult the data as a whole or to consult specific data contained in the database. Being able to add new information to the database or even to delete any data.

The tools involved in the project are:

Eclipse IDE
Java Language
Spring Boot micro-service-based Java web framework offered by Spring
Web browser
Postman Application to allow us to test our Web API


Using Spring Initializr to configure our Java Maven project and inject three dependencies into our POM file:

Spring Web - Contains common web specific utilities
Spring Data JPA(SQL) - Java Persistence API to help with the implementation of data access layers
H2 Database(SQL) - For managing our relational database

------------------------------------------------ // ------------------------------------------------

Project Java Files: 


Creation of five java packages with a class for each, with a specific function within the project:

1.package com.project.olympicGames -> contains OlympicGamesApplication.class:

This is the class that contains the main method responsible for running the entire application. We have a special annotation @SpringBootApplication that is the entry point to Spring Boot to take care of auto-configuring the application.

---------------------------

2.package com.project.olympicGames.dto ->contains UserExploreOlympicGamesDataTable.calss: 

In this class we declare the class attributes, the two constructors, the getters and setters methods and the overridden toString method.

We have two annotations for the class:
@Entity -> Defines that the class can be mapped to a table.
@Table -> Indicating the table and assigning a name to it.

For each attribute we have the @Column annotation which also assigns a name to each one that will later give a title to each column in our table. In particular for the id attribute, in addition to the @Column, we have also the @Id annotation that marks this attribute as primary key of the entity and will be used to identification of the entity.

---------------------------

3.package com.project.olympicGames.controller -> OlympicGamesController.class :

We have very important points in this class. The first the creation of an instance of the project interface that we will talk about later. We will use this object instantiated within the methods that will handle the user's requests such as to get data, to get data by id, to post a new data in the table and finally a method to delete data from the table passing an id as reference.

Regarding the important annotations we have, @RestController, which acts directly on the class and it is used to create RESTful web services and to mark a class as a request handling component that produces and consumes JSON or XML data.

@Autowired goes to the created instance of the interface class and it allows Spring to automatically wire the required dependencies into the class.

Then we have @GetMapping, @PostMapping and @DeleteMapping, these three annotations build the entry path for the project, either based on an id parameter being passed in the request message or on a general path.

---------------------------

4.package com.project.olympicGames.repository -> interface UserOlympicGamesRepository:

The purpose here is the repository, and we have two points to highlight, the first is that the interface extends from the super interface function JpaRepository that accepts one argument and produces a result.

The second point is the @Repository annotation that is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operations.

---------------------------

5.package com.project.olympicGames.exception -> ResourceNotFoundException.class:

In this fifth and final java package of the project we have a class responsible for handling exceptions.

The class basically extends from Exception super class and has a constructor method that receives a parameter of type String, which is the customised “Data Not Found” message sent by the get by id method of the OlympicGamesController class that we have already mentioned. If by chance the id passed by the user at the time of the request is not found in the database. 

We use the keyword super to pass the error message as argument  to the responsible method in the Exception super class.

An important point here is that the customised message will not be displayed to the user on the client side, we can even print the message to the console for tracking purposes, but the message that will actually be shown to the user, (In our case in the Postman Application), is a standard message that The HttpStatus enum will be returning. 

This is an Enumeration type, which will invoke the NOT_FOUND method that has the error code 404 as a reference and the standard pre-defined message "Not Found", which will then be the returned message error displayed to the user.

And this process is only possible because we use the @ResponseStatus annotation directly in the class, and pass in as parameter the class invoking method both mentioned just above, (HttpStatus.NOT_FOUND) which will return the standard error message "Not Found”.


------------------------------------------------ // ------------------------------------------------


Other Project Files: 


After dealing with the java packages, I will also mention three important files among several that are part of the project and that I needed to work with.

The first is the .sql file that inserts around 65 entities into our named and mapped table, passing nine items as values, including Long, Integer and String objects type that will enter and be processed as parameters by our class constructor method UserExploreOlympicGamesDataTable.

The second is the application.properties file which basically loads configurations to the database.

And last but not least the POM file that is generated by Spring Initialiser and which, among project general information, also brings the dependencies that we added and mentioned at the beginning of this report.


------------------------------------------------ // ------------------------------------------------

Description of a Solution Found: 


What I would like to highlight at this point is that I had a problem that took me a while to understand and resolve, despite it looking like a simple one. 

I did not get any error messages, I was able to run the project and access the h2 database API in the browser through the address http://localhost:8080/h2-console and connect normally, but I couldn't view my table, that is, the olympicGames table was not available although everything was ok. After analysing it for a long time, I realised that my POM file did not have the builder plugin configuration within the tags:

<build><plugins><plugin><configuration><image><builder>paketobuildpacks/builder-jammy-base:latest</builder>

When I added to the POM file the configuration of this builder, the table became available in the browser in the API h2 console, allowing me to perform the tests.


------------------------------------------------ // ------------------------------------------------


Performing Tests and Screenshots:


I started doing the tests in the browser within the h2 console, where I was able to display the table with all the information and make some specific data queries using simple commands in SQL language. Please see the screenshots below:

To continue testing the web application and interact with the table using the CRUD methods, I accessed the Postman software where I made some requests with the GET, GET by id, POST and DELETE method.

I was able to observe the return status codes for each request, including for the tests I carried out trying to access an entity that did not exist in the table. In this case with the GET by id method, passing an invalid id in the path, returned the expected standard message "Not Found” and status code 404.

In all other requests I received a successful response, being able to view the table data coming from the database in JSON format, such as code 200 in green confirming operation status "ok".

For requests with the GET by id and Delete methods, in addition to the standard path previously defined, I also passed the id of the entity to be consulted or deleted.

For the POST method, I just requested using the standard path and passed in the body in JSON format the information of the new entity to be inserted into the table without the id, which is automatically generated.

Please find below some screenshots of the process that I have just reported above.


------------------------------------------------ // ------------------------------------------------

Conclusion:


Something that was interesting to observe at the end of the process of building the REST API based Web Application was the connection between all the tools involved in the project.

How they communicate in a synchronised way. Insert or delete information from the table using CRUD methods in Postman Application, and at the same time be able to see the changes when I make a query for the same table using SQL language within the h2 console database API from the browser. 

The whole process shows a very consistent and unified operation of the different tools involved to manage remotely a database and gives a very good overview of how communication between the client side and the server side works across the web.

------------------------------------------------ // ------------------------------------------------


Screenshots:

1.package com.project.olympicGames -> contains OlympicGamesApplication.class:

![image](https://github.com/FE7R7/Java-SpringBoot-H2Database-OlympicGames/assets/147453330/34fda610-18ea-4042-ae8c-50333daf75bd)


2.package com.project.olympicGames.dto ->contains UserExploreOlympicGamesDataTable.calss: 

![image](https://github.com/FE7R7/Java-SpringBoot-H2Database-OlympicGames/assets/147453330/6c262109-7d72-4a64-b96c-2ff9555291f7)


3.package com.project.olympicGames.controller -> OlympicGamesController.class :

![image](https://github.com/FE7R7/Java-SpringBoot-H2Database-OlympicGames/assets/147453330/1d7faa14-9f19-42bb-880e-297a76a71319)


4.package com.project.olympicGames.repository -> interface UserOlympicGamesRepository:

![image](https://github.com/FE7R7/Java-SpringBoot-H2Database-OlympicGames/assets/147453330/8576ee89-8474-4dc1-b133-e16e105f3fd0)


5.package com.project.olympicGames.exception -> ResourceNotFoundException.class:

<img width="476" alt="image" src="https://github.com/FE7R7/Java-SpringBoot-H2Database-OlympicGames/assets/147453330/bbbf16ab-9f00-4d14-885b-fe5b6d23f5f2">


POM File:

![image](https://github.com/FE7R7/Java-SpringBoot-H2Database-OlympicGames/assets/147453330/e6ff828c-d2a5-4383-b5c5-1f3624158439)


POM File with  Builder Configuration:

![image](https://github.com/FE7R7/Java-SpringBoot-H2Database-OlympicGames/assets/147453330/cccd97b2-9fac-4f2e-bc3e-8073c80bfd1f)


SQL File:

![image](https://github.com/FE7R7/Java-SpringBoot-H2Database-OlympicGames/assets/147453330/1120bec7-6539-4de6-9783-bed4903f7782)


Browser H2 Console Tests:

![image](https://github.com/FE7R7/Java-SpringBoot-H2Database-OlympicGames/assets/147453330/ae376bb6-e8e2-408e-bb90-663acb565ec0)

![image](https://github.com/FE7R7/Java-SpringBoot-H2Database-OlympicGames/assets/147453330/a8e87086-d0b2-47f3-991a-13d80fc734bb)

![image](https://github.com/FE7R7/Java-SpringBoot-H2Database-OlympicGames/assets/147453330/b6199931-6a8c-4126-af5b-b7deea69dd67)


Postman Get Test:

![image](https://github.com/FE7R7/Java-SpringBoot-H2Database-OlympicGames/assets/147453330/8b8e47df-66d5-4a4d-abe1-280ec8e55ca2)


Postman Get by Id Test:

![image](https://github.com/FE7R7/Java-SpringBoot-H2Database-OlympicGames/assets/147453330/164b1e78-7bb9-4f62-b3e0-c25deffdeeed)


Postman Post Test:

![image](https://github.com/FE7R7/Java-SpringBoot-H2Database-OlympicGames/assets/147453330/f686d49a-929b-4b92-ab37-8819e8b56e47)


Postman Delete Test:

![image](https://github.com/FE7R7/Java-SpringBoot-H2Database-OlympicGames/assets/147453330/a775ecb5-b9fc-4b94-b378-5192543ded00)


Postman Not Found Test:

![image](https://github.com/FE7R7/Java-SpringBoot-H2Database-OlympicGames/assets/147453330/4de4305d-718e-4267-94ed-18a6ff3dc005)


Thank You...

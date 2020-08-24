# StudentPortalBackendSpring

Key points of learning:

1. SpringBoot
2. Spring mvc
3. Mongodb
4. Mockito
5. Maven

By using above 5 technologies Student portal is created. 

Functionality:
					1. Add the student data onto the Mongodb Server.
					2. Fetch the Data by applying the various filter on data.
		

Prerequistic to run the project run on the local machine.

	1. Install the Mongodb.
	
	2. Java  latest version ( can Modify the version in the pom.xml file)
	
	3. Install the postman in order to check whether the data can be storing on the server or not.
	i.e. Simple to play with the server.
	
	4. Can use any IDE i.e. VScode, intillej, etc.
	
		
How to run projects:

	1. Clone the Repository.
	
	2. Start the Mongo db server. 
	
	3. Configure the application.properties file if you want to change the Database name or port.
	
	4.   In the terminal type-->  "mvn spring-boot:run"     In order to run the project.
		  now at this stage you can use postaman in order to know the behaviour of the server.
	
	5. Have a look on the test folder and in order to run the all test cases in terminal type-->
	    "mvn test".

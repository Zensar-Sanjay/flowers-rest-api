# flowers-rest-api
# Java Technical Test
Create REST endpoints that reads the above JSON feed using HTTP.  The service should perform the following tasks:
Count endpoint
Tally the number of unique user Ids in the JSON and return in a JSON response.
Updated User List endpoint
Modify the 4th JSON array item, changing the title and body of the object to "1800Flowers".
Return the modified JSON object to the main Java class.
Return the modified JSON in the endpoint response.

#Project Introduction
This project is built using maven build tool and developed in Java 8 and Spring boot framework. It has the following features;
1) Java 8 features (Stream API, Lambda etc.)
2) Lombok tool (which minimized the boilerplate code)
3) Rest Template (is used to create applications that consume RESTful Web Services)
4) Swagger2 (is for documenting RESTful services)
5) Dev tools (used for development purpose to auto load the code changes without manual restart)

# Project Setup:
1.      Clone and checkout the repository from githum.com using eclipse from git hub - https://github.com/Zensar-Sanjay/flowers-rest-api.git
2.      Lombok Configuration into Eclipse
Since, the project uses Lombok tool, Lombok will work if we put Lombok on the project classpath. But to make it work with eclipse, we need to first do a couple of steps to install it in eclipse:
Please follow steps and guideline from below link
https://howtodoinjava.com/automation/lombok-eclipse-installation-examples/#lombok-eclipse
Or do the following
2.1.  Download Lombok Jar File
https://projectlombok.org/downloads/lombok.jar
2.2. Start Lombok Installation
Once the jar downloaded in Local repository, go to the jar location from command prompt and run the following command java -jar lombok-1.16.18.jar and we should be greeted by Lombok installation window provided by Lombok
2.3. Give Lombok Install Path
Now click on the “Specify Location” button and locate the eclipse.exe path under eclipse installation folder
2.4. Finish Lombok Installation
Now we need to finally install this by clicking the “Install/Update” button and we should finish installing Lombok in eclipse and we are ready to use its hidden power.
3.      Once the project is built and all dependencies are resolved
4.      Run the project
Either
Go to Eclipse -> Project -> Right click on class, FlowersRestApiApplication.java -> Run as Java Application
Or
using command line - java -jar flowers-rest-api-0.0.1-SNAPSHOT.jar (this jar is found in project/target folder)
It will start the spring context and start the application
 
5.      Open the browser of your choice and hit the URL
http://localhost:8080/flowers.rest.api/swagger-ui.html

6.      Now the swagger page is open, and it is ready for use

8.      Click on interface User Detail Rest Controller

9.      Click on interfaces getUniqueUserDetails  and "Try it out and Execute” 

10.     Click on interfaces getUniqueUserDetails  and "Try it out and Execute”

11.     Click on interface updateUserDetails and provide parameters (id =4 and value = “1800flowers”
        And  "Execute”
        
12.     Combination of the above parameters will give the output accordingly.

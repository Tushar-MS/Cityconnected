# Find if road route between origin to destination city present or not
<!-- UL -->
* Determine if two cities connected form origin to destination directly or via inter connected city. Program using spring boot and Java ( 1.8 or above)


### Build With
<!-- UL -->
[Java 1.8 or above] - Java Platform, Standard Edition Development Kit <br> https://www.oracle.com/java/technologies/javase-jdk11-downloads.html <br>
[ Eclipse ] - Java Integrated Development Environment ( IDE )<br> https://www.eclipse.org/downloads/ <br>
[ Maven 3.x] - Dependency Management perform uniform build system <br> https://maven.apache.org/index.html <br>
[ Git ] - Free and Open source distributed version control system <br> https://git-scm.com/ <br>
[ Postman ] - API Development Environment ( local testing) <br> https://www.postman.com/



### Rest API URI
<!-- UL -->
* URI Rest endpoint request parameter origin and destination 
if present should return yes else no.
* project context path is http://localhost:8080/connected?origin=City1&destination=City2
 check if City1 is connected to City2 or vice versa 

### Running the application locally
---
<!-- OL -->
1. Download the zip and unzip at project development folder
2. Open eclipse <br>
  2.1 - File import as existing Maven project
  2.2 - Navigate up to folder POM.xml for maven dependencies
  2.3 - Search file Application with @SpringBootApplication annotation as main starting file
  2.4 - Right click and run as java application   
3. Check console log as project run at Tomcat server on port 8080
4. The application will run at http://localhost:8080 or check http://localhost:8080/actuator/health
5. Application flow architecture 
<!-- UL -->
* Java Resource file -> Service file --> Helper file.

### packages
<!-- OL -->
resources - all rest client endpoint representation and its implementation 
service - basic entry point to call business login
Helper - files communication with data base and request builder and response processor

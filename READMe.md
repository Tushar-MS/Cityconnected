# Find if road route between origin to destination city present or not
<!-- UL -->
* Determine if two cities connected form origin to destination directly or via inter connected city. Program using spring boot and Java ( 1.8 or above)

<!-- Blockquote -->
### Prerequisite 
<!-- Links -->
[Java 1.8 or above]   https://www.oracle.com/java/technologies/javase-jdk11-downloads.html <br>
[ Eclipse ] https://www.eclipse.org/downloads/ <br>


---
<!-- UL -->
* URI Rest endpoint request paramete origin and destination 
if present should return yes else no.
* project context path is http://localhost:8080/connected?origin=City1&destination=City2
 check if City1 is connected to City2 or vice versa 

<!-- OL -->
1. Application flow 
<!-- UL -->
* Java Resource file -> Service file --> Helper file.
* Code coverage for each file
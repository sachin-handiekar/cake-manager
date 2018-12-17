Cake Manager Micro Service (fictitious)
=======================================

* By accessing the root of the server (/) it should be possible to list the cakes currently in the system.  This
 must be presented in an acceptable format for a human to read.

* It must be possible for a human to add a new cake to the server.

* By accessing an alternative endpoint (/cakes) with an appropriate client it must be possible to download a list of
 the cakes currently in the system as JSON data.
 
 Note: The Client has to send a header ( ACCEPT : APPLICATION/JSON ), as this is the way we can differentiate between a browser and a client.
 

* Accessing the /cakes endpoint with a web browser must show the human presentation of the list of cakes.

* The /cakes endpoint must also allow new cakes to be created.

The web application runs on port 8080, which can be changed by updating the property (server.port) in application.properties (src/main/resources)

* Steps to run the project

1. Build the Maven project

```mvn clean install```

2. Go to the target folder and run the cake-manager.jar

```java -jar cake-manager.jar```

3. The project can be access on http://localhost:8080/

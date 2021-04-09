# Docker Tutorial - Simple Spring Boot Rest Application with JPA/Hibernate/Liquibase and PostgreSQL DB

## Requirements:

* You will need Docker installed, you can get it here: https://docs.docker.com/get-docker/
* In case you wish to run the Spring Boot Application outside the Docker Container, you will need Java 11, you can get it here: https://adoptopenjdk.net/ 


## <a name="compile">Compiling the java project</a>

At the project root directory, build with maven:

	.\mvnw clean install

or if you prefer:

	mvn clean install
	

## Creating and starting the Docker containers

### Application + PostgreSQL DB 

#### Building the app_dockertutorial Docker image (This is optional, if you don't build it, the image will be download from Docker Hub)

At the project root directory, run the command:
 	
	docker build -t marcosaxe/app_dockertutorial ./
	
#### The Docker Composite

From the project root directory, navigate to the docker-compose folder:

	cd .\docker-compose-full\
	
Then run the command:

	docker-compose up --remove-orphans -d
	

### Only PostgreSQL DB exposing 5432 port (In case you want to run the Spring Boot Application outside the Docker Container)
 
 	
From the project root directory, navigate to the docker-compose folder:

	cd .\docker-compose-only-postgres\
	
Then run the command:

	docker-compose up --remove-orphans -d
	
This will start Docker running the PostgreSQL DB image.

In order to run the Spring Boot Application, you will need first to compile it, if you didn't yet. [See here how to compile](#compile).

#### Important Note:

When running the Spring Boot Application outside the Docker Container, you should first set the environment variables as follows:
	
	SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/postgres
	SPRING_DATASOURCE_USERNAME=postgres
	SPRING_DATASOURCE_PASSWORD=password

You now may run the Spring Boot Application, go to the project root directory, and type at a shell window:

	java -jar .\target\dockertutorial.jar

	
## Testing the application

### Swagger UI

You can use the Swagger UI, exposed at: http://localhost:8080/dockertutorial/swagger-ui.html

### Directly in the Browser 

This application exposes two rest end-points (GET verb), so simply using your favorite browser:

* The first end-point will return a json with data of all the planets in our Solar System: http://localhost:8080/dockertutorial/allPlanets
* The second end-point will return data from a Solar System planet of your choice:  http://localhost:8080/dockertutorial/planetByName/{name-of-the-solar-system-planet} (Where {name-of-the-solar-system-planet} should be replaced by something like Earth, Mars, Saturn, etc..)  

Solar System Data extracted from: https://nssdc.gsfc.nasa.gov/planetary/factsheet/



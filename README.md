 # Springboot Template Application
 
 
 
 
 
 #### Docker Build and Run
 
 ```sh
docker build -t springboot-app-java17 .
 ```
	 
	 
 ```sh
docker run -p 8080:8080 springboot-app-java17
 ```
 
 
####
 	# Use OpenJDK 17 as base image
	FROM openjdk:17
	
	# Set working directory
	WORKDIR /app
	
	# Copy the compiled JAR file into the container
	COPY target/spring-boot-template-0.0.1-SNAPSHOT.jar /app/spring-boot-template.jar
	
	
	# Expose the port that your Spring Boot application uses (default is 8080)
	EXPOSE 8080
	
	
	# Specify the command to run on container startup
	CMD ["java", "-jar", "spring-boot-template.jar"]
	
	

	
####
	# Use a base image with Maven and JDK installed
	FROM maven:3.8.5-openjdk-17-slim AS build
	
	# Set working directory
	WORKDIR /app
	    
	
	# Copy the Maven project descriptor files
	COPY pom.xml .
	
	
	# Copy the source code
	COPY src ./src
	
	
	# Build the application
	RUN mvn clean package -DskipTests
	
	
	# Use a smaller base image for runtime
	FROM openjdk:17-slim
	
	# Set the working directory inside the container
	WORKDIR /app
	
	
	# Copy the compiled JAR file from the build stage
	COPY --from=build /app/target/*.jar /app/application.jar
	
	# Expose any ports the app needs
	EXPOSE 8080
	
	# Specify the command to run on container startup
	CMD ["java", "-jar", "application.jar"]	
	
	
	
	
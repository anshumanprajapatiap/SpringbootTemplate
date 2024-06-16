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
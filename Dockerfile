# Use OpenJDK 17 as base image
FROM openjdk:17-jdk-slim

# Set working directory in container
WORKDIR /app

# Copy JAR file from target folder to container
COPY target/healthUpdate-0.0.1-SNAPSHOT.jar  app.jar

# Expose port 8080
EXPOSE 8081

# Run the Spring Boot JAR
ENTRYPOINT ["java", "-jar", "app.jar"]

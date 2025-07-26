#!/bin/bash

# Set JAVA_HOME if not already set
export JAVA_HOME=$JAVA_HOME

# Make mvnw executable
chmod +x mvnw

# Build the Spring Boot app
./mvnw clean package -DskipTests

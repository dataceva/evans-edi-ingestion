# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17 AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src
COPY lib ./lib

# Package the application
RUN mvn clean package

# Stage 2: Build the runtime image
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the packaged jar file from the builder stage
COPY --from=builder /app/target/evans-edi-adapter.jar app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]

# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17 AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src
COPY lib ./lib
COPY src/main/resources/aws_sftp_key .

# Package the application
RUN mvn clean package

# Stage 2: Build the runtime image
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the packaged jar file from the builder stage
COPY --from=builder /app/target/evans-edi-adapter.jar app.jar

RUN echo "$SSH_KEY"

# Create a directory for the SSH key
RUN mkdir -p /app/keys || true
COPY --from=builder /app/aws_sftp_key /app/keys/sftp_key

# Ensure the download directory exists
RUN mkdir -p /app/downloads

# Optionally set the default download path (if you want a default in the container)
ENV FILE_DOWNLOAD_PATH=/app/downloads

# Copy the SSH key from environment variable to a file
# The `echo` command writes the secret to a file
# RUN echo "$SSH_KEY" > /app/keys/sftp_key

# Set file permissions (important for SSH keys)
RUN chmod 600 /app/keys/sftp_key

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]

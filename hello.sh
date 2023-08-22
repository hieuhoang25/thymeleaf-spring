#!/bin/bash

# Build the Spring Boot project
./gradlew build

# Check if the build succeeded before running
if [ $? -eq 0 ]; then
  # Run the Spring Boot application
  java -jar build/libs/thymeleaf-spring-0.0.1-SNAPSHOT.jar

else
  echo "Build failed. Application will not be run."
fi
#chmod +x docker_run.sh -> to access .sh file
#./hello.sh -> run file
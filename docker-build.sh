#!/bin/bash

# Build a Docker image
docker build -t my-docker-image .

# Check if the build succeeded before running
if [ $? -eq 0 ]; then
  # Run a Docker container using the built image
  docker run -d --name my-container -p 8080:80 my-docker-image
else
  echo "Image build failed. Container will not be run."
fi
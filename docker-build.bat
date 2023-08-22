@echo off

REM Build a Docker image
docker build -t my-docker-image .

REM Check if the build succeeded before running
if %errorlevel% equ 0 (
  REM Run a Docker container using the built image
  docker run -d --name my-container -p 8080:80 my-docker-image
) else (
  echo Image build failed. Container will not be run.
)


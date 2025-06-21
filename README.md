# Task Manager Application with CI/CD Pipeline

This project is a simple Task Manager application built using Java Spring Boot and Thymeleaf, packaged with Docker and integrated with a CI/CD pipeline using GitHub Actions.

It demonstrates:

- Build automation
- Unit testing
- Linting/Static analysis
- Dockerization
- Multi-environment support (dev, prod)
- Artifact upload
- Clear CI workflow documentation

## Project Setup & Dependencies

### Prerequisites

- Java 17 (Temurin JDK 17)
- Maven 3.x
- Docker Desktop
- GitHub account

### Build locally

```bash
mvn clean install
```

### Run locally (without Docker)

```bash
mvn spring-boot:run
```

## Application Features

- Add and delete tasks
- Tasks stored in in-memory H2 database
- Environment-specific title (DEV / PROD)
- Responsive UI with Thymeleaf

## CI/CD Pipeline

Implemented with GitHub Actions (.github/workflows/ci.yml):

### Pipeline stages:

1. Build
    - Runs mvn clean install
    - Fails on build error
2. Unit Tests
    - Runs test suite (4+ tests)
    - Fails on test errors
3. Static Analysis
    - Runs SpotBugs plugin
    - Fails on critical issues
4. Docker Build & Upload
    - Builds Docker image
    - Uploads Docker image as artifact

## Multi-Environment Deployment

Two environments are supported:

| Environment | Trigger                               | Env File    |
|-------------|---------------------------------------|-------------|
| dev         | Automatically on push to develop      | .env.dev    |
| prod        | Manually via GitHub Actions "Run"     | .env.prod   |

Environment-specific behavior:

App title (APP_TITLE) changes based on .env.dev or .env.prod

Example:

```env
# .env.dev
APP_TITLE=Task Manager (DEV)

# .env.prod
APP_TITLE=Task Manager (PROD)
```

## Running Dockerized Application

### Build Docker image:

```bash
docker build -t task-manager:local .
```

### Run DEV environment:

```bash
docker run --env-file .env.dev -p 8080:8080 task-manager:local
```

### Run PROD environment (example port 8081):

```bash
docker run --env-file .env.prod -p 8081:8080 task-manager:local
```

## Branch Strategy

- main: Production-ready code
- develop: Active development and testing  
  → CI/CD automatically runs on develop

## How to Trigger Pipeline

- Push to develop: triggers full CI pipeline for DEV env
- Merge to main: triggers full CI pipeline for PROD env (manually trigger deploy)
- Manual trigger: via GitHub Actions UI (workflow_dispatch)

## Repository Hygiene

- .gitignore used — no unnecessary files committed
- Source code organized
- CI config stored in .github/workflows/
- Dockerfile provided
- README fully documents the project and pipeline

## Summary

This project meets the following assignment objectives:

- CI/CD pipeline with GitHub Actions
- Build, Test, Lint, Upload stages
- Multi-environment support (DEV/PROD)
- Dockerized application
- Clear documentation
- Organized Git repository with feature branch (develop)

## Notes

- This app uses a new project (not used in Assignment 1 or Lab 1-2)
- Screenshots provided separately (GitHub Actions run, Docker run, etc.)
- Jenkins was not used — GitHub Actions was selected

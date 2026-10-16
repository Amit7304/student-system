
# Student Management System

A full-stack Student Management System built as a learning project using Java, Spring Boot, and MySQL.

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- HTML, CSS and JavaScript (planned frontend)

## Features

- REST API for student records
- Create, read, update and delete operations
- MySQL database integration in progress
- Responsive frontend and deployment planned

## Current Status

This project is under development. The basic REST APIs have been practiced, and the application is being migrated from temporary in-memory storage to MySQL persistence.

## Local Setup

1. Install Java and MySQL.
2. Create a MySQL database named `student_db`.
3. Configure database credentials locally in `src/main/resources/application.properties`.
4. Run the application:

   ```bash
   ./mvnw spring-boot:run
   ```

5. The application will run at `http://localhost:8080`.

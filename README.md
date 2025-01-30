# Skydiving Logbook

This is my first Full Stack project. A project built with the guidance of Athens University of Economics and Business Coding Classes. 
A web application to log and manage your skydiving jumps, built using Java Spring Boot, Thymeleaf, and MySQL.

* * *

## Table of Contents

1.  [Overview](#overview)
2.  [Features](#features)
3.  [Technologies Used](#technologies-used)
4.  [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Database Setup](#database-setup)
    - [Installation](#installation)
5.  [Usage](#usage)

* * *

## Overview

The Skydiving Logbook allows users to record and view their skydiving jump details, such as jump type, dropzone, altitude, aircraft, freefall duration, and notes. The application supports user authentication and includes a detailed jump history for each user.

* * *

## Features

- User authentication and authorization.
- Log and view skydiving jump details.
- Predefined static data for aircraft, drop zones, and jump types
- Database persistence using MySQL
- Secure data handling with Spring Boot

* * *

## Technologies Used

- **Backend:** Java, Spring Boot (with Spring Data JPA, Spring Security, Thymeleaf integration)
- **Frontend:** Thymeleaf templates, HTML, CSS
- **Database:** MySQL
- **Build Tool:** Gradle
- **Deployment:** Apache Tomcat (local deployment)

* * *

## Getting Started

### Prerequisites

- Java 21 installed
- MySQL Server installed
- Gradle installed
- IntelliJ IDEA (Optional, for IDE-based setup)

### Database Setup

#### Option 1: Use the Predefined Test Database

To facilitate testing, the application is set up to connect to a MySQL database named `skydivelogbooktest`, using the credentials:

- **Username:** `sdtestuser1`
- **Password:** `1Te$tiNg123`

To use this database, connect to your MySQL server through the Linux Terminal, Windows Git Bash, or MySQL Workbench, and execute the following SQL script:

```sql
CREATE SCHEMA `skydivelogbooktest` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
CREATE USER 'sdtestuser1' IDENTIFIED BY '1Te$tiNg123';
GRANT ALL ON `skydivelogbooktest`.* TO 'sdtestuser1';
```

By using this setup, there is no need to modify the **DATABASE CONNECTION** settings in `application-dev.properties`.

#### Option 2: Create Your Own Database

If you prefer, you can create your own MySQL database and configure the connection settings. Update the following properties under the `## DATABASE CONNECTION ##` section in the `application-dev.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/YOUR_DATABASE_NAME
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

Ensure the database exists before running the application.

### Installation

#### Option 1: Using IntelliJ IDEA

1.  Clone the repository:

    ```sh
    git clone https://github.com/nikospavlopoulos/skydivinglogbook-spring-thymeleaf.git
    ```

2.  Open IntelliJ IDEA and select **Open Project**.

3.  Navigate to the cloned directory and open it.

4.  Wait for Gradle dependencies to sync.

5.  Run the `SkydivingLogbookApplication` class.


#### Option 2: Using Terminal with Gradle

1.  Clone the repository:

    ```sh
    git clone https://github.com/nikospavlopoulos/skydivinglogbook-spring-thymeleaf.git
    ```

2.  Navigate to the project directory:

    ```sh
    cd skydivinglogbook-spring-thymeleaf
    ```

3.  Build the project:

    ```sh
    ./gradlew build
    ```

4.  Run the application:

    ```sh
    ./gradlew bootRun
    ```


## Usage

### Database Initialization

Since the application uses some static data, the database must be properly initialized before using the web interface.

Under `application-dev.properties`, the following properties handle database initialization:

```properties
## 1st Run: COMMENT WHEN CREATE,
## 2nd Run: UNCOMMENT TO FIRST UPDATE
## AFTER 2nd Run & SUCCESSFUL UPDATE COMMENT AGAIN

#spring.sql.init.mode=always
#spring.sql.init.data-locations=classpath:sql/aircraft.sql, classpath:sql/dropzones.sql, classpath:sql/jumptypes.sql
```

#### Steps to Initialize the Database

1.  **First Run:** Keep the properties **commented** and start the application. This will create the database schema with the required tables.
2.  **Second Run:** Uncomment the `spring.sql.init.mode` and `spring.sql.init.data-locations` properties and restart the application. This will populate the tables with static data.
3.  **Final Step:** Once the static data is inserted, comment out these properties again and restart the application. The system is now ready for use.

## Open Your Browser and Enjoy the Application

Once set up, navigate to `http://localhost:8080/` in your web browser to start using the Skydiving Logbook Application.

##### It should look like this
![Skydiving Logbook](./src/main/resources/static/img/gif.gif)

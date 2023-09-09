# Medical Center API

This is the REST API from medical center application. Which was designed using Java / Maven / Spring Boot (version
3.1.3).

## Table of Contents

- [Introduction](#introduction)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Features](#features)

## Introduction

This project was designed to use as an API to UI from medical center System

Here is what this little application demonstrates:

* Full integration with the latest **Spring** Framework: inversion of control, dependency injection, etc.
* Packaging as a single jar with embedded container (tomcat 8): No need to install a container separately on the host
  just run using the ``java -jar`` command
* Writing a RESTful service using annotation: supports both XML and JSON request / response; simply use
  desired ``Accept`` header in your request
* Exception mapping from application exceptions to the right HTTP response with exception details in the body
* *Spring Data* Integration with JPA/Hibernate with just a few lines of configuration and familiar annotations.
* Automatic CRUD functionality against the data source using Spring *Repository* pattern

## Getting Started

### Prerequisites

* JDK 17
* Maven 3.x

### Installation

This application is packaged as a jar which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run
it using the ```java -jar``` command.

* Clone this repository
* Make sure you are using JDK 17 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the project by one of these two methods:

```
java -jar target/clinic-center-api-1.0.0.jar
or
mvn spring-boot:run
```

* Check the stdout or boot_api.log file to make sure no exceptions are thrown

Once the application runs, you should see something like this

```
2023-09-09T16:49:12.931+02:00  INFO 5318 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-09-09T16:49:12.945+02:00  INFO 5318 --- [  restartedMain] m.l.c.c.api.ClinicCenterApplication      : Started ClinicCenterApplication in 5.975 seconds (process running for 6.67)
```

## Features

Here are some endpoints you can call:

### Create a doctor resource

```
POST http://localhost:8080/v1/doctors
Accept: application/json
Content-Type: application/json

{
    "name": "Doctor test",
    "email": "doctor@email.com",
    "crm": "123457",
    "phone": "274201547",
    "speciality": "CARDIOLOGY",
    "address": {
        "description": "Avenue",
        "neighborhood": "Brussels city",
        "postalCode": "1200",
        "city": "Brussels city",
        "state": "Brussels",
        "number": "275",
        "notes": "Test create"
    }
}

RESPONSE: HTTP 201 (Created)
```

### Update a doctor resource

```
PUT /v1/doctors/1
Accept: application/json
Content-Type: application/json

{
    "name": "Patient test update",
    "phone": "987654321",
    "address": {
        "description": "Avenue",
        "neighborhood": "Wouwe Saint-lambert",
        "postalCode": "1200",
        "city": "Brussels city",
        "state": "Brussels",
        "number": "951",
        "notes": "Test update"
    }
}

RESPONSE: HTTP 204 (No Content)
```

### Deactivate a doctor resource

```
DELETE http://localhost:8080/v1/doctors/1
Accept: application/json
Content-Type: application/json

RESPONSE: HTTP 204 (No content)
```

### Retrieve a paginated list of doctors

```
http://localhost:8080/v1/doctors?page=0&size=10

Response: HTTP 200
Content: paginated list 
```

### Create a patient resource

```
POST http://localhost:8080/v1/patients
Accept: application/json
Content-Type: application/json

{
    "name": "Patient test",
    "email": "patient@email.com",
    "cpf": "12345678910",
    "phone": "123456789",
    "address": {
        "description": "Avenue",
        "neighborhood": "Wouwe Saint-lambert",
        "postalCode": "1200",
        "city": "Brussels city",
        "state": "Brussels",
        "number": "985",
        "notes": "Test create"
    }
}

RESPONSE: HTTP 201 (Created)
```

### Update a patient resource

```
PUT /v1/patients/1
Accept: application/json
Content-Type: application/json

{
    "name": "Patient patient",
    "phone": "123456789",
    "address": {
        "description": "Avenue",
        "neighborhood": "Wouwe Saint-pierre",
        "postalCode": "1100",
        "city": "Brussels city",
        "state": "Brussels",
        "number": "3254",
        "notes": "Test update"
    }
}

RESPONSE: HTTP 200 (No Content)
```

### Deactivate a patient resource

```
DELETE http://localhost:8080/v1/patients/1
Accept: application/json
Content-Type: application/json

RESPONSE: HTTP 204 (No content)
```

### Retrieve a paginated list of patients

```
http://localhost:8080/v1/patients?page=0&size=10

Response: HTTP 200
Content: paginated list 
```

#### Questions and Comments: anderson.lopes.2010@gmail.com
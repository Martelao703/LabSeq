# Labseq REST Service

## Overview

---
A Quarkus-based REST service that retrieves values from the Labseq sequence l(n):  

n=0 => l(0) = 0  
n=1 => l(1) = 1  
n=2 => l(2) = 0  
n=3 => l(3) = 1  
n>3 => l(n) = l(n-4) + l(n-3)

## Prerequisites

---
Before you begin, ensure you have the following installed on your machine:
- Java 17
- Maven
- Docker

## Build & Run  

---
To build and run the application, execute the following commands, in the project root directory:

1. **Build the application**:
```shell script
./mvnw clean package -DskipTests
```

2. **Build the Docker image**:
```shell script
docker build -t labseq-service .
```

3. **Run the container**:
```shell script
docker run --rm -p 8080:8080 labseq-service
```

## Instructions

---
Once the container is running, you can:

1. **Access the API**:  
Open your browser and navigate to `http://localhost:8080/labseq/{n}` where `{n}` is the index of the sequence’s value to return.   
**Note**: The value of `n` must be a non-negative integer.


2. **View the Swagger UI**:  
Open your browser and navigate to `http://localhost:8080/swagger` to explore the API documentation through the Swagger UI.


3. **Get OpenAPI documentation**:  
Open your browser and navigate to `http://localhost:8080/openapi` to download the API's OpenAPI documentation.

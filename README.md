# Labseq REST Service

## Overview

---
This repository contains a full‑stack implementation of the LabSeq exercise:
- Quarkus backend serving the LabSeq sequence via a REST API
- Angular frontend providing a simple web UI
- Docker Compose orchestration tying both services together
  
The LabSeq sequence itself `l(n)` is defined by:  

n=0 => l(0) = 0  
n=1 => l(1) = 1  
n=2 => l(2) = 0  
n=3 => l(3) = 1  
n>3 => l(n) = l(n-4) + l(n-3)

You enter a non‑negative integer `n` (0 ≤ n ≤ 300 000) and receive back `l(n)`.

## Prerequisites

---
Before you begin, ensure you have the following installed on your machine:
- Docker 
- Docker Compose

If you don't have these, install by downloading [Docker Desktop](https://www.docker.com/products/docker-desktop/)

## Getting Started

---

Navigate to a folder you wish to clone this repo into, and run the following command:
```shell script
$ git clone https://github.com/Martelao703/LabSeq.git
```
  
## Build & Run  

---
To build and run the application, execute the following command, in the repo root `LabSeq/`:
```shell script
docker-compose up --build
```

This will:
  - Start the backend on http://localhost:8080
  - Serve the frontend at http://localhost:4200

If you wish to stop and remove the container, execute the following command, in the repo root `LabSeq/`:
```shell script
docker-compose down
```

## Instructions

---
Once the container is running, you can:

- **Access the Frontend UI**:  
   - Open your browser to → [localhost](http://localhost:4200)
   - Enter an integer `n` (0–300 000) and click `Compute`
   - See `l(n)` displayed, or an error message if out of range

- **View the Swagger UI**:  
  - Interactive API docs → [Swagger](http://localhost:8080/swagger)


- **Get OpenAPI documentation**:  
  - OpenAPI API's documentation download → [OpenAPI](http://localhost:8080/openapi)

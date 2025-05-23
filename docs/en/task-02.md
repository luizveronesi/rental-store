# 📖 Activity 2: Spring Cloud Microservices Setup and Dockerization

In this activity, you will develop and configure essential Spring Cloud services for a microservices architecture and
dockerize the entire environment.

---

## 📌 Goals

You will:

- Set up and configure the following Spring Cloud services:
    - 📦 **Spring Cloud Config Server**
    - 📦 **Eureka Service Discovery**
    - 📦 **Spring Cloud Gateway**
- Configure the existing **Customer Module** to use the Gateway for routing.
- Dockerize all services (including the Customer Module, Config Server, Eureka Server, and Gateway).
- Provide clear installation instructions for **Docker Desktop for Windows**.

---

## 📌 Task Breakdown

### 1️⃣ Set Up Spring Cloud Config Server

- Create a new Spring Boot project with the **Spring Cloud Config Server** dependency.
- Configure the server to serve properties from a local `config-repo` directory or a Git repository.
- Expose the Config Server on a dedicated port (e.g., `8888`).
- Add appropriate `bootstrap.yml` / `application.yml` files for the server and clients.

---

### 2️⃣ Set Up Eureka Service Discovery

- Create a new Spring Boot project with the **Eureka Server** dependency.
- Configure it to run on a dedicated port (e.g., `8761`).
- Register all other services (Gateway and Customer Module) as Eureka clients.

---

### 3️⃣ Set Up Spring Cloud Gateway

- Create a Spring Boot project with the **Spring Cloud Gateway** dependency.
- Configure it to run on a dedicated port (e.g., `9090`).
- Configure routing to forward requests to the **Customer Module** and other future services.
- Optionally implement a basic route predicate and filter for demonstration.

---

### 4️⃣ Configure Customer Module to Use Gateway

- Modify the existing Customer Module's configuration to:
    - Register with Eureka.
    - Retrieve its properties from the Config Server.
    - Be accessible only via the Gateway.

---

### 5️⃣ Dockerize Everything

- Create `Dockerfile` for each service.
- Ensure services communicate by container names using Docker networks.
- Expose necessary ports to the host machine.

---

## 📌 Docker Desktop Installation (Windows)

If Docker is not installed, follow these steps:

1. Download Docker Desktop for Windows from the official site:
   👉 [https://www.docker.com/products/docker-desktop/](https://www.docker.com/products/docker-desktop/)

2. Run the installer and follow the on-screen instructions.

3. After installation:
    - Start **Docker Desktop**.
    - Ensure it runs successfully by executing:
      ```bash
      docker --version
      ```

4. (Optional) Docker Compose installation:
    - Create a `docker-compose.yml` to orchestrate the services together.

# 📚 BookStore – Spring Cloud Microservices Project

## 🚀 Project Overview

This project demonstrates a **Microservices Architecture using Spring Boot and Spring Cloud**.
The system represents a simple **online bookstore backend** where users can browse books and place orders.

The application is built using **multiple independent services** communicating through **REST APIs** and **Feign Client**, with **service discovery using Eureka** and **routing through API Gateway**.

---

# 🏗 Architecture

```
                 Client
                    │
                    ▼
            API Gateway (8090)
              /           \
             ▼             ▼
   Book Service (8081)   Order Service (8082)
                               │
                               ▼
                          Feign Client
                               │
                               ▼
                         Book Service
                               │
                               ▼
                          Oracle Database

All services register themselves in

               Eureka Server (8761)
```

---

# 🧩 Microservices

### 1️⃣ Eureka Server

Service registry used for **service discovery**.

**Port**

```
8761
```

Dashboard

```
http://localhost:8761
```

---

### 2️⃣ Book Service

Manages the **book catalog**.

**Responsibilities**

* Create book
* Get all books
* Get book by id
* Update book
* Delete book

**Port**

```
8081
```

Base API

```
/api/books
```

---

### 3️⃣ Order Service

Handles **customer orders**.

This service communicates with **Book Service using Feign Client** to fetch book price before creating an order.

**Port**

```
8082
```

Base API

```
/api/orders
```

---

### 4️⃣ API Gateway

Acts as the **single entry point** for all client requests.

**Port**

```
8090
```

Routes:

```
/api/books/**  → Book Service
/api/orders/** → Order Service
```

---

# ⚙️ Technologies Used

* Java 17 / 21
* Spring Boot
* Spring Cloud
* Spring Cloud Gateway
* Eureka Server
* OpenFeign
* Spring Data JPA
* Oracle Database
* Maven
* REST API
* Postman (for testing)

---

# 📦 Project Structure

```
BookStore-Microservices
│
├── BookStore-EurekaServer
│
├── BookStore-BookService
│
├── BookStore-OrderService
│
└── BookStore-ApiGateway
```

---

# ▶️ How To Run The Project

Start services in the following order.

### 1️⃣ Start Eureka Server

```
BookStoreEurekaServerApplication
```

Open dashboard:

```
http://localhost:8761
```

---

### 2️⃣ Start Book Service

```
BookStoreBookServiceApplication
```

---

### 3️⃣ Start Order Service

```
BookStoreOrderServiceApplication
```

---

### 4️⃣ Start API Gateway

```
ApiGatewayApplication
```

---

# 🧪 Testing APIs (Postman)

All APIs should be tested using **API Gateway**.

Base URL

```
http://localhost:8090
```

---

## 📘 Create Book

POST

```
/api/books
```

Body

```json
{
"title":"Clean Code",
"author":"Robert C Martin",
"isbn":"9780132350884",
"price":500,
"quantity":20,
"category":"Programming"
}
```

---

## 📘 Get All Books

GET

```
/api/books
```

---

## 📦 Place Order

POST

```
/api/orders
```

Body

```json
{
"bookId":1,
"customerName":"Alice",
"quantity":2
}
```

---

## 📦 Get Orders

GET

```
/api/orders
```

---

# 🔁 Order Creation Flow

```
Client
  ↓
API Gateway
  ↓
Order Service
  ↓
Feign Client
  ↓
Book Service
  ↓
Database
```

The **Order Service retrieves the book price from Book Service and calculates total order price before saving**.

---

# 📌 Key Microservice Concepts Used

* Service Discovery (Eureka)
* API Gateway Routing
* Inter-service communication (Feign Client)
* Microservices architecture
* Independent databases
* RESTful APIs

---

# 👨‍💻 Author

Deepak Kumar
BTech CSE – Full Stack Developer

GitHub

```
https://github.com/Deepak-Kr19
```

---

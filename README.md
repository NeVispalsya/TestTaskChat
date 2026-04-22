# Chat Test Task

## 📌 Overview

This project is a simple chat server built as a backend test task.
It provides an HTTP API for managing users, chats, and messages.

The application is implemented using **Java + Spring Boot + JPA + MySQL**.

---

## 🚀 Features

* Create users
* Create chats with multiple users
* Send messages in chats
* Get all chats for a specific user
* Get all messages in a chat

---

## 🧱 Tech Stack

* Java 17+
* Spring Boot
* Spring Data JPA
* MySQL
* Maven

---

## 🗄️ Data Model

### User

* `id` – unique identifier
* `username` – unique username
* `created_at` – creation timestamp

---

### Chat

* `id` – unique identifier
* `name` – unique chat name
* `users` – list of users (Many-to-Many)
* `created_at` – creation timestamp

---

### Message

* `id` – unique identifier
* `chat` – reference to chat
* `author` – message sender
* `text` – message content
* `created_at` – creation timestamp

---

## 📡 API Endpoints

All endpoints use **POST** requests with JSON body.

---

### ➕ Create User

```
POST /users/add
```

**Request:**

```json
{
  "username": "user_1"
}
```

**Response:**

* user ID

---

### 💬 Create Chat

```
POST /chats/add
```

**Request:**

```json
{
  "name": "chat_1",
  "users": [1, 2]
}
```

**Response:**

* chat ID

---

### ✉️ Send Message

```
POST /messages/add
```

**Request:**

```json
{
  "chat": 1,
  "author": 1,
  "text": "Hello"
}
```

**Response:**

* message ID

---

### 📋 Get User Chats

```
POST /chats/get
```

**Request:**

```json
{
  "user": 1
}
```

**Response:**

* list of chats sorted by last message time (descending)

---

### 📨 Get Chat Messages

```
POST /messages/get
```

**Request:**

```json
{
  "chat": 1
}
```

**Response:**

* list of messages sorted by creation time (ascending)

---

## ⚙️ Configuration

Example `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/
spring.datasource.username=
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
```

---

## ▶️ Running the Application

### 1. Clone repository

```
git clone <your-repo-url>
cd ChatTestTask
```

---

### 2. Run MySQL

Make sure you have a database named `chat`.

---

### 3. Start application

```
mvn spring-boot:run
```

Server will start on:

```
http://localhost:9000
```

---

## 🧪 Testing

The project includes integration tests using Spring Boot Test.

To run tests:

```
mvn test
```

---

## 🐳 (Optional) Docker

You can add Docker support and run with:

```
docker-compose up
```

---

## 📎 Notes

* Data is persisted in MySQL and survives server restarts
* Sorting and filtering are handled at the database level where possible
* Lazy loading is used for entity relationships

---

## 👨‍💻 Author

Test task implementation for backend internship.

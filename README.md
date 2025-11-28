# 🏦 Banking Management System (Full Stack)

This is a comprehensive Banking Management System built using a **Spring Boot** backend (REST API) and a **Java Swing** frontend.

The project demonstrates a modern full-stack architecture where the frontend (GUI) communicates with the backend server via HTTP requests to perform banking operations. It showcases the migration from a traditional JDBC application to a robust Spring Boot ecosystem.

---

## ✨ Features

* **Secure Authentication:** User login system connecting Frontend to Backend.
* **Account Management:** Create new accounts, check details.
* **Transactions:** Deposit and Withdraw money securely.
* **Balance Enquiry:** Real-time balance updates fetched from the server.
* **Database Integration:** Uses MySQL with Spring Data JPA for efficient data handling.
* **Clean Architecture:** Separation of concerns with Controller, Service, and Repository layers.

---

## 🛠️ Technology Stack

### **Backend (Server)**
* **Framework:** Spring Boot (3.x)
* **Language:** Java 21
* **Database:** MySQL
* **ORM:** Spring Data JPA (Hibernate)
* **Build Tool:** Maven
* **Dependencies:** Spring Web, Lombok, MySQL Connector

### **Frontend (Client)**
* **Framework:** Java Swing (AWT)
* **Communication:** REST API Consumption
* **Library:** Gson (for JSON parsing)

---

## 🚀 Getting Started

Since this is a Monorepo containing both Backend and Frontend, you need to set them up separately.

### 1. Prerequisites
* **Java JDK 17+** installed.
* **MySQL Server** running.
* **IntelliJ IDEA** (Recommended).

---

### 2. Database Setup 🗄️

Before running the backend, create the database in MySQL.

1.  Open MySQL Workbench/Terminal.
2.  Run this command:
    ```sql
    CREATE DATABASE YOUR_DB_NAME;
    ```

---

### 3. Backend Setup (Spring Boot) ⚙️

1.  Navigate to the **`Banking_Backend_SpringBoot`** folder.
2.  **Configure Database:**
    * Create a file named `application.properties` inside `src/main/resources/`.
    * Add your database credentials:
    ```properties
    spring.application.name=BankingApp
    spring.datasource.url=jdbc:mysql://localhost:3306/banking_db
    spring.datasource.username=root
    spring.datasource.password=YOUR_MYSQL_PASSWORD  <-- Change This
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```
3.  **Run the Server:**
    * Open `BankingSystemApplication.java`.
    * Click **Run**.
    * Ensure the console says: `Tomcat started on port 8080`.

---

### 4. Frontend Setup (Java Swing) 🖥️

1.  Navigate to the **`Banking_Frontend_SpringBoot`** folder.
2.  **Add Libraries (If not using Maven for Frontend):**
    * Ensure `gson-2.10.1.jar` and `jcalendar` are added to your project structure/classpath.
3.  **Configure API URL (Optional):**
    * If you have a `config.properties` or constant file, ensure it points to `http://localhost:8080`.
4.  **Run the App:**
    * Open `Login.java`.
    * Click **Run**.
    * The GUI window should appear.

---

## 📸 Project Structure

```text
Banking-App-Repo
│
├── Banking_Backend_SpringBoot/   (Server - Spring Boot)
│   ├── src/main/java/com/banking...
│   │   ├── controller/           (API Endpoints)
│   │   ├── service/              (Business Logic)
│   │   ├── repository/           (Database Queries)
│   │   └── entity/               (Data Models)
│   └── pom.xml
│
├── Banking_Frontend_SpringBoot/  (Client - Java Swing)
│   ├── src/bank/management/system...
│   │   ├── Login.java            (Entry Point)
│   │   └── ...
│   └── lib/                      (External Jars)
│
└── .gitignore                    (Global Ignore Rules)
```

## 📸 Screenshots



<img width="1108" height="618" alt="Screenshot 2025-11-05 151418" src="https://github.com/user-attachments/assets/99d6e130-0d90-4b7c-b6b4-92048e6593ac" />

<img width="1049" height="988" alt="Screenshot 2025-11-05 151436" src="https://github.com/user-attachments/assets/f98dee35-8ca7-4d0d-9bcc-cb4536c1c968" />

<img width="1895" height="1014" alt="Screenshot 2025-11-05 151515" src="https://github.com/user-attachments/assets/c8b495f1-eb80-4d52-9b3c-5898b3f734e8" />

<img width="482" height="734" alt="Screenshot 2025-11-29 000233" src="https://github.com/user-attachments/assets/0e509dd4-1257-404d-a42d-64b52730d58b" />

<img width="1629" height="633" alt="Screenshot 2025-11-29 000048" src="https://github.com/user-attachments/assets/cbfc1899-0178-42a3-8396-73196d625b62" />


---



## 🧑‍💻 Author



-   **[Uday Pratap Singh](https://github.com/udaypratapsingh4667)**

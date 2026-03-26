# Online Voting System

[![Java](https://img.shields.io/badge/Language-Java-blue)](https://www.java.com/)
[![MySQL](https://img.shields.io/badge/Database-MySQL-orange)](https://www.mysql.com/)

---

## **Description**
The **Online Voting System** is a **Java console-based application** that allows users to register voters and candidates, cast votes, and tally results securely. This project uses **Java JDBC** to connect to a **MySQL database**, making it easy to store, manage, and retrieve voter and candidate information.

It focuses on **backend development** with database connectivity and is designed to prevent duplicate voting while keeping the system simple and efficient.

---

## **Features**
- Register new voters and candidates.
- Cast votes with validation to prevent double voting.
- View all voters and their voting status.
- View all candidates and the number of votes they have received.
- Stores all data in a **MySQL database** (`voters`, `candidates`, `votes` tables).
- Fully console-based, easy to run and extend.

---

## **Technologies Used**
- **Java** (JDK 8 or above)
- **MySQL** (Database)
- **JDBC** (Java Database Connectivity API)

---

## **Database Schema**

**Database:** `votingdb`  

**Tables:**  

**voters**
| Column | Type | Description |
|--------|------|-------------|
| id     | INT AUTO_INCREMENT | Primary Key |
| name   | VARCHAR(100) | Voter name |
| voted  | BOOLEAN DEFAULT FALSE | Voting status |

**candidates**
| Column | Type | Description |
|--------|------|-------------|
| id     | INT AUTO_INCREMENT | Primary Key |
| name   | VARCHAR(100) | Candidate name |
| votes  | INT DEFAULT 0 | Total votes received |

**votes**
| Column | Type | Description |
|--------|------|-------------|
| id     | INT AUTO_INCREMENT | Primary Key |
| voter_id | INT | Foreign key to `voters` |
| candidate_id | INT | Foreign key to `candidates` |

---

## **How to Run**
1. Run the SQL script to create the database `votingdb` and the tables.  
2. Update **MySQL username and password** in `DBConnection.java`.  
3. Add **MySQL Connector JAR** to your project libraries.  
4. Open the project in **IntelliJ IDEA** or any Java IDE.  
5. Run `Main.java` to start the console application.  

---

## **Future Enhancements**
- Add **login system** for voters and admins.  
- Generate **voting reports** and statistics.  
- Integrate a **GUI interface** using JavaFX or Swing.  
- Add **multi-level elections** and regional voting.  

---

## **Author**
**Gokul G** – Java Developer & Student  

---

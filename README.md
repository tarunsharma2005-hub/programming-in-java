# Student & Course Management System

A command-line Java project for **Programming in Java (CSE2006)**.

## What the project does

The application manages student records and demonstrates Java fundamentals, OOP, exception handling, multithreading, collections, I/O, JDBC and JPA.

### Features
- Add student
- Display students
- Delete student
- Export CSV report
- Calculate average marks using a separate thread
- Store data using JDBC + H2
- Demonstrate JPA persistence

## Module coverage

| Course module | Project implementation |
|---|---|
| 1. Java Introduction & Flow Control | Variables, data types, operators, console I/O, if/else, switch, loops |
| 2. OOP | Class/object, constructor, methods, encapsulation, `this`, overriding, entity class |
| 3. Exceptions & Multithreading | Custom exception, try/catch, `Runnable`, `Thread`, `join`, interruption |
| 4. Lists & I/O Streams | `List`/`ArrayList`, String operations, `BufferedWriter`, CSV output |
| 5. JDBC & JPA | JDBC connection, PreparedStatement, ResultSet, CRUD-style operations, JPA entity/persistence |

## Requirements

- JDK 17+
- Maven 3.8+
- Internet connection on first run so Maven can download dependencies

## Command-line execution

From the project root:

```bash
mvn clean compile
mvn exec:java
```

The H2 database is created under `data/`.

## Menu

```text
1. Add Student
2. Display Students
3. Delete Student
4. Export CSV Report
5. Run Multithreading Report
6. Run JPA Demonstration
0. Exit
```

## GitHub submission checklist

- Repository visibility: **Public**
- `README.md` at repository root
- `pom.xml` at repository root
- `src/` folder uploaded
- Verify the project works from a fresh terminal
- Submit the repository root URL only, not `/tree/main` or `/blob/...`

## Before submitting

Replace project-owner/student details in the report with your own information. Run the project yourself and make any changes needed to reflect your actual work and understanding.

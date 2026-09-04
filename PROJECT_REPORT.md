# PROJECT REPORT

## Student & Course Management System

**Course:** Programming in Java (CSE2006)  
**Project Type:** Command-Line Application

---

## 1. Abstract

The Student & Course Management System is a Java command-line application developed to demonstrate practical use of concepts from the Programming in Java course. It stores student information, performs record operations, exports a report, demonstrates multithreading, and shows database access using JDBC and JPA.

## 2. Problem Statement

Managing student records manually can make storing, viewing and reporting information inconvenient. This project provides a simple command-line system for maintaining student records while applying Java programming concepts.

## 3. Objectives

- Apply Java syntax, variables, data types, operators and flow control.
- Apply object-oriented programming using classes, objects, constructors and encapsulation.
- Demonstrate exception handling.
- Demonstrate multithreading through background report generation.
- Use collections and Java I/O.
- Connect Java to a database using JDBC.
- Demonstrate persistence using JPA.

## 4. Functional Requirements

1. Add a student.
2. Validate marks and required fields.
3. Display stored students.
4. Delete a student using roll number.
5. Export student data to CSV.
6. Calculate average marks in a separate thread.
7. Persist a demonstration entity using JPA.

## 5. Technologies Used

- Java 17
- Maven
- H2 Database
- JDBC
- Jakarta Persistence API (JPA)
- Hibernate ORM
- Java Collections
- Java I/O
- Multithreading

## 6. System Design

```text
+---------------------------+
|      Main / CLI Menu      |
+-------------+-------------+
              |
      +-------+-------+
      |               |
      v               v
 Student Logic     Reports
      |               |
      v               v
StudentRepository  ReportTask
      |
   +--+----------------+
   |                   |
   v                   v
 JDBC / H2           CSV I/O
   |
   v
Students Table

Separate demonstration:
Main -> JpaDemo -> JPA/Hibernate -> H2
```

## 7. Module-wise Implementation

### Module 1: Java Introduction and Flow Control

The program uses variables, primitive data types, Strings, operators, console input/output, conditional validation, a switch-based menu and loops.

### Module 2: Object-Oriented Programming

`Student` is a class representing a real-world entity. It contains private fields, constructors, getters/setters and a grade method. JPA annotations also demonstrate an entity-based object model.

### Module 3: Exception Handling and Multithreading

`AppException` is a user-defined exception. Database and file operations handle checked exceptions and convert them into application-level messages. `ReportTask` implements `Runnable`, while `Thread` and `join()` demonstrate multithreading.

### Module 4: Collections and I/O

`ArrayList` is used while reading records from the database. CSV output is written with buffered character I/O.

### Module 5: JDBC and JPA

JDBC is used with `Connection`, `PreparedStatement` and `ResultSet`. JPA is demonstrated through the `Student` entity and `EntityManager`.

## 8. Database Design

| Column | Type | Description |
|---|---|---|
| id | BIGINT | Primary key |
| roll_no | VARCHAR | Unique roll number |
| name | VARCHAR | Student name |
| course | VARCHAR | Course name |
| marks | DOUBLE | Marks from 0 to 100 |

## 9. Sample Test Cases

| Test | Input/Action | Expected Result |
|---|---|---|
| Add valid student | Valid details | Student inserted |
| Invalid marks | -5 or 120 | Validation error |
| Blank name | Empty name | Validation error |
| Duplicate roll | Existing roll | Error message |
| Display | Option 2 | Students displayed |
| Delete | Existing roll | Student deleted |
| Export | Option 4 | CSV created |
| Thread report | Option 5 | Average printed by thread |
| JPA demo | Option 6 | Entity persistence demonstrated |

## 10. Execution

```bash
mvn clean compile
mvn exec:java
```

## 11. Expected Outcome

The application provides a working command-line student-management workflow and integrates major topics from the Programming in Java syllabus.

## 12. Limitations

- Command-line interface only.
- Simple student schema.
- JPA is included as a persistence demonstration rather than a complete second CRUD layer.

## 13. Future Enhancements

- Update student records.
- Search and sorting.
- Separate course/faculty tables.
- Complete JPA CRUD repository.
- Login and role management.
- Automated unit tests.

## 14. Conclusion

The project combines Java fundamentals, OOP, exception handling, multithreading, collections, I/O, JDBC and JPA into one practical command-line application.

## 15. References

1. Herbert Schildt, *Java: The Complete Reference*, 11th Edition.
2. Oracle Java documentation.
3. Jakarta Persistence API documentation.
4. Hibernate ORM documentation.

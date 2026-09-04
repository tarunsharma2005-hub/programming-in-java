package com.tarun.scms;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String rollNo;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String course;

    private double marks;

    public Student() {}

    public Student(String rollNo, String name, String course, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public Long getId() { return id; }
    public String getRollNo() { return rollNo; }
    public String getName() { return name; }
    public String getCourse() { return course; }
    public double getMarks() { return marks; }

    public void setRollNo(String rollNo) { this.rollNo = rollNo; }
    public void setName(String name) { this.name = name; }
    public void setCourse(String course) { this.course = course; }
    public void setMarks(double marks) { this.marks = marks; }

    public String grade() {
        if (marks >= 90) return "A+";
        if (marks >= 80) return "A";
        if (marks >= 70) return "B";
        if (marks >= 60) return "C";
        if (marks >= 50) return "D";
        return "F";
    }

    @Override
    public String toString() {
        return String.format("ID=%d | Roll=%s | Name=%s | Course=%s | Marks=%.2f | Grade=%s",
                id == null ? 0 : id, rollNo, name, course, marks, grade());
    }
}

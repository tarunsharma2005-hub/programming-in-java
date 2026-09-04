package com.tarun.scms;

import java.util.List;

public class ReportTask implements Runnable {
    private final List<Student> students;

    public ReportTask(List<Student> students) {
        this.students = students;
    }

    @Override
    public void run() {
        double average = students.stream()
                .mapToDouble(Student::getMarks)
                .average()
                .orElse(0.0);
        System.out.printf("%n[Background Thread] Students: %d | Average Marks: %.2f%n",
                students.size(), average);
    }
}

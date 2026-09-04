package com.tarun.scms;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    public void add(Student s) {
        String sql = "INSERT INTO students(roll_no,name,course,marks) VALUES(?,?,?,?)";
        try (Connection con = DatabaseManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, s.getRollNo());
            ps.setString(2, s.getName());
            ps.setString(3, s.getCourse());
            ps.setDouble(4, s.getMarks());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new AppException("Could not add student. Roll number may already exist.", e);
        }
    }

    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT id,roll_no,name,course,marks FROM students ORDER BY id";
        try (Connection con = DatabaseManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Student s = new Student(
                    rs.getString("roll_no"),
                    rs.getString("name"),
                    rs.getString("course"),
                    rs.getDouble("marks")
                );
                var idField = Student.class.getDeclaredField("id");
                idField.setAccessible(true);
                idField.set(s, rs.getLong("id"));
                list.add(s);
            }
        } catch (SQLException | ReflectiveOperationException e) {
            throw new AppException("Could not fetch students.", e);
        }
        return list;
    }

    public void deleteByRoll(String rollNo) {
        String sql = "DELETE FROM students WHERE roll_no=?";
        try (Connection con = DatabaseManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, rollNo);
            if (ps.executeUpdate() == 0) {
                throw new AppException("No student found with roll number: " + rollNo);
            }
        } catch (SQLException e) {
            throw new AppException("Could not delete student.", e);
        }
    }

    public void exportCsv(String fileName) {
        var students = findAll();
        try (var writer = new java.io.BufferedWriter(new java.io.FileWriter(fileName))) {
            writer.write("ID,Roll No,Name,Course,Marks,Grade");
            writer.newLine();
            for (Student s : students) {
                writer.write(String.format("%d,%s,%s,%s,%.2f,%s",
                        s.getId(), s.getRollNo(), s.getName(), s.getCourse(),
                        s.getMarks(), s.grade()));
                writer.newLine();
            }
        } catch (java.io.IOException e) {
            throw new AppException("Could not export report.", e);
        }
    }
}

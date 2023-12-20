package com.example.Atelier8.services;

import com.example.Atelier8.persistence.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(Long studentId);

    void saveStudent(Student student);

    void deleteStudent(Long studentId);
}
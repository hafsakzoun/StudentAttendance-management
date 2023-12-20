package com.example.Atelier8.services;

import com.example.Atelier8.persistence.StudentSeance;

import java.util.List;

public interface StudentSeanceService {
    List<StudentSeance> getAllStudentSeances();

    StudentSeance getStudentSeanceById(Long studentSeanceId);

    void saveStudentSeance(StudentSeance studentSeance);

    void deleteStudentSeance(Long studentSeanceId);
}
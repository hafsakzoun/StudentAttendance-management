package com.example.Atelier8.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Atelier8.persistence.StudentSeance;
import com.example.Atelier8.repository.StudentSeanceRepo;

import java.util.List;

@Service
public class StudentSeanceServiceImp implements StudentSeanceService {

    private final StudentSeanceRepo studentSeanceRepo;

    @Autowired
    public StudentSeanceServiceImp(StudentSeanceRepo studentSeanceRepo) {
        this.studentSeanceRepo = studentSeanceRepo;
    }

    @Override
    public List<StudentSeance> getAllStudentSeances() {
        return studentSeanceRepo.findAll();
    }

    @Override
    public StudentSeance getStudentSeanceById(Long studentSeanceId) {
        return studentSeanceRepo.findById(studentSeanceId).orElse(null);
    }

    @Override
    public void saveStudentSeance(StudentSeance studentSeance) {
        studentSeanceRepo.save(studentSeance);
    }

    @Override
    public void deleteStudentSeance(Long studentSeanceId) {
        studentSeanceRepo.deleteById(studentSeanceId);
    }
}
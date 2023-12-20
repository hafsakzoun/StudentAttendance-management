package com.example.Atelier8.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Atelier8.persistence.Student;
import com.example.Atelier8.repository.StudentRepo;

import java.util.List;

@Service
public class StudentServiceImpl implements  StudentService{
    private final StudentRepo studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepository) {

        this.studentRepository = studentRepository;
    }
    @Override
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long studentId) {

        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}

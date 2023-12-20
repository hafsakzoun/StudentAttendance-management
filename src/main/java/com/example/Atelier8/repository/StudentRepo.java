package com.example.Atelier8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Atelier8.persistence.Student;

@Repository
public interface StudentRepo extends  JpaRepository<Student,Long>{
}

package com.example.Atelier8.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "student_seance")
public class StudentSeance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentSeance_id", nullable = false)
    private Long studentSeanceId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "seance_id")
    private Seance seance;

    @Enumerated(EnumType.STRING)
    private AttendanceStatus attendanceStatus;

    // Constructors, getters, and setters can be added as needed
}

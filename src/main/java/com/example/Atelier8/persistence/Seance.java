package com.example.Atelier8.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "seance")
public class Seance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seance_id", nullable = false)
    private Long seanceId;

    @Column(name = "date_seance", nullable = true)
    private LocalDate date;

    @Column(name = "duration", nullable = true, length = 255)
    private String duration;

    @Column(name = "course", nullable = true, length = 255)
    private String course;

    @ManyToMany(mappedBy = "seances")
    private Set<Student> students = new HashSet<>();

    @Override
    public String toString() {
        return "Seance{" +
                "Seance Id=" + seanceId +
                ", Date Seance ='" + date + '\'' +
                ", duration=" + duration +
                ", course=" + course +
                '}';
    }
}

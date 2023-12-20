package com.example.Atelier8.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false)
    private Long student_id;

    @Column(name = "full_name", nullable = true, length = 255)
    private String full_name;

    @Column(name = "age", nullable = true)
    private Integer age;

    @ManyToMany
    @JoinTable(
            name = "student_seance",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "seance_id")
    )
    private Set<Seance> seances = new HashSet<>();

    @Override
    public String toString() {
        return "Student{" +
                "student Id=" + student_id +
                ", full Name='" + full_name + '\'' +
                ", age=" + age +
                '}';
    }
}

package com.example.Atelier8.services;

import com.example.Atelier8.persistence.Seance;

import java.util.List;

public interface SeanceService {
    List<Seance> getAllSeances();

    Seance getSeanceById(Long seanceId);

    void saveSeance(Seance seance);

    void deleteSeance(Long seanceId);
}
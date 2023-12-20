package com.example.Atelier8.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Atelier8.persistence.Seance;
import com.example.Atelier8.repository.SeanceRepo;


import java.util.List;

@Service
public class SeanceServiceImpl implements SeanceService {

    private final SeanceRepo SeanceRepository;

    @Autowired
    public SeanceServiceImpl(SeanceRepo SeanceRepository) {

        this.SeanceRepository = SeanceRepository;
    }
    @Override
    public List<Seance> getAllSeances() {
        return SeanceRepository.findAll();
    }

    @Override
    public Seance getSeanceById(Long seanceId) {
        return SeanceRepository.findById(seanceId).orElse(null);
    }

    @Override
    public void saveSeance(Seance seance) {
        SeanceRepository.save(seance);
    }

    @Override
    public void deleteSeance(Long seanceId) {
        SeanceRepository.deleteById(seanceId);
    }
}

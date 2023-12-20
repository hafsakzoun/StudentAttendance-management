package com.example.Atelier8.controller;
import com.example.Atelier8.persistence.Seance;
import com.example.Atelier8.services.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/seances")
public class SeanceController {

    @Autowired
    private SeanceService seanceService;

    @GetMapping
    public String getAllSeances(Model model) {
        List<Seance> seances = seanceService.getAllSeances();
        model.addAttribute("seances", seances);
        return "SeanceList";
    }

    @GetMapping("/{seanceId}")
    public String getSeanceById(@PathVariable Long seanceId, Model model) {
        Seance seance = seanceService.getSeanceById(seanceId);
        model.addAttribute("seance", seance);
        return "seanceAttendance";
    }

    @GetMapping("/add")
    public String showAddSeanceForm(Model model) {
        model.addAttribute("seance", new Seance());
        model.addAttribute("action", "/seances/add");
        return "addSeance";
    }
    @GetMapping("/edit/{id}")
    public String showEditSeanceForm(@PathVariable Long id, Model model) {
        Seance seance = seanceService.getSeanceById(id);
        model.addAttribute("seance", seance);
        model.addAttribute("action", "/seances/edit/" + id);  // URL for form submission
        return "addSeance";
    }
    @PostMapping({"/add", "/edit/{id}"})
    public String processSeanceForm(@ModelAttribute Seance seance) {
        seanceService.saveSeance(seance);
        return "redirect:/seances";
    }

    @GetMapping("/{seanceId}/delete")
    public String deleteSeance(@PathVariable Long seanceId) {
        seanceService.deleteSeance(seanceId);
        return "redirect:/seances";
    }
}

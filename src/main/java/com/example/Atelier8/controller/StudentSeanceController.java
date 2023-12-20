package com.example.Atelier8.controller;
import com.example.Atelier8.persistence.StudentSeance;
import com.example.Atelier8.services.StudentSeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student-seances")
public class StudentSeanceController {

    @Autowired
    private StudentSeanceService studentSeanceService;

    @GetMapping
    public String getAllStudentSeances(Model model) {
        List<StudentSeance> studentSeances = studentSeanceService.getAllStudentSeances();
        model.addAttribute("studentSeances", studentSeances);
        return "studentSeance/list"; // Assuming you have a Thymeleaf template named "list.html"
    }

    @GetMapping("/{studentSeanceId}")
    public String getStudentSeanceById(@PathVariable Long studentSeanceId, Model model) {
        StudentSeance studentSeance = studentSeanceService.getStudentSeanceById(studentSeanceId);
        model.addAttribute("studentSeance", studentSeance);
        return "studentSeance/details"; // Assuming you have a Thymeleaf template named "details.html"
    }

    @GetMapping("/add")
    public String showAddStudentSeanceForm(Model model) {
        model.addAttribute("studentSeance", new StudentSeance());
        return "studentSeance/add"; // Assuming you have a Thymeleaf template named "add.html"
    }

    @PostMapping("/add")
    public String addStudentSeance(@ModelAttribute StudentSeance studentSeance) {
        studentSeanceService.saveStudentSeance(studentSeance);
        return "redirect:/student-seances";
    }

    @GetMapping("/{studentSeanceId}/delete")
    public String deleteStudentSeance(@PathVariable Long studentSeanceId) {
        studentSeanceService.deleteStudentSeance(studentSeanceId);
        return "redirect:/student-seances";
    }
}

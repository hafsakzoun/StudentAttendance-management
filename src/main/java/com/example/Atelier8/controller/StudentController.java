package com.example.Atelier8.controller;
import com.example.Atelier8.persistence.Student;
import com.example.Atelier8.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "Studentlist"; // Assuming your Thymeleaf template is named "Studentlist.html"
    }

    // Show form for adding a new student
    @GetMapping("/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("action", "/students/add");  // URL for form submission
        return "addStudent";
    }

    // Show form for editing an existing student
    @GetMapping("/edit/{id}")
    public String showEditStudentForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        model.addAttribute("action", "/students/edit/" + id);  // URL for form submission
        return "addStudent"; // Assuming your Thymeleaf template is named "addStudent.html"
    }

    // Handle form submission for both add and edit
    @PostMapping({"/add", "/edit/{id}"})
    public String processStudentForm(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/{studentId}/delete")
    public String deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }
}

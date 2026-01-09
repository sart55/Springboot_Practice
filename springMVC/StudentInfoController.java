package com.example.springmvc.controller;
import jakarta.validation.Valid;
import com.example.springmvc.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class StudentInfoController {

    @GetMapping("/studentinfo")
    public String studentInfo(@Valid @ModelAttribute("student") Student theStudent, BindingResult theBindingResult){
        if (theBindingResult.hasErrors()) {
            return "home";
        }

        return "studentinfo";
    }

}

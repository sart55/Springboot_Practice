package com.example.springmvc.controller;

import com.example.springmvc.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @Value("${subjects}")
    List<String> subjects = new ArrayList<>();

    @GetMapping("/home")
    public String home(Model m){
        m.addAttribute("student", new Student());
        m.addAttribute("subjects",subjects);
        return "home.html";
    }

}

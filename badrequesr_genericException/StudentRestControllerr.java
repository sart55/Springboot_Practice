package com.example.getmappingObject.restController;

import com.example.getmappingObject.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("/api")
public class StudentRestControllerr{

    List<Student> lis = new ArrayList<>();

    @PostConstruct
    public void createlist(){
        Student s1 = new Student("Sarthak","Gangurde");
        Student s2 = new Student("Rohan","More");
        Student s3 = new Student("Yash","Shete");


        lis.add(s1);
        lis.add(s2);
        lis.add(s3);

    }


    @GetMapping("/students")
    public List<Student> ret() {

        return lis;
    }


    @GetMapping("/students/{studentId}")
    public Student ret(@PathVariable int studentId){

        if(studentId > lis.size() || studentId < 0){
            throw new CustomException("Student ID not found : "+studentId);
        }
        return lis.get(studentId);
    }




}

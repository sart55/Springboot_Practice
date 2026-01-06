package com.spring.example.cruddemo.DAO;
import com.spring.example.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    Void save(Student theStudent);
    Student retrive(int ID);
    List<Student> findAll();
    Student update(int ID);
    Void remove(int ID);
    Void removeAll();
}

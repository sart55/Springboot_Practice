package com.employee_project.employee_project.dao;

import com.employee_project.employee_project.EmployeeProjectApplication;
import com.employee_project.employee_project.entity.Employee;
import org.springframework.context.annotation.Bean;

import java.util.List;


public interface EmployeeDAO {
    public List<Employee> findAll();
    public Employee save(Employee e);
    public void deleteById(int ID);
    public Employee findByID(int ID);
    public Employee updateEmp(Employee emp);
}

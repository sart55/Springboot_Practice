package com.employee_project.employee_project.service;

import com.employee_project.employee_project.entity.Employee;
import java.util.List;

public interface ServiceInter {

    public List<Employee> findAll();
    public Employee save(Employee e);
    public void deleteById(int ID);
    public Employee findByID(int ID);
    public Employee update(Employee emp);
}

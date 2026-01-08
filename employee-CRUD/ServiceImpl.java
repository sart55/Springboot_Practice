package com.employee_project.employee_project.service;

import com.employee_project.employee_project.dao.EmployeeDAO;
import com.employee_project.employee_project.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceImpl implements ServiceInter{

    private EmployeeDAO ed;

    public ServiceImpl(EmployeeDAO employeeDAO){
        ed = employeeDAO;
    }


    @Override
    public List<Employee> findAll() {
        return ed.findAll();
    }

    @Override
    @Transactional
    public Employee save(Employee e) {
        e.setID(0);
        return ed.save(e);
    }

    @Override
    public void deleteById(int ID) {
        ed.deleteById(ID);
    }

    @Override
    public Employee findByID(int ID) {
        return ed.findByID(ID);
    }

    @Override
    @Transactional
    public Employee update(Employee emp) {
        return ed.updateEmp(emp);
    }
}

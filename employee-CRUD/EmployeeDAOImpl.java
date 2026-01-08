package com.employee_project.employee_project.dao;

import com.employee_project.employee_project.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager en;

    public EmployeeDAOImpl(EntityManager en){
        this.en = en;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> query = en.createQuery("From Employee",Employee.class);
        List<Employee> list = query.getResultList();

        return list;
    }

    @Override
    public Employee save(Employee e) {
        Employee ret = en.merge(e);
        return ret;
    }

    @Override
    public void deleteById(int ID) {
        Employee emp = en.find(Employee.class,ID);
        en.remove(emp);
    }

    @Override
    public Employee findByID(int ID) {
        Employee ret = en.find(Employee.class,ID);
        return ret;
    }

    @Override
    public Employee updateEmp(Employee emp) {
        return en.merge(emp);
    }
}

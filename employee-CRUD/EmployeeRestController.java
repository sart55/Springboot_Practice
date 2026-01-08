package com.employee_project.employee_project.rest;

import com.employee_project.employee_project.dao.EmployeeDAO;
import com.employee_project.employee_project.entity.Employee;
import com.employee_project.employee_project.service.ServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private ServiceInter si;


    public EmployeeRestController(ServiceInter serviceInter){
        si = serviceInter;
    }

    @GetMapping("/employee")
    public List<Employee> get(){
        return si.findAll();
    }

    @GetMapping("/employee/{EmployeeID}")
    public Employee ret(@PathVariable int EmployeeID){
        return si.findByID(EmployeeID);
    }

    @PostMapping("/employee")
    public Employee save(@RequestBody Employee e){
        return si.save(e);
    }

    @PutMapping("/employee")
    public Employee update(@RequestBody Employee e){
        return si.update(e);
    }

    @Transactional
    @DeleteMapping ("/employee/{id}")
    public String delete(@PathVariable int id){
         si.deleteById(id);
         return "Id "+ id + " deleted";
    }



}

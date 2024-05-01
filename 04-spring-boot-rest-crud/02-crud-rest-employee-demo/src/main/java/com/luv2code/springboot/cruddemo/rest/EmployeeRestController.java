package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.dao.employee.EmployeeDOA;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeDOA employeeDOA;
    @Autowired
    public  EmployeeRestController(EmployeeDOA employeeDOA){
        this.employeeDOA=employeeDOA;
    }
    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        return  this.employeeDOA.findAll();
    }

}

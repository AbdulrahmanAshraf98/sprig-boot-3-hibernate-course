package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.dao.employee.EmployeeDOA;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.employee.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeServiceInterface employeeService;
    @Autowired
    public  EmployeeRestController(EmployeeServiceInterface employeeService){
        this.employeeService=employeeService;
    }
    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        return  this.employeeService.findAll();
    }
    @GetMapping("/employee/{id}")
    public Employee getSingleEmployee(@PathVariable long id) throws  RuntimeException{
        Employee employee=  this.employeeService.findById(id);
        if(employee==null){
            System.out.println(id);
            throw  new RuntimeException("Employee id :"+id+ "not found ");
        }
        return  employee;
    }
    @PostMapping("/employee")
    public  Employee createEmployee(@RequestBody Employee employee){
    employee.setId(0L);
    return  this.employeeService.save(employee);
    }
    @DeleteMapping("/employee/{id}")
    public  boolean deleteEmployee(@PathVariable long id ){
        this.employeeService.deleteById(id);
        return true;
    }

}

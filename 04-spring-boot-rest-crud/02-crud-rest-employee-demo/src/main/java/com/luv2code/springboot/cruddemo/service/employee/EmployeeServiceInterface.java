package com.luv2code.springboot.cruddemo.service.employee;

import com.luv2code.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeServiceInterface {
    List<Employee> findAll();
    Employee findById(long id);
    Employee save(Employee employee);
    void deleteById(long id );
}

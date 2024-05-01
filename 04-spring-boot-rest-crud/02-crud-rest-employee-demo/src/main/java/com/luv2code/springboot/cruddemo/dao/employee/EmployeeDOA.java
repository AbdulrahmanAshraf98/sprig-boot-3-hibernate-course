package com.luv2code.springboot.cruddemo.dao.employee;

import com.luv2code.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDOA {
    List<Employee> findAll();
    Employee findById(long id );
    Employee save(Employee employee);
    void deleteById(long id );
}

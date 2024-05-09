package com.luv2code.validation.service;

import com.luv2code.validation.dtos.EmployeeDTO;
import com.luv2code.validation.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee getById(long id);
    Employee create(EmployeeDTO employeeDTO);
    Employee update(long id , EmployeeDTO employeeDTO);
    void  delete(long id);
}

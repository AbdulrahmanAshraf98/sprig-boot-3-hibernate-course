package com.luv2code.springboot.cruddemo.service.employee;

import com.luv2code.springboot.cruddemo.dao.employee.EmployeeDOA;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeService implements  EmployeeServiceInterface {
    private final EmployeeDOA employeeDOA;
    @Autowired
    public  EmployeeService(EmployeeDOA employeeDOA){
        this.employeeDOA=employeeDOA;
    }
    @Override
    public List<Employee> findAll() {
        return this.employeeDOA.findAll();
    }

    @Override
    public Employee findById(long id) {
        return this.employeeDOA.findById(id);
    }
    @Transactional
    @Override
    public Employee save(Employee employee) {
        return this.employeeDOA.save(employee);
    }
    @Transactional
    @Override
    public void deleteById(long id) {
        this.employeeDOA.deleteById(id);
    }
}

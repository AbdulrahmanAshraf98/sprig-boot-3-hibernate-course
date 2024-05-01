package com.luv2code.springboot.cruddemo.service.employee;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements  EmployeeServiceInterface {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public  EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findById(long id) {
        Optional<Employee> result= this.employeeRepository.findById(id);
        return result.orElse(null);
    }
    @Transactional
    @Override
    public Employee save(Employee employee) {
        return this.employeeRepository.save(employee);
    }
    @Transactional
    @Override
    public void deleteById(long id) {

        this.employeeRepository.deleteById(id);
    }

}

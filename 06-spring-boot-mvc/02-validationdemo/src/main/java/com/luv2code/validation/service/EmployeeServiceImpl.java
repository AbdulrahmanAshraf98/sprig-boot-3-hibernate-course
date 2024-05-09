package com.luv2code.validation.service;

import com.luv2code.validation.doa.EmployeeRepository;
import com.luv2code.validation.dtos.EmployeeDTO;
import com.luv2code.validation.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements  EmployeeService {
      private final  EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getById(long id) {
        return this.employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee ID: " + id));

    }
    @Transactional
    @Override
    public Employee create(EmployeeDTO employeeDTO) {
        Employee employee =new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());

        return this.employeeRepository.save(employee);
    }
    @Transactional
    @Override
    public Employee update(long id, EmployeeDTO employeeDTO) {
        Employee employee = getById(id);
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        return employeeRepository.save(employee);

    }
    @Transactional
    @Override
    public void delete(long id) {
        Employee employee = getById(id);
        employeeRepository.delete(employee);
    }
}

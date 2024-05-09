package com.luv2code.validation.doa;

import com.luv2code.validation.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Long> {
    List<Employee> findAllByOrderByIdDesc();
}

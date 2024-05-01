package com.luv2code.springboot.cruddemo.dao.employee;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDOAImpl implements  EmployeeDOA {
    private EntityManager entityManager;
    @Autowired
    public  EmployeeDOAImpl(EntityManager entityManager){
            this.entityManager=entityManager;
    }
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query=this.entityManager.createQuery("FROM Employee",Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(long id) {
        return this.entityManager.find(Employee.class,id);
    }

    @Override
    public Employee save(Employee employee) {
        return this.entityManager.merge(employee);
    }

    @Override
    public void deleteById(long id) {
        Employee employee= this.findById(id);
        this.entityManager.remove(employee);
    }
}

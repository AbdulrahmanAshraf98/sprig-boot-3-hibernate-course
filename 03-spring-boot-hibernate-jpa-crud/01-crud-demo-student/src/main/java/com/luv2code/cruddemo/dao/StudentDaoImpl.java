package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDaoImpl implements  StudentDAO{
   final private EntityManager entityManager;
    public  StudentDaoImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(Student student) {
    this.entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return this.entityManager.find(Student.class,id);
    }

}

package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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
    public Student findById(Integer id) {
        return this.entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query =this.entityManager.createQuery("FROM Student ORDER BY id DESC",Student.class);
        return  query.getResultList();
    }

    @Override
    public List<Student> findAllBy(Map<String, Object> conditions) {
        TypedQuery<Student> query;
        if(conditions.isEmpty()){
            query=this.entityManager.createQuery("FROM Student ORDER BY id DESC",Student.class);
            return query.getResultList();
        }
        StringBuilder jpql = new StringBuilder("FROM Student WHERE 1=1");
        for(String key: conditions.keySet()){
            jpql.append(" AND ").append(key).append(" = :").append(key);
        }
         query=this.entityManager.createQuery(jpql.toString(),Student.class);
         for (String key: conditions.keySet()){
             query.setParameter(key,conditions.get(key));
         }
         return  query.getResultList();

    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query =this.entityManager.createQuery("FROM Student WHERE lastName=:lastName",Student.class);
        query.setParameter("lastName",lastName);
        return  query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        this.entityManager.merge(student);
    }

}

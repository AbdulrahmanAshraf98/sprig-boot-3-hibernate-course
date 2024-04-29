package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentDAO {
    void  save(Student student);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findAllBy(Map<String,Object>conditions);

    List<Student> findByLastName(String lastName);
}

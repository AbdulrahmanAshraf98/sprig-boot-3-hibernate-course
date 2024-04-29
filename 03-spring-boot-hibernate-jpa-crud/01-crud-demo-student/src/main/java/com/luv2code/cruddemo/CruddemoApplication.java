package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
			createStudent(studentDAO);
			List<Student> allStudent=studentDAO.findAll();
			for (Student student:allStudent){
				System.out.println(student.toString());
			}
			Student firstStudent= studentDAO.findById(1);
			System.out.println("first student : "+firstStudent.toString());
			Map<String, Object> searchConditions = new HashMap<>();
			searchConditions.put("firstName", "Ahmed");
			searchConditions.put("email", "abdo@gmail.com");
			allStudent=studentDAO.findAllBy(searchConditions);
			for (Student student:allStudent){
				System.out.println(student.toString());
			}
		};
	}
	public static void createStudent(StudentDAO studentDAO){
		Student student=new Student("ehab ","ashraf","abdo@gmail.com");
		studentDAO.save(student);
		System.out.println("created student :"+student.toString());
	}
}

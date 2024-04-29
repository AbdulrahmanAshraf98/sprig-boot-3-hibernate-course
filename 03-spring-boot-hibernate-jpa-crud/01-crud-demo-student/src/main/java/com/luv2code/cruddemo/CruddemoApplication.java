package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
		};
	}
	public static void createStudent(StudentDAO studentDAO){
		Student student=new Student("abdo","ashraf","abdo@gmail.com");
		studentDAO.save(student);
		System.out.println("created student :"+student.toString());
	}
}

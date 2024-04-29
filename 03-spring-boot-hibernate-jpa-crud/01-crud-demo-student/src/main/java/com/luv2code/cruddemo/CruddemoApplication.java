package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
			createStudent(studentDAO);
			Student student= studentDAO.findById(1);
			System.out.println(student.toString());
		};
	}
	public static void createStudent(StudentDAO studentDAO){
		Student student=new Student("abdo","ashraf","abdo@gmail.com");
		studentDAO.save(student);
		System.out.println(student.toString());
	}
}
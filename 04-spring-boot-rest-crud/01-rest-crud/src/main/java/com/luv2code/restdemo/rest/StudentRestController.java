package com.luv2code.restdemo.rest;

import com.luv2code.restdemo.entity.Student;
import com.luv2code.restdemo.exception.student.StudentNotFoundException;
import com.luv2code.restdemo.response.student.StudentErrorResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentRestController {
    private  List<Student> allStudent;
    @PostConstruct
    public void loadData(){
        this.allStudent=new ArrayList<>();
        allStudent.add(new Student("abdo","ashraf"));
        allStudent.add(new Student("ahmed ","ashraf"));

    }
    @GetMapping("")
    public List<Student> getAllStudent(){

        return this.allStudent;
    }
    @GetMapping("/{id}")
    public  Student getSingleStudent(@PathVariable int id){
        if(id<0||id>this.allStudent.size()){
            throw new StudentNotFoundException("student id not found :"+id);
        }
        return this.allStudent.get(id);
    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse<Object>> handleException(StudentNotFoundException exception){
        return getStudentErrorResponseResponseEntity(exception,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public  ResponseEntity<StudentErrorResponse<Object>> handleGlobalException(Exception exception){
        return getStudentErrorResponseResponseEntity(exception,HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<StudentErrorResponse<Object>> getStudentErrorResponseResponseEntity(Exception exception,HttpStatus status) {
        StudentErrorResponse<Object> error=new StudentErrorResponse<>();
        error.setStatus(status.value());
        error.setMessage(exception.getMessage());
        error.setData(null);
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,status);
    }
}

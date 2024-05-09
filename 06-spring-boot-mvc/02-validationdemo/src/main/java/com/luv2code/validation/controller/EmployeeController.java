package com.luv2code.validation.controller;

import com.luv2code.validation.dtos.EmployeeDTO;
import com.luv2code.validation.entity.Employee;
import com.luv2code.validation.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    private  final EmployeeService employeeService;
    @Autowired
    public EmployeeController(@Qualifier("employeeServiceImpl") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public  String getAllEmployee(Model uiModel){
        List<Employee> employees = employeeService.findAll();
        uiModel.addAttribute("employees", employees);
        return "employee-list";
    }
    @GetMapping("/employees/{id}")
    public  String getEmployeeById(@PathVariable("id") long id,Model uiModel ){
        Employee employee = employeeService.getById(id);
        uiModel.addAttribute("employee", employee);

        return "show";
    }
    @GetMapping("/employees/new")
    public  String showEmployeeForm(Model uiModel){
            uiModel.addAttribute("employee",new EmployeeDTO());
            return  "create";
    }
    @PostMapping("/employees")
    public String createEmployee(@Valid @ModelAttribute("employee") EmployeeDTO employeeDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "create";
        }

        employeeService.create(employeeDTO);
        return "redirect:/";
    }
    @GetMapping("/employees/{id}/delete")
    public  String deleteEmployee(@PathVariable("id") long id,Model uiModel ){
       employeeService.delete(id);
        return "redirect:/";
    }
}

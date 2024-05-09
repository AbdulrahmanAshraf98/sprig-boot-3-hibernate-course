package com.luv2code.validation.dtos;

import jakarta.validation.constraints.*;

public class EmployeeDTO {
    @NotBlank(message = "first name is required")
    @Pattern(regexp = "[a-zA-z]+",message = "character only excepted")
    @Size(min = 3,message = "min number of character 3")
    private String firstName;
    @NotBlank(message = "last name is required")
    @Pattern(regexp = "[a-zA-z]+",message = "character only excepted")
    @Size(min = 3,message = "min number of character 3")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;
    public  EmployeeDTO(){

    }
    public EmployeeDTO(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

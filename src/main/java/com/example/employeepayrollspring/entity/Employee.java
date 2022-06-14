package com.example.employeepayrollspring.entity;

import com.example.employeepayrollspring.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Entity Class for Employee
 *
 * @Data - For Getters and Setters.
 * @AllArgsConstructor - For Constructor with all arguments.
 * @NoArgsConstructor - For Constructor with no arguments.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    /**
     * Id: Auto generated id by using id and Generated values Annotation.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String name;
    public String profilePic;
    public String gender;
    @ElementCollection
    @CollectionTable(name = "department", joinColumns = @JoinColumn(name = "id"))
    public List<String> department;
    int salary;
    String mobileNumber;

    // LocalDate startDate;
    public String notes;

    /**
     * Constructor : Using employee object and Id
     *
     * @param id          - Id of employee
     * @param employeeDTO - employeeDTO object.
     */
    public Employee(int id, EmployeeDTO employeeDTO) {
        this.id = id;
        this.name = employeeDTO.name;
        this.profilePic = employeeDTO.profilePic;
        this.gender = employeeDTO.gender;
        this.department = employeeDTO.department;
        this.notes = employeeDTO.notes;
        this.salary = employeeDTO.salary;
        // this.startDate = employeeDTO.startDate;
    }

    /**
     * Constructor: Using employeeDTO
     * 
     * @param employeeDTO - employeeDTO object.
     */
    public Employee(EmployeeDTO employeeDTO) {
        this.name = employeeDTO.name;
        this.profilePic = employeeDTO.profilePic;
        this.gender = employeeDTO.gender;
        this.department = employeeDTO.department;
        this.notes = employeeDTO.notes;
        this.salary = employeeDTO.salary;
        // this.startDate = employeeDTO.startDate;
    }
}

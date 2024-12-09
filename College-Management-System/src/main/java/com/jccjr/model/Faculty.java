package com.jccjr.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Faculty {

    @Id
    private Long id;  // Assuming you're using a Long as the ID type

    private String name;
    private String firstName;
    private String lastName;
    private String department;  // New field for department

    // Constructor
    public Faculty() {
    }

    public Faculty(Long id, String name, String firstName, String lastName, String department) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for first name
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and Setter for last name
    public String getLastName(String string) {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter and Setter for department
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Optionally, combine first and last name
    public String getFullName() {
        return firstName + " " + lastName;
    }
}

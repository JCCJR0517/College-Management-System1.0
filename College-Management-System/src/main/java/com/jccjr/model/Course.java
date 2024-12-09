package com.jccjr.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    private Long id;
    private String courseName;
    private String courseCode;
    private String description;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getInstructor() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getInstructor'");
    }

    public void setInstructor(Object instructor) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setInstructor'");
    }
}

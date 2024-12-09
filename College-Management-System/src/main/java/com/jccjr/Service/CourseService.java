package com.jccjr.Service;

import com.jccjr.model.Course;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private final List<Course> courseList = new ArrayList<>();

    public List<Course> getAllCourses() {
        return courseList;
    }

    public Course addCourse(Course course) {
        courseList.add(course);
        return course;
    }

    public Course updateCourse(Long id, Course course) {
        Course existingCourse = courseList.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Course not found"));
        
        existingCourse.setCourseName(course.getCourseName());
        existingCourse.setInstructor(course.getInstructor());
        return existingCourse;
    }

    public ResponseEntity<String> deleteCourse(Long id) {
        Course course = courseList.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Course not found"));
        
        courseList.remove(course);
                return null;
    }
}

package com.jccjr.Service;

import com.jccjr.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServices {

    private final List<Student> studentList = new ArrayList<>();

    public List<Student> getAllStudents() {
        return studentList;
    }

    public Student addStudent(Student student) {
        studentList.add(student);
        return student;
    }

    public Student updateStudent(Long id, Student student) {
        Student existingStudent = studentList.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student not found"));
        
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setCourse(student.getCourse());
        return existingStudent;
    }

    public void deleteStudent(Long id) {
        Student student = studentList.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student not found"));
        
        studentList.remove(student);
    }
}

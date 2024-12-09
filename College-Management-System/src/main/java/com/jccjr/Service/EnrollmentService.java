package com.jccjr.Service;

import com.jccjr.model.Enrollment;
import com.jccjr.model.Student;
import com.jccjr.model.Course;
import com.jccjr.repository.EnrollmentRepository;
import com.jccjr.repository.StudentRepository;
import com.jccjr.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

  
    public Enrollment enrollStudentInCourse(Long studentId, Long courseId) {
        Optional<Student> student = studentRepository.findById(studentId);
        Optional<Course> course = courseRepository.findById(courseId);

        if (student.isPresent() && course.isPresent()) {
            Enrollment enrollment = new Enrollment();
            enrollment.setStudent(student.get());
            enrollment.setCourse(course.get());
            return enrollmentRepository.save(enrollment);
        } else {
            throw new RuntimeException("Student or Course not found");
        }
    }

  
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public List<Enrollment> getEnrollmentsByStudent(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

 
    public void removeEnrollment(Long enrollmentId) {
        Optional<Enrollment> enrollment = enrollmentRepository.findById(enrollmentId);

        if (enrollment.isPresent()) {
            enrollmentRepository.delete(enrollment.get());
        } else {
            throw new RuntimeException("Enrollment not found");
        }
    }

    public Enrollment getEnrollmentById(Long id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'getEnrollmentById'");
    }

    public Enrollment createEnrollment(Enrollment enrollment) {
        
        throw new UnsupportedOperationException("Unimplemented method 'createEnrollment'");
    }

    public Enrollment updateEnrollment(Long id, Enrollment enrollment) {
      
        throw new UnsupportedOperationException("Unimplemented method 'updateEnrollment'");
    }

    public boolean deleteEnrollment(Long id) {
       
        throw new UnsupportedOperationException("Unimplemented method 'deleteEnrollment'");
    }
}

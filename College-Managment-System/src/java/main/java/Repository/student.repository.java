// StudentRepository.java
package com.example.collegemanager.repository;

import com.example.collegemanager.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

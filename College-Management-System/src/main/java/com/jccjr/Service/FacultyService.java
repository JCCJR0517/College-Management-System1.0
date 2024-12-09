package com.jccjr.Service;

import com.jccjr.model.Faculty;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacultyService {

    private final List<Faculty> facultyList = new ArrayList<>();

    public List<Faculty> getAllFaculty() {
        return facultyList;
    }

    public Faculty addFaculty(Faculty faculty) {
        facultyList.add(faculty);
        return faculty;
    }

    public Faculty updateFaculty(Long id, Faculty faculty) {
        Faculty existingFaculty = facultyList.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Faculty not found"));
        
        existingFaculty.setDepartment(faculty.getDepartment());
        return existingFaculty;
    }

    public ResponseEntity<String> deleteFaculty(Long id) {
        Faculty faculty = facultyList.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Faculty not found"));
        
        facultyList.remove(faculty);
                return null;
    }
}

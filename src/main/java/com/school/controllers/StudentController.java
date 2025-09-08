package com.school.controllers;

import com.school.dto.StudentDto;
import com.school.servicesImps.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentServiceImp studentServiceImp;

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping("/getStudents")
    public ResponseEntity<List<StudentDto>> studentList() {
        if (studentServiceImp.getStudents().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .header("information", "there are not students")
                    .build();

        } else {

            return ResponseEntity.ok()
                    .header("Iist", "list of students")
                    .body(studentServiceImp.getStudents());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addStudents")
    public ResponseEntity<String> addStudents(@RequestBody List<StudentDto> list) {
        for (StudentDto s : list)
            if (s.getStudentName().isEmpty() || s.getStudentClass().isEmpty() || s.getStudentAge() == 0)
                return ResponseEntity
                        .status(HttpStatus.NOT_ACCEPTABLE)
                        .body("Please fill all field");
            else
                studentServiceImp.addStudent(s);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("List of students are created");

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody StudentDto studentDto) {
        if (studentDto.getStudentName().isEmpty() || studentDto.getStudentAge() == 0 || studentDto.getStudentClass().isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE).body("Please fill all field");

        } else
            studentServiceImp.addStudent(studentDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("student is created");

    }

    @PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<Optional<StudentDto>> getStudentById(@PathVariable("id") int id) {

        if (studentServiceImp.getStudentById(id).isPresent())
            return ResponseEntity.ok().body(studentServiceImp.getStudentById(id));
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updateStudent")
    public ResponseEntity<String> updateStudent(@RequestBody StudentDto studentDto) {
        if (studentDto.getStudentId() == 0 || studentDto.getStudentName().isEmpty() || studentDto.getStudentClass().isEmpty() || studentDto.getStudentAge() == 0) {

            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                    .body("please all fields are required");
        } else
            studentServiceImp.updateStudent(studentDto);
        return ResponseEntity.ok().body("Student is updated");

    }
}

package com.school.services;

import com.school.dto.StudentDto;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<StudentDto> getStudents();

    void addStudent(StudentDto studentDto);

    void deleteStudentByID(int id);

    void updateStudent(StudentDto studentDto);

    Optional<StudentDto> getStudentById(int id);

    void addAllStudents(List<StudentDto> list);


}

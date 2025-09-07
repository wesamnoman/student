package com.school.servicesImps;

import com.school.configuration.ConfigDto;
import com.school.dto.StudentDto;
import com.school.entities.Student;
import com.school.repositories.StudentRepository;
import com.school.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentDto> getStudents() {

        return studentRepository.findAll().stream().map(ConfigDto::studentToDto).collect(Collectors.toList());
    }

    public void addStudent(StudentDto studentDto) {
        Student student = ConfigDto.studentDtoToStudent(studentDto);
        studentRepository.save(student);
    }

    public void deleteStudentByID(int id) {
        studentRepository.deleteById(id);

    }

    public void updateStudent(StudentDto studentDto) {
        Student student = ConfigDto.studentDtoToStudent(studentDto);
       studentRepository.save(student);
    }

    public Optional<StudentDto> getStudentById(int id) {
        Optional <Student> st = studentRepository.findById(id);
       // ConfigDto.studentToDto(st.get());
        Optional<StudentDto> studentDtoOp =Optional.of(ConfigDto.studentToDto(st.get()));
         return studentDtoOp;
    }

    public void addAllStudents(List<StudentDto> list) {
        List<Student> li = list.stream()
                .map(ConfigDto::studentDtoToStudent)
                .collect(Collectors.toList());
        studentRepository.saveAll(li);
    }




}

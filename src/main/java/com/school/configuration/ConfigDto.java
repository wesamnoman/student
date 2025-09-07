package com.school.configuration;

import com.school.dto.StudentDto;
import com.school.entities.Student;

public class ConfigDto {

    public  static StudentDto studentToDto (Student student){
        return new StudentDto(
                student.getStudentId(),
                student.getStudentName(),
                student.getStudentAge(),
                student.getStudentClass(),
                student.getGender());
    }


    public static Student studentDtoToStudent(StudentDto studentDto){

        return new Student(
                studentDto.getStudentId(),
                studentDto.getStudentName(),
                studentDto.getStudentAge(),
                studentDto.getStudentClass(),
                studentDto.getGender());
    }

}

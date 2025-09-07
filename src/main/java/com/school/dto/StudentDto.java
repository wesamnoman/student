package com.school.dto;


import com.school.configuration.Gender;
import com.school.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto {

    private int studentId;
    private String studentName;
    private int studentAge;
    private String studentClass;
    private Gender gender;


}

package com.school.entities;

import com.school.configuration.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="students")
@Entity
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="student_id")
private int studentId;
@Column(name="student_name")
private String studentName;
@Column(name="student_age")
private int studentAge;
@Column(name="student_class")
private String studentClass;
@Column(name="gender")
@Enumerated(EnumType.STRING)
private Gender gender;
}

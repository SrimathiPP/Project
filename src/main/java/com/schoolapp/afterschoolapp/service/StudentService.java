package com.schoolapp.afterschoolapp.service;

import com.schoolapp.afterschoolapp.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {
    List<Student> getAllStudents();

    Student saveStudent(Student student);
    void addStudent(Student student);
    Student getStudentById(Long id);

    Student updateStudent(Student student);

    void deleteStudentById(Long id);
}
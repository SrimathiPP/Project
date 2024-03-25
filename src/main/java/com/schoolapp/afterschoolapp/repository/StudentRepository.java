package com.schoolapp.afterschoolapp.repository;

import com.schoolapp.afterschoolapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}

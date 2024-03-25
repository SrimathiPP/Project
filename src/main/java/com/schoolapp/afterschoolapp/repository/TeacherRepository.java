package com.schoolapp.afterschoolapp.repository;

import com.schoolapp.afterschoolapp.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    Teacher findByEmail(String email);
    Teacher findByEmailAndPassword(String email, String password);
}

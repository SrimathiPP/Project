package com.schoolapp.afterschoolapp.service;

import com.schoolapp.afterschoolapp.model.Teacher;
import com.schoolapp.afterschoolapp.repository.TeacherRegDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface TeacherService extends UserDetailsService {
    Teacher findByEmail(String email);
    //Teacher login(String email, String password);
    Teacher save(TeacherRegDTO registration);

}

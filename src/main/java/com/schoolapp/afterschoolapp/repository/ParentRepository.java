package com.schoolapp.afterschoolapp.repository;

import com.schoolapp.afterschoolapp.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent,Long> {
    Parent findByEmail(String email);
  //  Parent findByUserName(String userName);
   // Parent findByEmailAndPassword(String email, String password);
}

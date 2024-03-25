package com.schoolapp.afterschoolapp.service;

import com.schoolapp.afterschoolapp.model.Parent;
import com.schoolapp.afterschoolapp.repository.ParentRegistrationDto;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface ParentService  {
    Parent registerParent(String childName, String parentName, String email, String phone);

    Parent getParentByEmail(String email);

    Parent findByEmail(String email);

    //Parent login(String email, String password);
       Parent getParentById(Long id) throws ChangeSetPersister.NotFoundException;
    public List<Parent> getAllParents();
}

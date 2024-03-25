package com.schoolapp.afterschoolapp.service;

import com.schoolapp.afterschoolapp.model.Parent;
import com.schoolapp.afterschoolapp.model.Role;
import com.schoolapp.afterschoolapp.model.Teacher;
import com.schoolapp.afterschoolapp.repository.ParentRegistrationDto;
import com.schoolapp.afterschoolapp.repository.ParentRepository;
import com.schoolapp.afterschoolapp.repository.TeacherRegDTO;
import com.schoolapp.afterschoolapp.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private
    TeacherRepository teacherRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Teacher findByEmail(String email){
        return teacherRepository.findByEmail(email);
    }

    public Teacher save(TeacherRegDTO registration){
        Teacher user = new Teacher();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        //user.setEmail("srimathi.rp1@gmail.com");
       // user.setPassword(passwordEncoder.encode("Sriram321!"));
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return teacherRepository.save(user);
    }
 /*   @Override
    public Teacher login(String email, String password) {
        return teacherRepository.findByEmailAndPassword(email, password);
    }*/
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Teacher user = teacherRepository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
       // return new org.springframework.security.core.userdetails.User("srimathi.rp1@gmail.com","Sriram321!", mapRolesToAuthorities(user.getRoles()));
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
               user.getPassword(),
               mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}

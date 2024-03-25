package com.schoolapp.afterschoolapp.service;

import com.schoolapp.afterschoolapp.model.Parent;
import com.schoolapp.afterschoolapp.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentServiceImpl implements ParentService {
    @Autowired
    private final ParentRepository parentRepository;



    public ParentServiceImpl(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public Parent registerParent(String childName, String parentName, String email, String phone) {
        Parent parent = new Parent(childName, parentName, email, phone);
        return parentRepository.save(parent);
    }
    @Override
    public Parent getParentByEmail(String email) {
        return parentRepository.findByEmail(email);
    }

    @Override
    public Parent findByEmail(String email) {
        return null;
    }

    @Override
    public Parent getParentById(Long id) throws ChangeSetPersister.NotFoundException {
        return parentRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @Override
    public List<Parent> getAllParents() {
        return null;
    }


   /* @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Parent user = parentRepository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));

    }*/

   /* public Parent findByEmail(String email){
        return parentRepository.findByEmail(email);
    }

    public Parent save(ParentRegistrationDto registration){
        Parent user = new Parent();
        user.setParentName(registration.getParentName());
        user.setUserName(registration.getUserName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setRoles(Arrays.asList(new Role("ROLE_PARENT")));
        return parentRepository.save(user);
    }*/

   /* @Override
    public UserDetails loadUserByUsername(String email) {
        Parent user = parentRepository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }*/

    /*private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }*/
    }

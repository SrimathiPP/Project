package com.schoolapp.afterschoolapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@Table(name = "parent")
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String childName;

    private String parentName;


    private String email;

    private String phone;


    //private String password;

   /* @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;*/

    public Parent(String childName, String parentName, String email, String phone ) {
        this.childName = childName;
        this.parentName = parentName;
        this.email = email;
        this.phone = phone;
      //  this.password = password;

    }

}

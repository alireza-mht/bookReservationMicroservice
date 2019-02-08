package io.github.alirezamht.book.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, name= "name")
    private String name;
    @Column(nullable = false, name= "last_name")
    private String lastName;
    @Column(nullable = false, name= "password")
    private String password;
    @Column(nullable = false, name= "username")
    private String username;
    @Column(nullable = false, name= "manager")
    private Long manager;

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getManager() {
        return manager;
    }

    public void setManager(Long manager) {
        this.manager = manager;
    }

    public User(String firstName, String lastName, String persianFirstName, String persianLastName, int type, String phoneNumber, int field, String fieldName, String persianFieldName, String nationalNumber, String studentNumber, String password) {

        this.lastName = lastName;

    }

    public User() {
    }

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                '}';
    }

}

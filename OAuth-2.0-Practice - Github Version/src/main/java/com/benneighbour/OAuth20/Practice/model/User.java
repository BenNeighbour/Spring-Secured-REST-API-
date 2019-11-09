package com.benneighbour.OAuth20.Practice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
// Line that stops exception because of a Hibernate~Jackson compatibilty issue, which ignores the handler
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    // Defining the id of the user so that it can be easily selected/joined with all of it's other relations
    @Id
    @Column(name = "uid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    // Defining the username of the user which is a credential for when the user logs in or signs up
    @Column(name = "username")
    private String username;
    
    // Defining the password of the user which is a hidden credential to users searching for the user
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password")
    private String password;

    // Defining a list of the type of the Role entity which has a direction relationship with the user object
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Role> roles;

    // Defining super-constructor for the entity
    User() {}

    // Defining the object constructor INCLUDING the role list
    public User(String username, String password, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
    
    /*
        Usually, I would use Lombok for the Getters and 
        Getters, but some IDE's don't support the plugin
        and will show you errors when referencing the methods
        even though they are there. I have used traditional Java
        Setter and Getters for this project.
    */

    // Setter and getter for the user id  
    public Long getUid() {
        return uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
    }

    // Setter and getter for the user's username
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    // Setter and getter for the user's password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    // Setter and getter for the user's role list
    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


}

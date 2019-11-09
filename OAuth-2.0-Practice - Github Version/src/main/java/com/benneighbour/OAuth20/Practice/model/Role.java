package com.benneighbour.OAuth20.Practice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "role")
// Line that stops exception because of a Hibernate~Jackson compatibilty issue, which ignores the handler
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Role {

    // Defining the id of the role so that it can be easily selected/joined with all of it's other relations
    @Id
    @Column(name = "rid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rid;

    String name;

    // Defining super-constructor for the entity
    Role() {}

    // Defining the object constructor
    public Role(String name) {
        this.name = name;
    }

    /*
        Usually, I would use Lombok for the Getters and 
        Getters, but some IDE's don't support the plugin
        and will show you errors when referencing the methods
        even though they are there. I have used traditional Java
        Setter and Getters for this project.
    */

    // Setter and getter for the role id
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}

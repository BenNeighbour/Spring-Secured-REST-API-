package com.benneighbour.OAuth20.Practice.controller;

import com.benneighbour.OAuth20.Practice.model.User;
import com.benneighbour.OAuth20.Practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {

    /*
        Initializes a static string that holds the url for the frontend in order for it to
        make API calls to the controllers below.
     */
    private final String allowedOrigin = "http://localhost:3000/";

    @Autowired
    private UserService service;

    @CrossOrigin(origins = allowedOrigin)
    @PostMapping("/save/")
    public User save(@RequestBody User u) {
        return service.saveUser(u);
    }

    @CrossOrigin(origins = allowedOrigin)
    @GetMapping("/all/")
    public List<User> getAllUsers() {
        return service.getAllUserList();
    }

    @CrossOrigin(origins = allowedOrigin)
    @PutMapping("/update")
    public User update(@RequestBody User u) {
        return service.saveUser(u);
    }

    @CrossOrigin(origins = allowedOrigin)
    @GetMapping("/by/{uid}")
    public User getUser(@PathVariable(name="uid") Long uid) {
        return service.getUser(uid);
    }

    @CrossOrigin(origins = allowedOrigin)
    @DeleteMapping("/by/{uid}")
    public void deleteUser(@PathVariable(name="uid") Long uid) {
        service.deleteUser(uid);
    }

}

package com.benneighbour.OAuth20.Practice.service;

import com.benneighbour.OAuth20.Practice.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User updateUser(User user);

    List<User> getAllUserList();

    User getUser(Long uid);

    void deleteUser(Long uid);

}

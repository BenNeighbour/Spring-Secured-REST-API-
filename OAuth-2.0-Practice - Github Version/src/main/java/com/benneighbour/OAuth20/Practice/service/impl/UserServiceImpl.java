package com.benneighbour.OAuth20.Practice.service.impl;

import com.benneighbour.OAuth20.Practice.dao.UserDao;
import com.benneighbour.OAuth20.Practice.model.User;
import com.benneighbour.OAuth20.Practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return dao.save(u);
    }

    @Override
    public User updateUser(User u) {
        return dao.saveAndFlush(u);
    }

    @Override
    public List<User> getAllUserList() {
        return dao.findAll();
    }

    @Override
    public User getUser(Long uid) {
        return dao.getOne(uid);
    }

    @Override
    public void deleteUser(Long uid) {
        dao.deleteById(uid);
    }

}

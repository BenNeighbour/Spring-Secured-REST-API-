package com.benneighbour.OAuth20.Practice.dao;

import com.benneighbour.OAuth20.Practice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findByUsername(String username);

}

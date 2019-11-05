package com.benneighbour.OAuth20.Practice;

import com.benneighbour.OAuth20.Practice.dao.UserDao;
import com.benneighbour.OAuth20.Practice.model.Role;
import com.benneighbour.OAuth20.Practice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import java.util.Arrays;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserDao dao) throws Exception{
		if(dao.count() == 0) {
			dao.save(new User("user", "user", Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));
		}

		builder.userDetailsService(s -> new CustomUserDetails(dao.findByUsername(s)));
	}
}
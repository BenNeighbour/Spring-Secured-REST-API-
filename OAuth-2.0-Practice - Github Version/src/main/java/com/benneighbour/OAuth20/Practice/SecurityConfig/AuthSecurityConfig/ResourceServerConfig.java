package com.benneighbour.OAuth20.Practice.SecurityConfig.AuthSecurityConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/public/").permitAll()
                .antMatchers("/user/").authenticated()
                .antMatchers("/user/all/").authenticated()
                .antMatchers("/user/by/{uid}").authenticated()
                .antMatchers("/user/by/{uid}").authenticated()
                .antMatchers("/user//update/").authenticated()
                .antMatchers("/user/save/").authenticated();
    }
}

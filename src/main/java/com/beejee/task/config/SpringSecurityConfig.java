package com.beejee.task.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${spring.security.user.name}")
    private String userName;

    @Value("${spring.security.user.password}")
    private String userPassword;


    @Value("${spring.security.admin.name}")
    private String adminName;

    @Value("${spring.security.admin.password}")
    private String adminPassword;


    @Autowired
    private PasswordEncoder passwordEncoder;

    // Create 2 users for demo
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser(userName).password(passwordEncoder.encode(userPassword)).roles("USER")
                .and()
                .withUser(adminName).password(passwordEncoder.encode(adminPassword)).roles("USER", "ADMIN");
    }

    // Secure the endpoins with HTTP Basic authentication

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/tasks/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/tasks**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/tasks/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/tasks/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

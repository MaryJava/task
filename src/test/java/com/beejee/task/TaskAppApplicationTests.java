package com.beejee.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAutoConfiguration
@Configuration
@ComponentScan("com.beejee.task")
@EntityScan("com.beejee.task")
@EnableTransactionManagement
@EnableJpaRepositories(repositoryImplementationPostfix = "CustomImpl", basePackages = "com.beejee.task")
public class TaskAppApplicationTests {

    public static void main(String[] args) {
        SpringApplication.run(TaskAppApplicationTests.class, args);
    }
}

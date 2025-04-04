package com.samettok.springdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// This tells Spring Boot where to find JPA entity classes (like Student) outside the default package.
@EntityScan(basePackages = {"com.samettok"})
// This tells Spring Boot to scan the specified package for Spring components like @Service, @Controller, and @Repository.
@ComponentScan(basePackages = {"com.samettok"})
@EnableJpaRepositories(basePackages = {"com.samettok"})
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

}

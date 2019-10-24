package com.spinku.userRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.spinku.userRestApi")
@SpringBootApplication
public class UserRestApiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(UserRestApiApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // TODO Auto-generated method stub
        return builder.sources(UserRestApiApplication.class);
    }
    
}

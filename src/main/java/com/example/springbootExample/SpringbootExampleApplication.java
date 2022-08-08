package com.example.springbootExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
//@EnableSwagger2
public class SpringbootExampleApplication extends SpringBootServletInitializer{

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringbootExampleApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootExampleApplication.class, args);
    }
    
    

}

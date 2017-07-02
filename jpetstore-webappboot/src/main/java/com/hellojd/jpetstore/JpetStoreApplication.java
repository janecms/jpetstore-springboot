package com.hellojd.jpetstore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.hellojd.jpetstore")
public class JpetStoreApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(JpetStoreApplication.class, args);
    }
}
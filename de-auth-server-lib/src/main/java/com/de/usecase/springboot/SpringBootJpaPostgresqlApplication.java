package com.de.usecase.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJpaPostgresqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaPostgresqlApplication.class, args);
    }

    /*
    * user creation
    * {
	"username":"akash1",
	"password":"Springadmin@123",
	"email":"akash1@spring.com"
}
    *
    * */

}

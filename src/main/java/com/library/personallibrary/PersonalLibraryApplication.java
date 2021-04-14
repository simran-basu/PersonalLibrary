package com.library.personallibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PersonalLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalLibraryApplication.class, args);
    }

}

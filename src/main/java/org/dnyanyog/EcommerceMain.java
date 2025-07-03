package org.dnyanyog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.dnyanyog.repo")  // Ensure this points to the correct package for your repositories
public class EcommerceMain {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceMain.class, args);
    }
}

package org.example.babplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BabplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(BabplusApplication.class, args);
    }

}

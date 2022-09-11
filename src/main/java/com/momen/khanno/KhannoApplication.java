package com.momen.khanno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KhannoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KhannoApplication.class, args);
    }

}

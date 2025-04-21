package com.ctms.ctms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CtmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CtmsApplication.class, args);
    }

}

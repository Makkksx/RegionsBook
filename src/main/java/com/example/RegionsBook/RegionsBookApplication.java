package com.example.RegionsBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RegionsBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegionsBookApplication.class, args);
    }

}

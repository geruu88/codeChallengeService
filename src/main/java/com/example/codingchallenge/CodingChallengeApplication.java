package com.example.codingchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CodingChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodingChallengeApplication.class, args);
    }

}

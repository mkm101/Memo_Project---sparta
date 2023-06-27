package com.sparta.memo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MemoNewApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemoNewApplication.class, args);
    }
}

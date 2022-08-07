package com.sanwu.shorturlservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.sanwu.shorturlservice.dal.dao")
@SpringBootApplication
public class ShorturlServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShorturlServiceApplication.class, args);
    }

}

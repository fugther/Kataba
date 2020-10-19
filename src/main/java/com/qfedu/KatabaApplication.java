package com.qfedu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.qfedu.dao")
@EnableTransactionManagement
public class KatabaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KatabaApplication.class, args);
    }

}

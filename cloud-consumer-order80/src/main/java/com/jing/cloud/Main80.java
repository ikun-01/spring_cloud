package com.jing.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Main80 {
    public static void main(String[] args) {
        SpringApplication.run(Main80.class,args);
    }
}

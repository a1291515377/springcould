package com.cd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient//向注册中心注册
@EnableFeignClients    //开启Feign功能
public class CouldFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouldFeignApplication.class, args);
    }
}

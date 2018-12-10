package com.cd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy//开启zuul服务
@EnableEurekaClient//表明自己是一个客户端，服务的消费者
@EnableDiscoveryClient//向注册中心进行注册
public class CouldZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouldZuulApplication.class, args);
    }
}

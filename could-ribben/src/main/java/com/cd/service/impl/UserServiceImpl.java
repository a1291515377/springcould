package com.cd.service.impl;

import com.cd.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    RestTemplate restTemplate;

    @Override
    @Validated
    @HystrixCommand(fallbackMethod="error")//断路器
    public String hiService(String name) {
        return restTemplate.getForObject("http://eureka-client/index/?name="+name,String.class);
    }

    public String error(String name){
        return "hi "+name+", sorry,error!";
    }
}

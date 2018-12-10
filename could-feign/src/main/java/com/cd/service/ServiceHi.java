package com.cd.service;

import com.cd.Hystric.ServiceHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client",fallback = ServiceHystric.class)//指定调用那个服务，这里调用service-hi的服务
public interface ServiceHi {
    @RequestMapping(value = "/index",method = RequestMethod.GET)//调用index的方法
    String sayHiFromClient(@RequestParam(value = "name") String name);

}

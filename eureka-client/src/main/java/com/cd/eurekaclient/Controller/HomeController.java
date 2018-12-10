package com.cd.eurekaclient.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${server.port}")
    String port;
    @RequestMapping("/")
    public String home(){
        return "成功 :"+port;
    }



    @RequestMapping("/index")
    public String index(@RequestParam String name){
        return "hi，"+name+"i am from port:"+port;
    }
}

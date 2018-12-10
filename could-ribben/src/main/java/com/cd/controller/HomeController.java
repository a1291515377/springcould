package com.cd.controller;

import com.cd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String home(){
        return userService.hiService("oooo");
    }

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return userService.hiService(name);
    }
}

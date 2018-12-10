package com.cd.controller;

import com.cd.service.ServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HiController {

    @Autowired
    ServiceHi serviceHi;

    @GetMapping("/hi")
    public String sayHi(@RequestParam String name){
        return serviceHi.sayHiFromClient(name);
    }
}

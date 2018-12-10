package com.cd.Hystric;

import com.cd.service.ServiceHi;
import org.springframework.stereotype.Component;

@Component
public class ServiceHystric implements ServiceHi {

    @Override
    public String sayHiFromClient(String name) {
        return "sorry:"+name;
    }
}

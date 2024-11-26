package com.laxman.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String home(){
        return  "welcome to hhome";
    }

    @GetMapping("/api/l")
    public String homeS(){
        return  "welcome to hhome  from api";
    }
}

package com.example.startrest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @GetMapping(value = "/my")
    public @ResponseBody String getMy(){
        return "My RESTApp";
    }

    @GetMapping(value = "/")
    public String getMy2(){
        return "index.html";
    }
}

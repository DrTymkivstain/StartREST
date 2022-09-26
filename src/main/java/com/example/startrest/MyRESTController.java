package com.example.startrest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRESTController {
    @GetMapping(value = "/my/rest")
    public String getMy(){
        return "My RESTController";
    }
}

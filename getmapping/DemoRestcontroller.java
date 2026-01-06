package com.example.getmapping.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestcontroller {

        @GetMapping("/hello")
        public String hello(){
            return "Hello World";
        }



}

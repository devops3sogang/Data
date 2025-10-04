package com.study.MongoSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FoodController {

    @GetMapping("/")
    @ResponseBody
    public String main() {

        return "Hello World";
    }
}

package com.study.MongoSpring.controller;

import com.study.MongoSpring.repository.Table1Repository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    private final Table1Repository table1Repository;

    public ViewController(Table1Repository table1Repository) {
        this.table1Repository = table1Repository;
    }

    @GetMapping("/") // http://localhost:8080/
    public String main(Model model) {
        model.addAttribute("data", table1Repository.findAll());
        return "main"; // templates/main.html
    }
}

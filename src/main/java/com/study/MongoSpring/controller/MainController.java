package com.study.MongoSpring.controller;

import com.study.MongoSpring.document.Table1Document;
import com.study.MongoSpring.repository.Table1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    private final Table1Repository table1Repository;

    public MainController(Table1Repository table1Repository) {
        this.table1Repository = table1Repository;
    }

    @GetMapping("/")
    public String main() {
        StringBuilder html = new StringBuilder("<h1>Table1 데이터 목록</h1><ul>");
        for (Table1Document doc : table1Repository.findAll()) {
            html.append("<li>").append(doc.getData()).append("</li>");
        }
        html.append("</ul>");
        return html.toString();
    }
}


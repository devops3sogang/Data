package com.study.MongoSpring.controller;

import com.study.MongoSpring.document.Table1Document;
import com.study.MongoSpring.repository.Table1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/table1")
public class Table1Controller {

    @Autowired
    private Table1Repository table1Repository;

    // ✅ 전체 조회
    @GetMapping
    public List<Table1Document> getAll() {
        return table1Repository.findAll();
    }

    // ✅ 단일 조회 (ID 기반)
    @GetMapping("/{id}")
    public Optional<Table1Document> getById(@PathVariable("id") String id) {
        return table1Repository.findById(id);
    }

    // ✅ 데이터 추가
    @PostMapping
    public Table1Document create(@RequestBody Table1Document doc) {
        return table1Repository.save(doc);
    }

    // ✅ 데이터 삭제
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        table1Repository.deleteById(id);
    }
}

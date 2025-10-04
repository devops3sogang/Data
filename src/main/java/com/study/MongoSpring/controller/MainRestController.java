package com.study.MongoSpring.controller;

import com.study.MongoSpring.document.Table1Document;
import com.study.MongoSpring.repository.Table1Repository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Tag(name = "Table1 API", description = "MongoDB Table1 컬렉션 관리 API")
@RestController
@RequestMapping("/api/table1")
public class MainRestController {

    private final Table1Repository table1Repository;

    @Autowired
    public MainRestController(Table1Repository table1Repository) {
        this.table1Repository = table1Repository;
    }

    // ✅ 전체 데이터 조회
    @Operation(summary = "전체 데이터 조회", description = "Table1 컬렉션의 모든 문서를 조회합니다.")
    @GetMapping
    public List<Table1Document> getAll() {
        return table1Repository.findAll();
    }

    // ✅ ObjectId 기반 단일 조회
    @Operation(
            summary = "단일 데이터 조회 (ObjectId)",
            description = "MongoDB ObjectId(hex 문자열)를 사용하여 단일 문서를 조회합니다.\n" +
                    "예시: `GET /api/table1/68e13075859ab1cce4f88779`"
    )
    @GetMapping("/{id}")
    public Table1Document getById(@PathVariable("id") String id) {
        return table1Repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "데이터를 찾을 수 없습니다."));
    }

    // ✅ userId 기반 단일 조회
    @Operation(
            summary = "단일 데이터 조회 (userId)",
            description = "사용자 정의 ID(userId)를 기준으로 단일 문서를 조회합니다.\n" +
                    "예시: `GET /api/table1/by-user/user004`"
    )
    @GetMapping("/by-user/{userId}")
    public Table1Document getByUserId(@PathVariable("userId") String userId) {
        return table1Repository.findByUserId(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 userId의 데이터를 찾을 수 없습니다."));
    }

    // ✅ 데이터 추가
    @Operation(
            summary = "데이터 추가",
            description = "새로운 문서를 MongoDB에 추가합니다. `userId`, `name` 등의 필드를 JSON으로 전달하세요.\n" +
                    "예시:\n```json\n{\n  \"userId\": \"user004\",\n  \"name\": \"홍길동\"\n}\n```"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Table1Document create(@RequestBody Table1Document doc) {
        return table1Repository.save(doc);
    }

    // ✅ userId 기반 삭제
    @Operation(
            summary = "데이터 삭제 (userId)",
            description = "userId 값을 기준으로 문서를 삭제합니다.\n" +
                    "예시: `DELETE /api/table1/by-user/user004`"
    )
    @DeleteMapping("/by-user/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByUserId(@PathVariable("userId") String userId) {
        Table1Document doc = table1Repository.findByUserId(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "삭제할 데이터를 찾을 수 없습니다."));
        table1Repository.delete(doc);
    }
}

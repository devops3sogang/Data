package com.study.MongoSpring.repository;

import com.study.MongoSpring.document.Table1Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface Table1Repository extends MongoRepository<Table1Document, String> {
    // userId 기준으로 찾는 기능 추가
    Optional<Table1Document> findByUserId(String userId);
    void deleteByUserId(String userId);
}

package com.study.MongoSpring.repository;

import com.study.MongoSpring.document.Table1Document;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Table1Repository extends MongoRepository<Table1Document, String> {

}

package com.study.MongoSpring.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "table1")
@Data
public class Table1Document {

    @Id
    @org.springframework.data.mongodb.core.mapping.Field("_id") // ← 추가
    private String id;

    private String userId;
    private String data;
}

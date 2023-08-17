package com.example.mongodbstudy.abtest.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("persons")
@Data
public class PersonDto {

    @Id
    @Indexed
    private String id;

    @Field("name")
    private String name;

    @Field("age")
    private Integer age;
}

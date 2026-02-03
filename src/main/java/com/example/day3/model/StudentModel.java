package com.example.day3.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "student")

public class StudentModel {
    @Id
    private String id;

    private String name;
    private int age;
    private String email;
}

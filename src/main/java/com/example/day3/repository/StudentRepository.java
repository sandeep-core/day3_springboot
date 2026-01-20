package com.example.day3.repository;

import com.example.day3.model.StudentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<StudentModel, String> {

}

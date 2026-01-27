package com.example.day3.controller;

import com.example.day3.model.StudentModel;
import com.example.day3.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

   private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }


    //create function API

    @PostMapping("/add-student")
    public StudentModel addStudent(@RequestBody StudentModel student) {
        return service.addStudent(student);
    }

    @GetMapping("/Student")
    public List<StudentModel> getStudent(){
        return service.getStudent();

    }
    @GetMapping("/{id}")
    public  StudentModel getStudentById(@PathVariable String id){
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentModel updateStudent(
        @PathVariable String id,
        @RequestBody StudentModel student){
        return service.updateStudent(id,student);
    }
    @DeleteMapping("/{id}")
    public void deleteById(
            @PathVariable String id){
        service.deleteById(id);
    }

}


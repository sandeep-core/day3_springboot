package com.example.day3.controller;

import com.example.day3.dto.StudentRequestDto;
import com.example.day3.dto.StudentResponseDto;
import com.example.day3.model.StudentModel;
import com.example.day3.service.StudentService;
import jakarta.validation.Valid;
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
    public StudentResponseDto addStudent(@Valid @RequestBody StudentRequestDto student) {
        return service.addStudent(student);
    }

    // display all students
    @GetMapping("/Student")
    public List<StudentResponseDto> getAllStudents(){
        return service.getAllStudents();

    }
    @GetMapping("/{id}")
    public StudentResponseDto getStudentById(
            @PathVariable String id) {
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentResponseDto updateStudent(
            @PathVariable String id,
           @Valid @RequestBody StudentRequestDto student) {
        return service.updateStudent(id, student);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        service.deleteById(id);
    }

}


package com.example.day3.service;

import com.example.day3.model.StudentModel;
import com.example.day3.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    //create
    public StudentModel addStudent(StudentModel student){
        return repository.save(student);
    }

    public List<StudentModel> getStudent(){
        return repository.findAll();
    }

    public StudentModel getStudentById(String id){
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Student id not found"));
    }

    public StudentModel updateStudent(String id,StudentModel student){
        StudentModel existingStudent =getStudentById(id);

        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setAge(student.getAge());
        return repository.save(existingStudent);
    }
    public void deleteById(String id){
        repository.deleteById(id);
    }
}

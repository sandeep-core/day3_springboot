package com.example.day3.service;

import com.example.day3.dto.StudentRequestDto;
import com.example.day3.dto.StudentResponseDto;
import com.example.day3.exception.StudentNotFoundException;
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
/* public StudentModel addStudent(StudentModel student){
        return repository.save(student);
    }
*/
    public StudentResponseDto addStudent(StudentRequestDto dto){
        StudentModel student = new StudentModel();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());
        StudentModel saved = repository.save(student);

        return new StudentResponseDto(saved.getId(), saved.getName(), saved.getAge(), saved.getEmail());
    }
   /* public List<StudentModel> getStudent(){
        return repository.findAll();
    }
    */
    public List<StudentResponseDto> getAllStudents(){
        return repository.findAll()
                .stream()
                .map(s-> new StudentResponseDto(
                        s.getId(),
                        s.getEmail(),
                        s.getAge(),
                        s.getEmail()
                )).toList();
    }

    public StudentResponseDto getStudentById(String id) {
        StudentModel student = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id)
                );

        return new StudentResponseDto(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getEmail()
        );
    }


    // update Student

    public StudentResponseDto updateStudent(String id, StudentRequestDto dto) {
        StudentModel existing = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id)
                );

        existing.setName(dto.getName());
        existing.setAge(dto.getAge());
        existing.setEmail(dto.getEmail());

        StudentModel updated = repository.save(existing);

        return new StudentResponseDto(
                updated.getId(),
                updated.getName(),
                updated.getAge(),
                updated.getEmail()
        );
    }



    //delete by id

    public void deleteById(String id){
        StudentModel student = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id)
                );

        repository.delete(student);
    }
}

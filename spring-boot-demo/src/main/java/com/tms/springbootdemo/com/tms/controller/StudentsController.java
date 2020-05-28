package com.tms.springbootdemo.com.tms.controller;

import com.tms.springbootdemo.com.tms.model.Student;
import com.tms.springbootdemo.com.tms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class StudentsController {

    private final StudentRepository repo;

    private Random rand = new Random();

    @Autowired
    public StudentsController(StudentRepository repository) {
        this.repo = repository;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        student.setActive(rand.nextBoolean());
        return repo.save(student);
    }

    @GetMapping("/students/all")
    public List<Student> getStudents() {
        return (List)repo.findAll();
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return repo.findActive();
    }


    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        return "OOOOOPs: " + ex.getLocalizedMessage();
    }


}

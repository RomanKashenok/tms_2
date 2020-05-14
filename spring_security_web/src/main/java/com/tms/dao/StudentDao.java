package com.tms.dao;

import com.tms.model.Student;

import java.util.List;

public interface StudentDao {
    Student findByUsername(String username);
    List<Student> findAll();

    void addStudent(Student student);
}

package com.tms.springbootdemo.com.tms.repository;

import com.tms.springbootdemo.com.tms.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query("FROM Student s where s.active = true")
    List<Student> findActive();

}
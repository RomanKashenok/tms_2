package com.tms.dao.impl;

import com.tms.dao.StudentDao;
import com.tms.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String SQL_SELECT_USER_BY_USERNAME = "SELECT e.id, e.username, e.password, e.name, e.surname, roles.name as role " +
            " FROM students e " +
            "LEFT OUTER JOIN student_roles " +
            "ON e.id= student_roles.student_id " +
            "LEFT OUTER JOIN roles " +
            "ON student_roles.role_id = roles.id WHERE e.username = ?";

    private final String SQL_SELECT_USER_BY_ID = "SELECT * FROM students id = ?";

    private final String SQL_SELECT_ALL_USERS = "SELECT * FROM students";

    @Override
    public Student findByUsername(String username) {
        return jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_USERNAME, new StudentMapper(), username);
    }

    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL_USERS, new StudentMapper());
    }
}

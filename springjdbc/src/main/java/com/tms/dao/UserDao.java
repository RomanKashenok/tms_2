package com.tms.dao;

import com.tms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addUser(User user) {
        int rowsUpdated = jdbcTemplate.update("INSERT INTO USERS (name) VALUES (?)", user.getName());
    }

    public List<User> getUsers() {
        return jdbcTemplate.query("SELECT * FROM USERS", new UserRowMapper());
    }

    public User getById(Integer id){
        return jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE id=?", new UserRowMapper(), id);
    }

}

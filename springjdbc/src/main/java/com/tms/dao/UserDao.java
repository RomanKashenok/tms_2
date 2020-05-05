package com.tms.dao;

import com.tms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDao(@Autowired DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addUser(User user) {
        int rowsUpdated = jdbcTemplate.update("INSERT INTO USERS (name) VALUES (?)", user.getName());
    }

    public List<User> getUsers() {
        return jdbcTemplate.query("SELECT * FROM USERS", new UserRowMapper());
    }

}

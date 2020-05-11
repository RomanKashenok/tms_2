package com.tms.dao;

import com.tms.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User person = new User();
        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        return person;
    }
}
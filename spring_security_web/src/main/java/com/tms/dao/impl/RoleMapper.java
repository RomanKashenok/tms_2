package com.tms.dao.impl;

import com.tms.model.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<Role> {
    @Override
    public Role mapRow(ResultSet rs, int i) throws SQLException {
        return Role.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .build();
    }
}

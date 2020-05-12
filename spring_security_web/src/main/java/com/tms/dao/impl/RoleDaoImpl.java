package com.tms.dao.impl;

import com.tms.dao.RoleDao;
import com.tms.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String SQL_USER_ROLES = "SELECT roles.id, roles.name FROM students " +
            "LEFT OUTER JOIN student_roles " +
            "ON students.id= student_roles.student_id " +
            "LEFT OUTER JOIN roles " +
            "ON student_roles.role_id = roles.id WHERE students.id = ?";

    @Override
    public List<Role> findUserRoles(Long userId) {
        return jdbcTemplate.query(SQL_USER_ROLES, new RoleMapper(), userId);
    }
}

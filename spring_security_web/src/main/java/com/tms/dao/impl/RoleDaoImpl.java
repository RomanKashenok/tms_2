package com.tms.dao.impl;

import com.tms.dao.RoleDao;
import com.tms.model.Role;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Role> findAllRoles() {
        return sessionFactory.getCurrentSession().createQuery("from Role").list();
    }

    @Override
    public Role findRoleUser(String roleName) {
        Query<Role> query = sessionFactory.getCurrentSession().createQuery("from Role where name = :rolename");
        query.setParameter("rolename", roleName);

        return query.getSingleResult();
    }
}

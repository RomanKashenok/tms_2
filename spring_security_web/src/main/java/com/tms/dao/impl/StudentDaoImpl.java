package com.tms.dao.impl;

import com.tms.dao.RoleDao;
import com.tms.dao.StudentDao;
import com.tms.model.Role;
import com.tms.model.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Student findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query<Student> findByUsername = session.createQuery("from Student where username = :login");
        findByUsername.setParameter("login", username);
        return findByUsername.getSingleResult();

//        Criteria crit = session.createCriteria(Student.class);
//        crit.add(Restrictions.eq("username", username));
//        Student student = (Student) crit.uniqueResult();
//        return student;

//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery cr = cb.createQuery(Student.class);
//        Root<Student> root = cr.from(Student.class);
//        cr.where(root.get("username").in(username));
//        cr.select(root);
//        Query<Student> query = session.createQuery(cr);
//        Student result = query.getSingleResult();
//
//        return result;
    }

    @Override
    public List<Student> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Student").list();
    }

    @Override
    public void addStudent(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        Role role = roleDao.findRoleUser("USER");
        student.setRoles(Collections.singletonList(role));
        sessionFactory.getCurrentSession().save(student);
    }
}

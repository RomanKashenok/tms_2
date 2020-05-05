package com.tms;

import com.tms.dao.UserDao;
import com.tms.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan
public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        UserDao dao = context.getBean(UserDao.class);

        List<User> users = dao.getUsers();
        System.out.println(users);

        User user = new User();
        user.setName("Raman");

        dao.addUser(user);

        users = dao.getUsers();
        System.out.println(users);
    }
}

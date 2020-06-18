package com.tms.testing.repository;


import com.tms.testing.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repo;

    @Before
    public void setUp() {
        repo.deleteAll();
    }

    @Test
    public void should_save_user_successfully() {
        User user = new User();
        user.setName("Vasya1");
        repo.save(user);

        List<User> all = repo.findAll();

        Assert.assertEquals(1, all.size());
        Assert.assertEquals("Vasya1", all.get(0).getName());
    }

    @Test
    public void should_return_user_with_definitely_name() {
        User user1 = new User();
        user1.setName("name");

        User user2 = new User();
        user2.setName("name2");

        repo.saveAll(Arrays.asList(user1, user2));

        List<User> allFound = repo.findAll();

        Assert.assertEquals(2, allFound.size());

        List<User> foundUsersByName = repo.findUsersByName("name");

        Assert.assertEquals(1, foundUsersByName.size());
        Assert.assertEquals("name", foundUsersByName.get(0).getName());
    }

}

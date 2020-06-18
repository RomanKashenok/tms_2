package com.tms.testing.service;

import com.tms.testing.model.User;
import com.tms.testing.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository repo;
    @InjectMocks
    private UserService userService;

    @Test
    public void getAllUsers() {
        User user1 = new User();
        user1.setName("user1");
        user1.setId(1L);

        User user2 = new User();
        user2.setName("user2");
        user2.setId(2L);

        Mockito.when(repo.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> allUsers = userService.getAllUsers();

        Assert.assertEquals(2, allUsers.size());
        Mockito.verify(repo, times(1)).findAll();
    }
}

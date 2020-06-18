package com.tms.testing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tms.testing.TestingApplication;
import com.tms.testing.model.User;
import com.tms.testing.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestingApplication.class)
@AutoConfigureMockMvc
public class IntegrationUserController {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserService service;

    private ObjectMapper om = new ObjectMapper();

    @Test
    public void should_save_user_correctly() throws Exception {
        String requestBody = "{\"name\" : \"VASYA\"}";

        MockHttpServletResponse result = mvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andReturn().getResponse();

        User resultUser = om.readValue(result.getContentAsString(), User.class);
        Assert.assertEquals("VASYA", resultUser.getName());
        Assert.assertNotNull(resultUser.getId());

        List<User> found = service.getUsersByName("VASYA");
        Assert.assertEquals(1, found.size());
        Assert.assertEquals("VASYA", found.get(0).getName());

    }

}
package com.tms.testing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tms.testing.model.User;
import com.tms.testing.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService service;

    @Test
    public void should_retrieve_user_to_save()
            throws Exception {

        User user = new User();
        user.setName("user");


        User expectedResponse = user.clone();
        expectedResponse.setId(1L);

        given(service.addNewUser(user)).willReturn(expectedResponse);

        ObjectMapper mapper = new ObjectMapper();
        String request = mapper.writeValueAsString(user);


        String requestBody = "{\"name\" : \" VASYA\"}";

        MockHttpServletResponse result = mvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(status().isOk())
                .andReturn().getResponse();

        User resultUser = mapper.readValue(result.getContentAsString(), User.class);

        Assert.assertEquals(expectedResponse, resultUser);

    }

}

package com.elte.smartgym.controller;

import com.elte.smartgym.JsonConverter;
import com.elte.smartgym.model.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.elte.smartgym.model.enums.Role.*;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserControllerTest extends JsonConverter {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getAll() throws Exception {
        String uri = "/users";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        User[] userlist = super.mapFromJson(content, User[].class);
        assertTrue(userlist.length > 0);
    }

    @Test
    public void getById() throws Exception {
        String uri = "/users";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        User[] userlist = super.mapFromJson(content, User[].class);
        uri = "/users/1";
        mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        content = mvcResult.getResponse().getContentAsString();
        User userFromJson = super.mapFromJson(content, User.class);
        assertEquals(userlist[0].getId(), userFromJson.getId());
        assertEquals(userlist[0].getName(), userFromJson.getName());
        assertEquals(userlist[0].getRole(), userFromJson.getRole());
        assertEquals(userlist[0].getE_mail(), userFromJson.getE_mail());
        assertEquals(userlist[0].getHeight(), userFromJson.getHeight());
        assertEquals(userlist[0].getGoal_weight(),userFromJson.getGoal_weight());
        assertEquals(userlist[0].getScore(),userFromJson.getScore());
        assertEquals(userlist[0].getWeight(), userFromJson.getWeight());
        assertEquals(userlist[0].getPlan(), userFromJson.getPlan());
    }

    @Test
    public void postUser() throws Exception {
        String uri = "/users";
        User user = User.builder().id(2).name("TestUser").weight(73).goal_weight(70).height(80).role(USER).build();
        String inputJson = super.mapToJson(user);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        User postedUser = super.mapFromJson(content, User.class);
        assertEquals(postedUser.getName(), user.getName());
        assertEquals(postedUser.getUsername(), user.getUsername());
        assertEquals(postedUser.getWeight(), user.getWeight());
        assertEquals(postedUser.getPlan(), user.getPlan());
        assertEquals(postedUser.getE_mail(), user.getE_mail());
        assertEquals(postedUser.getHeight(), user.getHeight());
        assertEquals(postedUser.getGoal_weight(), user.getGoal_weight());
        assertEquals(postedUser.getRole(), user.getRole());
        assertEquals(postedUser.getRatings(), user.getRatings());
    }

    @Test
    public void updateUser() throws Exception {
        String uri = "/users/2";
        User user = User.builder().id(2).name("UpdateUser").weight(73).goal_weight(70).height(80).role(USER).build();
        String inputJson = super.mapToJson(user);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        User updatedUser = mapFromJson(content, User.class);
        assertEquals(updatedUser.getId(), user.getId());
        assertEquals(updatedUser.getName(), user.getName());
        assertEquals(updatedUser.getUsername(), user.getUsername());
        assertEquals(updatedUser.getWeight(), user.getWeight());
        assertEquals(updatedUser.getE_mail(), user.getE_mail());
        assertEquals(updatedUser.getHeight(), user.getHeight());
        assertEquals(updatedUser.getGoal_weight(), user.getGoal_weight());
        assertEquals(updatedUser.getRole(), user.getRole());
        assertEquals(updatedUser.getPlan(), user.getPlan());
        assertEquals(updatedUser.getRatings(), user.getRatings());
    }

    @Test
    public void deleteUser() throws Exception {
        String uri = "/users/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
}
package com.elte.smartgym.controller;


import com.elte.smartgym.JsonConverter;
import com.elte.smartgym.model.Plan;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlanControllerTest extends JsonConverter {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getAll() throws Exception {
        String uri = "/plans";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Plan[] planlist = super.mapFromJson(content, Plan[].class);
        assertTrue(planlist.length > 0);
    }

    @Test
    public void getById() throws Exception {
        String uri = "/plans";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        Plan[] planlist = super.mapFromJson(content, Plan[].class);
        uri = "/plans/1";
        mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        content = mvcResult.getResponse().getContentAsString();
        Plan planFromJson = super.mapFromJson(content, Plan.class);
        assertEquals(planlist[0].getId(), planFromJson.getId());
        assertEquals(planlist[0].getName(), planFromJson.getName());
        assertEquals(planlist[0].getDifficulty(), planFromJson.getDifficulty());
        assertEquals(planlist[0].getExercises(), planFromJson.getExercises());
        assertEquals(planlist[0].getUsers(), planFromJson.getUsers());
    }

    @Test
    public void postPlan() throws Exception {
        String uri = "/plans";
        Plan plan = Plan.builder().id(1).name("Test1").difficulty(1).build();
        String inputJson = super.mapToJson(plan);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Plan postedPlan = super.mapFromJson(content, Plan.class);
        assertEquals(postedPlan.getName(), plan.getName());
        assertEquals(postedPlan.getDifficulty(), plan.getDifficulty());
        assertEquals(postedPlan.getExercises(), plan.getExercises());
        assertEquals(postedPlan.getUsers(), plan.getUsers());
    }

    @Test
    public void updatePlan() throws Exception {
        String uri = "/plans/2";
        Plan plan = Plan.builder().id(2).name("UpdateTest").difficulty(3).build();
        String inputJson = super.mapToJson(plan);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Plan updatedPlan = mapFromJson(content, Plan.class);
        assertEquals(updatedPlan.getId(), plan.getId());
        assertEquals(updatedPlan.getName(), plan.getName());
        assertEquals(updatedPlan.getDifficulty(), plan.getDifficulty());
        assertEquals(updatedPlan.getExercises(), plan.getExercises());
        assertEquals(updatedPlan.getUsers(), plan.getUsers());
    }

    @Test
    public void deletePlan() throws Exception {
        String uri = "/plans/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
}
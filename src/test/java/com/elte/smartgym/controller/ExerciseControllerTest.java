package com.elte.smartgym.controller;

import com.elte.smartgym.JsonConverter;
import com.elte.smartgym.model.Exercise;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExerciseControllerTest extends JsonConverter {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getAll() throws Exception {
        String uri = "/exercises";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Exercise[] exerciselist = super.mapFromJson(content, Exercise[].class);
        assertTrue(exerciselist.length > 0);
    }

    @Test
    public void getById() throws Exception {
        String uri = "/exercises";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        Exercise[] exerciselist = super.mapFromJson(content, Exercise[].class);
        uri = "/exercises/1";
        mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

        content = mvcResult.getResponse().getContentAsString();
        Exercise exerciseFromJson = super.mapFromJson(content, Exercise.class);
        assertEquals(exerciselist[0].getId(), exerciseFromJson.getId());
        assertEquals(exerciselist[0].getName(), exerciseFromJson.getName());
        assertEquals(exerciselist[0].getDescription(), exerciseFromJson.getDescription());
        assertEquals(exerciselist[0].getDifficulty(), exerciseFromJson.getDifficulty());
        assertEquals(exerciselist[0].getPlans(), exerciseFromJson.getPlans());
    }

    @Test
    public void postExercise() throws Exception {
        String uri = "/exercises";
        Exercise exercise = Exercise.builder().id(1).name("Test1").difficulty(1).description("test").build();
        String inputJson = super.mapToJson(exercise);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Exercise postedExercise = super.mapFromJson(content, Exercise.class);
        assertEquals(postedExercise.getId(), exercise.getId());
        assertEquals(postedExercise.getName(), exercise.getName());
        assertEquals(postedExercise.getDifficulty(), exercise.getDifficulty());
        assertEquals(postedExercise.getDescription(), exercise.getDescription());
        assertEquals(postedExercise.getPlans(), exercise.getPlans());
    }

    @Test
    public void updateExercise() throws Exception {
        String uri = "/exercises/2";
        Exercise exercise = Exercise.builder().id(2).name("UpdateTest").difficulty(1).description("update test").build();
        String inputJson = super.mapToJson(exercise);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Exercise updatedExercise = mapFromJson(content, Exercise.class);
        assertEquals(updatedExercise.getId(), exercise.getId());
        assertEquals(updatedExercise.getName(), exercise.getName());
        assertEquals(updatedExercise.getDescription(), exercise.getDescription());
        assertEquals(updatedExercise.getDifficulty(), exercise.getDifficulty());
        assertEquals(updatedExercise.getPlans(), exercise.getPlans());
    }

    @Test
    public void deleteExercise() throws Exception {
        String uri = "/exercises/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
}

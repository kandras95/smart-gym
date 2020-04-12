package com.elte.smartgym.controller;

import com.elte.smartgym.JsonConverter;
import com.elte.smartgym.model.Rating;

import org.junit.Before;
import org.junit.Test;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RatingControllerTest extends JsonConverter {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getAll() throws Exception {
        String uri = "/ratings";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Rating[] ratinglist = super.mapFromJson(content, Rating[].class);
        assertTrue(ratinglist.length > 0);
    }


    @Test
    public void postRating() throws Exception {
        String uri = "/ratings";
        Rating rating = Rating.builder().id(1).creativity(2).efficiency(3).quality(3).build();
        String inputJson = super.mapToJson(rating);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Rating postedRating = super.mapFromJson(content, Rating.class);
        assertEquals(postedRating.getCreativity(), rating.getCreativity());
        assertEquals(postedRating.getEfficiency(), rating.getEfficiency());
        assertEquals(postedRating.getQuality(), rating.getQuality());
    }

    @Test
    public void updateRating() throws Exception {
        String uri = "/ratings/2";
        Rating rating = Rating.builder().id(2).creativity(3).efficiency(3).quality(1).build();
        String inputJson = super.mapToJson(rating);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Rating updatedRating = mapFromJson(content, Rating.class);
        assertEquals(updatedRating.getId(), rating.getId());
        assertEquals(updatedRating.getQuality(), rating.getQuality());
        assertEquals(updatedRating.getCreativity(), rating.getCreativity());
        assertEquals(updatedRating.getEfficiency(), rating.getEfficiency());
    }

    @Test
    public void deleteRating() throws Exception {
        String uri = "/ratings/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
}

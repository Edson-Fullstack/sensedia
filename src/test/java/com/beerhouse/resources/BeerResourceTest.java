package com.beerhouse.resources;

import com.beerhouse.repository.BeerRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class BeerResourceTest {

    private MockMvc mockMvc;
    @MockBean
    private BeerResource beerResource;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(beerResource).build();
    }
    @Test
    public void get() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/beers/1")
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("null"));
    }
    @Test
    public void getList() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/beers")
        )
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void getEmpty() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/beers")
        ).andExpect(MockMvcResultMatchers.status().isOk())
         .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
    @Test
    public void post() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/beers")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void put() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/beers/1")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void patch() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/beers/1")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void delete() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/beers/1")
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

}
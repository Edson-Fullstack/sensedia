package com.beerhouse;

import com.beerhouse.repository.BeerRepository;
import com.beerhouse.resources.BeerResource;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@WebMvcTest(BeerResource.class)
class ApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private BeerRepository beerRepository;

    @Test
    void contextLoads() throws Exception {

    }

}

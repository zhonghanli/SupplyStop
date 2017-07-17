package com.example.demo;

import com.example.demo.controller.SponsorController;
import com.example.demo.service.SponsorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by John on 7/12/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

//@WebMvcTest(SponsorController.class) //this only tests web layer, so no data is here
public class SponsorControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private SponsorService sponsorService;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(new SponsorController(sponsorService)).build();
    }

    @Test
    public void shouldReturnSponsor() throws Exception {
        this.mockMvc.perform(get("/sponsors/1"))
                .andExpect(status().isOk())
                .andDo(print())
                //.andExpect(content().string(containsString("Saville")))
                .andExpect(model().attribute("name", "Dominos"))
                .andExpect(model().attribute("type", "Restaurant"))
                .andExpect(model().attribute("size", "m"))
                .andExpect(view().name("sponsorProfile"));
    }
}

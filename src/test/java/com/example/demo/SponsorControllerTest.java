package com.example.demo;

import com.example.demo.controller.SponsorController;
import com.example.demo.service.SponsorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



/**
 * Created by John on 7/12/2017.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(SponsorController.class)
public class SponsorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SponsorService sponsorService;

    @Test
    public void shouldReturnSponsor() throws Exception {
        when(sponsorService.getSponsorName(2)).thenReturn("Success");
        this.mockMvc.perform(get("/sponsors/2")).andExpect(status().isOk()).andExpect(content().string(containsString("Success")));
    }
}

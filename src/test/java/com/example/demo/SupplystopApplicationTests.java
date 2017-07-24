package com.example.demo;

import com.example.demo.controller.HomeController;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setMaxElementsForPrinting;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.service.SponsorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SupplystopApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void returnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/sponsors/1"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Restaurant")))
				.andExpect(content().string(containsString("Dominos")));

	}

	@Test
	public void indexReturnsLatestProject() throws Exception{
		this.mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Cheesies")))
				.andDo(print());
	}


}

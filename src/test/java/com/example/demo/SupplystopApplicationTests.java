package com.example.demo;

import com.example.demo.controller.HomeController;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setMaxElementsForPrinting;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.demo.domain.Sponsor;
import com.example.demo.service.SponsorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
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

	@Test
	public void sponsorPostWorks() throws Exception{
		this.mockMvc.perform(post("/sponsors/")
				.param("name","John")
				.param("type","human")
				.param("size","s"))
				.andExpect(view().name("sponsors"))
				.andExpect(model().attributeExists("sponsor"))
				.andExpect(content().string(containsString("John")))
				.andExpect(status().isOk());
	}

	@Test
	public void sponsorPostNameBlankValidation() throws Exception{
		this.mockMvc.perform(post("/sponsors/")
				.param("name", "    ")
				.param("type","human")
				.param("size","s"))
				.andExpect(view().name("sponsors"))
				.andExpect(model().attributeHasFieldErrors("sponsor","name"));
	}

	@Test
	public void sponsorPostNameTooShortValidation() throws Exception{
		this.mockMvc.perform(post("/sponsors/")
				.param("name", "a")
				.param("type","human")
				.param("size","s"))
				.andExpect(view().name("sponsors"))
				.andExpect(model().attributeHasFieldErrors("sponsor","name"));
	}

	@Test
	public void sponsorPostNameTooLongValidation() throws Exception{
		this.mockMvc.perform(post("/sponsors/")
				.param("name", "supercalifragilisticexpialidocious")
				.param("type","human")
				.param("size","s"))
				.andExpect(view().name("sponsors"))
				.andExpect(model().attributeHasFieldErrors("sponsor","name"));
	}

	@Test
	public void sponsorPostTypeTooShortValidation() throws Exception{
		this.mockMvc.perform(post("/sponsors/")
				.param("name", "John")
				.param("type","H")
				.param("size","s"))
				.andExpect(view().name("sponsors"))
				.andExpect(model().attributeHasFieldErrors("sponsor","type"));
	}

	@Test
	public void sponsorPostTypeTooLongValidation() throws Exception{
		this.mockMvc.perform(post("/sponsors/")
				.param("name", "John")
				.param("type","supercalifragilisticexpialidocious")
				.param("size","s"))
				.andExpect(view().name("sponsors"))
				.andExpect(model().attributeHasFieldErrors("sponsor","type"));
	}

	@Test
	public void sponsorPostTypeBlankValidation() throws Exception{
		this.mockMvc.perform(post("/sponsors/")
				.param("name", "John")
				.param("type","     ")
				.param("size","s"))
				.andExpect(view().name("sponsors"))
				.andExpect(model().attributeHasFieldErrors("sponsor","type"));
	}


	@Test
	public void projectPostQuantityTooLowValidation() throws  Exception{
		this.mockMvc.perform(post("/create")
			.param("quantity", "1")
			.param("price", "50"))
			.andExpect(view().name("projectcreate/createProject"))
			.andExpect(model().attributeHasFieldErrors("project", "quantity"));
	}

	@Test
	public void projectPostQuantityTooHighValidation() throws  Exception{
		this.mockMvc.perform(post("/create")
				.param("quantity", "99999999999")
				.param("price", "50"))
				.andExpect(view().name("projectcreate/createProject"))
				.andExpect(model().attributeHasFieldErrors("project", "quantity"));
	}

	@Test
	public void	projectPostPriceTooLowValidation() throws Exception{
		this.mockMvc.perform(post("/create")
			.param("quantity", "1000")
			.param("price", "0"))
			.andExpect(view().name("projectcreate/createProject"))
			.andExpect(model().attributeHasFieldErrors("project", "price"));
	}

	@Test
	public void	projectPostPriceTooHighValidation() throws Exception{
		this.mockMvc.perform(post("/create")
				.param("quantity", "1000")
				.param("price", "999"))
				.andExpect(view().name("projectcreate/createProject"))
				.andExpect(model().attributeHasFieldErrors("project", "price"));
	}



}

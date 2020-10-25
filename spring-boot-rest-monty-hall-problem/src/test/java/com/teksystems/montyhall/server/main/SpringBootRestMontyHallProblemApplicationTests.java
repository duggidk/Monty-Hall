package com.teksystems.montyhall.server.main;

/*
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

*/
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.teksystems.montyhall.services.MontyHallGameService;

@WebMvcTest(controllers = MontyHallController.class)
class SpringBootRestMontyHallProblemApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void homePage() throws Exception {
		
		mockMvc.perform(get("/index.html"))
				.andExpect(content().string(containsString("Get your game results")));
	}
	
	@Test
	public void playPageTest1() throws Exception {
		
		mockMvc.perform(get("/api/play/100/y"))
				.andExpect(content().string(containsString("Win Percentage:")));
	}
	@Test
	public void playPageTest2() throws Exception {
		
		mockMvc.perform(get("/api/play/100/y"))
				.andExpect(content().string(containsString("Win Percentage:")));
	}
	
	@Test
	public void playPageTest3() throws Exception {
		
		mockMvc.perform(get("/api/play/100/n"))
				.andExpect(content().string(containsString("Win Percentage:")));
	}	
	
	@Autowired
	private MontyHallController controller;
	
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
		
	}
	
	
	
	
	
	

}

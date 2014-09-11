package com.testing.test.pdfproject.controller;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.test.pdfgenerator.service.PdfGeneratorService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DataRetrivalControllerMVCTest.Config.class}) 
@WebAppConfiguration
public class DataRetrivalControllerMVCTest {
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	MockMvc mockMvc;	
	
	@Autowired
	PdfGeneratorService pdfGeneratorService;
	
	@Autowired
	private ConversionService conversionService;
	
	
	 @Before
	 public void setUp(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
	}

	@Test
	public void test_getmachinenamelist() throws Exception {
		System.out.println("Test running......");
		mockMvc.perform(get("/pdfproject/getmachinenamelist")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
		
		System.out.println("jinklo........");
	}

	@Configuration
	@EnableWebMvc
	@ComponentScan(basePackages={"com.test.pdfproject.controller"})
	public static class Config {

		@Bean
		public PdfGeneratorService getPdfGeneratorService() {
			return mock(PdfGeneratorService.class); 
		}
		
	}

}

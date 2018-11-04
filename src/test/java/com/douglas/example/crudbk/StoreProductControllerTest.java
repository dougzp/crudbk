package com.douglas.example.crudbk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.douglas.example.crudbk.controller.StoreProductResourceForTest;
import com.douglas.example.crudbk.entities.StoreProduct;
import com.douglas.example.crudbk.service.StoreProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = StoreProductResourceForTest.class, secure = false)
public class StoreProductControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StoreProductService service;

	
	StoreProduct java8Mock = new StoreProduct(1l,"java8","basics");


	@Test
	public void retrieveDetailsForCourse() throws Exception {

		Mockito.when(
				service.retrieveStoreProduct(Mockito.anyLong())).thenReturn(java8Mock);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/storeProductTest/1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{id:1,storeProductName:java8,storeProductDescription:basics}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

}


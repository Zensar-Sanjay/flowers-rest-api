package com.flowers.rest.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

class UserDetailRestControllerTests extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	void testGetUserDetails() throws Exception {
		String restUrl = "/api/vi/userDetails";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(restUrl).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertTrue(content.length() > 0);
	}

	@Test
	public void testGetUniqueUserDetails() throws Exception {
		String restUrl = "/api/vi/uniqueUsers";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(restUrl).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertTrue(content.length() > 0);
	}

	@Test
	void testUpdateUserDetails() throws Exception {
		String restUrl = "api/vi/updateUserDetails/7?value=1800Flowers";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(restUrl).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertTrue(content.length() > 0);
	}

}

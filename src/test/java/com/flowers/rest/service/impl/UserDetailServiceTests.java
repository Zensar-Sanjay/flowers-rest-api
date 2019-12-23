package com.flowers.rest.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.flowers.rest.beans.UserDetail;
import com.flowers.rest.service.IUserDetailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@SpringBootTest
class UserDetailServiceTests {

	@Mock
	IUserDetailService userDetailService;

	@Test
	void testGetUserDetails() {
		List<UserDetail> userDetails = new ArrayList<UserDetail>();

		userDetails.add(new UserDetail(1, 10, "mock title 1", "abcde 1"));
		userDetails.add(new UserDetail(2, 11, "mock title 2", "abcde 2"));
		userDetails.add(new UserDetail(3, 12, "mock title 3", "abcde 3"));
		userDetails.add(new UserDetail(4, 13, "mock title 2", "abcde 4"));
		userDetails.add(new UserDetail(5, 14, "mock title 3", "abcde 5"));
		when(userDetailService.getUserDetails()).thenReturn(userDetails);

		assertEquals(5, userDetailService.getUserDetails().size());
	}

	@Test
	void testGetUniqueUsers() {
		List<UserDetail> uniqueUsers = new ArrayList<UserDetail>();
		uniqueUsers.add(new UserDetail(1, 10, "mock title 1", "abcde 1"));
		uniqueUsers.add(new UserDetail(2, 11, "mock title 2", "abcde 2"));
		uniqueUsers.add(new UserDetail(3, 12, "mock title 3", "abcde 3"));
		uniqueUsers.add(new UserDetail(4, 13, "mock title 4", "abcde 4"));

		when(userDetailService.getUniqueUsers()).thenReturn(uniqueUsers);

		assertEquals(4, userDetailService.getUniqueUsers().size());
	}

	@Test
	void testUpdateUserDetailsById() {
		List<UserDetail> userDetails = new ArrayList<UserDetail>();
		userDetails.add(new UserDetail(1, 10, "mock title 1", "abcde 1"));
		userDetails.add(new UserDetail(2, 11, "mock title 2", "abcde 2"));
		userDetails.add(new UserDetail(3, 12, "mock title 3", "abcde 3"));
		userDetails.add(new UserDetail(4, 13, "mock title 2", "abcde 4"));
		userDetails.add(new UserDetail(5, 14, "mock title 3", "abcde 5"));

		UserDetail updatedUserDetails = new UserDetail(4, 13, "1800Flowers", "1800Flowers");

		when(userDetailService.updateUserDetailsById(4, "1800Flowers")).thenReturn(updatedUserDetails);

		assertThat(updatedUserDetails.getTitle().equals("1800Flowers"));
	}

}

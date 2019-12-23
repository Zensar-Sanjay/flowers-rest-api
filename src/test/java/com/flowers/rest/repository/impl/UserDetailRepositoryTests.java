package com.flowers.rest.repository.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.flowers.rest.FlowersRestApiApplication;
import com.flowers.rest.beans.UserDetail;
import com.flowers.rest.repository.IUserDetailRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FlowersRestApiApplication.class)
class UserDetailRepositoryTests {

	@Autowired
	IUserDetailRepository userDetailRepository;

	@Test
	void testGetUserDetails() {
		List<UserDetail> userDetails = userDetailRepository.getUserDetails();
		assertTrue(!userDetails.isEmpty());
		assertNotNull(userDetails);
	}

}

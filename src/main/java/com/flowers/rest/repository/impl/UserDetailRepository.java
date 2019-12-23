package com.flowers.rest.repository.impl;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.flowers.rest.beans.UserDetail;
import com.flowers.rest.exception.RestClientCommunicationException;
import com.flowers.rest.repository.IUserDetailRepository;

@Repository
public class UserDetailRepository implements IUserDetailRepository {

	private static Logger logger = LoggerFactory.getLogger(UserDetailRepository.class);

	@Autowired
	RestTemplate restTemplate;

	@Value("${rest.client.url}")
	private String restClientURL;

	@Override
	public List<UserDetail> getUserDetails() {
		
		try {
			UserDetail[] userDetails = restTemplate.getForObject(restClientURL, UserDetail[].class);
			return Arrays.asList(userDetails);
		} catch (HttpClientErrorException | HttpServerErrorException errorException) {
			logger.error(String.format("%s %s",
					"Provided client API URL is down or temporary unavaliable or Syntax error with API URL",
					errorException.getStackTrace()));
			throw new RestClientCommunicationException(
					"Provided client API URL is down or temporary unavaliable or Syntax error with API URL");
		}
	}

}

package com.flowers.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.flowers")
public class RestTemplateConfig {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}

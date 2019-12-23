package com.flowers.test.flowersrestapi;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.flowers.rest.FlowersRestApiApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FlowersRestApiApplication.class)
class FlowersRestApiApplicationTests {

	@Test
	void contextLoads() {
		assert (true);
	}

}

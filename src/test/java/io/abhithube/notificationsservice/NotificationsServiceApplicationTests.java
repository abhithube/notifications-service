package io.abhithube.notificationsservice;

import io.abhithube.notificationsservice.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = TestConfig.class)
class NotificationsServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}

package me.socialid.contactManagement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import me.socialid.contactManagement.app.ContactManagementApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ContactManagementApplication.class)
@WebAppConfiguration
public class ContactManagementApplicationTests {

	@Test
	public void contextLoads() {
	}

}

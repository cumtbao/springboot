package com.shang;

import com.shang.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {
	@Autowired
	private MailService mailServiceImpl;

	@Test
	public void testSimpleMail() {

		try {
			mailServiceImpl.sendSimpleMail("shangbaobao@sunlands.com","test simple mail","hello this is simple mail");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

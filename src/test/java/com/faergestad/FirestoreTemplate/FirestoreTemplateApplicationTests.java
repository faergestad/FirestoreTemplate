package com.faergestad.FirestoreTemplate;

import com.faergestad.FirestoreTemplate.service.TestObject;
import com.faergestad.FirestoreTemplate.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FirestoreTemplateApplicationTests {

	@Autowired
	TestService testService;

	@Test
	void contextLoads() {
	}

	@Test
	public void test() {
		TestObject test = testService.test(new TestObject("This is sensitive", "This is NOT sensitive"));
		System.out.println(test);
	}

}

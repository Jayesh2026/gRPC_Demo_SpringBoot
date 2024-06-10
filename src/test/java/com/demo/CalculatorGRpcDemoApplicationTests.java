package com.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculatorGRpcDemoApplicationTests {

	@Test
	void contextLoads() {
		String expected = "test";
		String actual = "test";
		assertEquals(expected, actual);
	}

}

package com.pivotal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author NaveenWodeyar
 * @date 21-Sept-2024
 */
@RestController
@RequestMapping("/v1/test")
public class TestController {

	private static final Logger log = LoggerFactory.getLogger(TestController.class);
	
	public String javaVersion() {
		log.info("Java Version");
		return "\nJava Version-->"+System.getProperty("java.version");
	}
}

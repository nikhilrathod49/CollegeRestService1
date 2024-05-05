package com.javamastery.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CollegeController {

	@GetMapping("/searchBookByAuther/{autherName}")
	public String searchBookByAuther(@PathVariable("autherName") String autherName) {

		RestTemplate restTemplate = new RestTemplate();

		// ResponseEntity<String> response =
		// restTemplate.exchange("http://localhost:8081/library/findByAuther/{autherName}",
		// HttpMethod.GET,null,String.class,autherName);

		ResponseEntity<String> response = restTemplate
				.getForEntity("http://localhost:8081/library/findByAuther/{autherName}", String.class, autherName);

		return response.getBody();

	}

}

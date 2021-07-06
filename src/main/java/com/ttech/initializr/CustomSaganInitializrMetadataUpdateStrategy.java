package com.ttech.initializr;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.spring.initializr.web.support.SaganInitializrMetadataUpdateStrategy;

@Configuration
public class CustomSaganInitializrMetadataUpdateStrategy extends  SaganInitializrMetadataUpdateStrategy{

	private  RestTemplate restTemplate;

	private  ObjectMapper objectMapper;
	
	public CustomSaganInitializrMetadataUpdateStrategy(RestTemplate restTemplate, ObjectMapper objectMapper) {
		super(restTemplate, objectMapper);
		// TODO Auto-generated constructor stub
	}

}

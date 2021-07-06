package com.ttech.initializr;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.spring.initializr.generator.project.ProjectGenerationConfiguration;

@ProjectGenerationConfiguration
public class CustomInitializrConfiguration {

	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	@Bean
	public DockerContributor dockerContributor() {
		return new DockerContributor();
	}
	
	@Bean
	public GradleBuildCustomizer gradleBuildCustomizer() {
		return new GradleBuildCustomizer();
	}
	
}

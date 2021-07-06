package com.ttech.initializr;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.core.Ordered;

import io.spring.initializr.generator.project.contributor.ProjectContributor;

public class DockerContributor implements ProjectContributor {

	private String gistUrl;
	private String authHeaderValue;
	@Override
	public void contribute(Path projectRoot) throws IOException {
		Files.createDirectories(projectRoot.resolve("/src/main/docker"));
		//HttpURLConnection conn = createHttpURLConnection();
		//Files.copy(conn.getInputStream(), projectRoot.resolve("/src/main/docker/Dockerfile"));
		Path file = Files.createFile(projectRoot.resolve("hello.txt"));
		try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file))) {
			writer.println("Test");
		}
	}
	private HttpURLConnection createHttpURLConnection() throws IOException{
		HttpURLConnection conn = (HttpURLConnection) new URL(gistUrl).openConnection();
		conn.setRequestProperty("Authorization", authHeaderValue);
		
		return conn;
	}
	
	@Override
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE -20;
	}
	
}
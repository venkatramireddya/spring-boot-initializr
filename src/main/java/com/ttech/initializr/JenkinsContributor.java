package com.ttech.initializr;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.core.Ordered;

import io.spring.initializr.generator.project.contributor.ProjectContributor;

public class JenkinsContributor implements ProjectContributor {

	private String gistUrl;
	private String authHeaderValue;
	
	
	@Override
	public void contribute(Path projectRoot) throws IOException {
		
		Path file = Files.createFile(projectRoot.resolve("Jenkinsfile"));
		try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file))) {
			writer.println("pipeline {\r\n"
					+ "    agent any\r\n"
					+ "\r\n"
					+ "    stages {\r\n"
					+ "        stage('Deploy') {\r\n"
					+ "            when {\r\n"
					+ "              expression {\r\n"
					+ "                currentBuild.result == null || currentBuild.result == 'SUCCESS' \r\n"
					+ "              }\r\n"
					+ "            }\r\n"
					+ "            steps {\r\n"
					+ "                sh 'make publish'\r\n"
					+ "            }\r\n"
					+ "        }\r\n"
					+ "    }\r\n"
					+ "}");
		}
	}
	private HttpURLConnection createHttpURLConnection() throws IOException{
		HttpURLConnection conn = (HttpURLConnection) new URL(gistUrl).openConnection();
		conn.setRequestProperty("Authorization", authHeaderValue);
		
		return conn;
	}
	
	@Override
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE -30;
	}
	
}
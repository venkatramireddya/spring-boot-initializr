package com.ttech.initializr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class GistProperties {

	@Value("${git-base-url:https://gist.githubusercontent.com/venkatramireddya/dceba8f16798b7d07c6724d8bf274943/raw/0f522c7be93f40afd72c9a581d747ce182b64f84/dockerfile}")
	private String gitBaseUrl;
	
	private String gitCommitHash;

	public String getGitBaseUrl() {
		return gitBaseUrl;
	}

	public void setGitBaseUrl(String gitBaseUrl) {
		this.gitBaseUrl = gitBaseUrl;
	}

	public String getGitCommitHash() {
		return gitCommitHash;
	}

	public void setGitCommitHash(String gitCommitHash) {
		this.gitCommitHash = gitCommitHash;
	}
	
	
	
}

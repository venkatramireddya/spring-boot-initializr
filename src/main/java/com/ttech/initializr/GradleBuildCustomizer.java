package com.ttech.initializr;

import io.spring.initializr.generator.buildsystem.MavenRepository;
import io.spring.initializr.generator.buildsystem.gradle.GradleBuild;
import io.spring.initializr.generator.spring.build.BuildCustomizer;

public class GradleBuildCustomizer implements BuildCustomizer<GradleBuild> {

	@Override
	public void customize(GradleBuild build) {
		
		
		MavenRepository repo = MavenRepository.withIdAndUrl("ttech-maven-central", "https://repo.ttech.maven.com/maven").name("ttech-maven-central").build();
		build.repositories().add(repo);
		//build.repositories().remove("maven-central");		
	}

}

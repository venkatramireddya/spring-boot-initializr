package com.ttech.initializr;

import io.spring.initializr.generator.buildsystem.MavenRepository;
import io.spring.initializr.generator.buildsystem.gradle.GradleBuild;
import io.spring.initializr.generator.spring.build.BuildCustomizer;

public class GradleBuildCustomizer implements BuildCustomizer<GradleBuild> {

	@Override
	public void customize(GradleBuild build) {
		
		
		MavenRepository repo = MavenRepository.withIdAndUrl("hcl-maven-central", "https://repo.hcl.maven.com/maven").name("hcl-maven-central").build();
		build.repositories().add(repo);
		//build.repositories().remove("maven-central");		
	}

}

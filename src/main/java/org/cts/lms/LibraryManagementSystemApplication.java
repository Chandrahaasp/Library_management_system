package org.cts.lms;

import java.util.function.Predicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication(scanBasePackages = "org.cts.lms")
@EntityScan(basePackages = "org.cts.lms.entities")
@EnableJpaRepositories(basePackages = "org.cts.lms.repository")
@EnableOpenApi

public class LibraryManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}
	@Bean
	  public Docket openApiEmployeeStore() {
	    return new Docket(DocumentationType.OAS_30)
	        .groupName("open-api-libraryManagementSystem")
	        .select()
	        .apis(RequestHandlerSelectors.basePackage("org.cts.lms.controller"))
	        .paths(PathSelectors.any())
	        .build();
	  }

}

package com.assignment.cs.emp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author sanjib.pramanick
 *
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Orient DB Assignment APIs").description("Orient DB Assignment")
				.termsOfServiceUrl("").contact(new Contact("PXP-DEV Team", "", "sanjib.pramanick@contentserv.com"))
				.license("PXP-DEV Team").licenseUrl("sanjib.pramanick@contentserv.com").version("1.0").build();
	}

}

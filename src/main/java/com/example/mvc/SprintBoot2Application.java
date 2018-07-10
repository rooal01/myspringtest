package com.example.mvc;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class SprintBoot2Application {

	public static void main(String[] args) {
		SpringApplication.run(SprintBoot2Application.class, args);
	}
	
//Added for swagger to access use the following urls
//	http://localhost:8080/swagger-ui.html
//
//http://localhost:8080/v2/api-docs
	@EnableSwagger2
	public class SwaggerConfig {                                    
	    @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.any())              
	          .paths(PathSelectors.any())                          
	          .build()
	          .apiInfo(apiInfo());                                           
	    }
	    
		private ApiInfo apiInfo() {
		     return new ApiInfo(
		       "Alans API Tests", 
		       "User Management API.", 
		       "API XXXXXX", 
		       "Terms of service", 
		       new Contact("Alan Rooney", "www.example.com", "rooal01@ca.com"), 
		       "License of API", "API license URL", Collections.emptyList());
		}
	}
	
	
	}

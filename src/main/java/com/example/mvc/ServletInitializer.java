package com.example.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MappingJackson2XmlView;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan("com.example.mvc")
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SprintBoot2Application.class);
	}
	
	// Not needed.Just needed to add com.fasterxml.jackson entries to POM
	
//	@Bean
//	public ViewResolver contentNegotiatingViewResolver() {
//	    ContentNegotiatingViewResolver resolver =
//	            new ContentNegotiatingViewResolver();
//
//	    List<View> views = new ArrayList<>();
//	    views.add(new MappingJackson2XmlView());
//	    views.add(new MappingJackson2JsonView());
//
//	    resolver.setDefaultViews(views);
//	    return resolver;
//	}


}

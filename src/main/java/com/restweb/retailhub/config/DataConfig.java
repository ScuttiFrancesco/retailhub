package com.restweb.retailhub.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class DataConfig {

	@Bean
	public ModelMapper getModelMapper() {

		ModelMapper modelMapper = new ModelMapper();

		return modelMapper;
	}

	@Bean
	public OpenAPI getSwagger() {

		return new OpenAPI()
				
				.info(new Info()
						.title("Servizi Rest Dto")
						.description("Api Rest per gestione attività")
						.termsOfService("http://www......")
				
				.contact(new io.swagger.v3.oas.models.info.Contact()
						.name("Support Api")
						.email("scufranc@yahoo.com"))
				
				.license(new License()
						.name("Licence Api 1.0")
						.url("http://www......")));

	}
}

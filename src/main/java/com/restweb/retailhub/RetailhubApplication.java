package com.restweb.retailhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.restweb.retailhub.cliente.Cliente;

@SpringBootApplication
public class RetailhubApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailhubApplication.class, args);
				
		
	}
	// http://localhost:8080/swagger-ui/index.html ------
	// http://localhost:8080/v3/api-docs

}

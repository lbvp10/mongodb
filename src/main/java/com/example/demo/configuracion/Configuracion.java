package com.example.demo.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class Configuracion {

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}

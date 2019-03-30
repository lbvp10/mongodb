package com.example.demo.persona;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Document(collection = "users")

@JsonPropertyOrder({"id", "nombre"})
@Data
public class Persona {
	@Id
	private String id;
	private String nombre;
	private String apellidos;

}

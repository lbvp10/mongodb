package com.example.demo.persona;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;


@SuppressWarnings("serial")
@JsonPropertyOrder({"id", "nombre","apellidos"})
@Data
public class PersonaDTO implements Serializable{

	@NotNull
	private String id;
	
	@NotEmpty
	private String nombre;
	
	private String apellidos;

}

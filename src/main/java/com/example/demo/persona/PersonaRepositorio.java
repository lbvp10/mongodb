package com.example.demo.persona;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonaRepositorio extends MongoRepository<Persona, String> {

	List<Persona> findByNombre(String nombre);
	List<Persona> findByApellidos(String apellidos);
}

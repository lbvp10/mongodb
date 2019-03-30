package com.example.demo.persona;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class PersonaControlador {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private PersonaRepositorio personaRepositorio;

	@PostMapping("/persona")
	public ResponseEntity<Boolean> guardarPersona(@RequestBody PersonaDTO personaDTO) {
		personaRepositorio.save(objectMapper.convertValue(personaDTO, Persona.class));
		return ResponseEntity.ok(true);
	}

	@GetMapping("/persona")
	public ResponseEntity<List<PersonaDTO>> obtenerPersonas() {
		List<PersonaDTO> personasDTO = personaRepositorio.findAll().parallelStream()
				.map(a -> objectMapper.convertValue(a, PersonaDTO.class)).collect(Collectors.toList());

		return ResponseEntity.ok(personasDTO);
	}

	@GetMapping("/persona/{nombre}")
	public ResponseEntity<List<PersonaDTO>> buscarPersonaPorNombre(@PathVariable("nombre") String nombre) {
		
		List<PersonaDTO> personasDTO = personaRepositorio.findByNombre(nombre).parallelStream()
				.map(a -> objectMapper.convertValue(a, PersonaDTO.class)).collect(Collectors.toList());
		
		return ResponseEntity.ok(personasDTO);

	}

}

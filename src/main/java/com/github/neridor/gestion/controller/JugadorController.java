package com.github.neridor.gestion.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.neridor.gestion.dto.JugadorDto;
import com.github.neridor.gestion.service.JugadorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/jugador")
public class JugadorController {

	private final JugadorService service;

	@GetMapping
	public ResponseEntity<List<JugadorDto>> listarJugadores() {
		List<JugadorDto> jugadores = service.listarJugadores();
		return ResponseEntity.ok(jugadores);
	}

	@PostMapping("/crear")
	public ResponseEntity<Long> crearJugador(@Valid @RequestBody JugadorDto jugadorDto) {
		return ResponseEntity.ok(service.addJugador(jugadorDto));
	}

	@PutMapping("/modificar")
	public ResponseEntity<JugadorDto> updateJugador(@Valid @RequestBody JugadorDto jugadorDto) {
		if (service.updateJugador(jugadorDto)) {
			return ResponseEntity.ok(jugadorDto);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/borrar")
	public ResponseEntity<JugadorDto> deleteJugador(@RequestParam(required = true) long id) {
		if (service.deleteJugador(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/buscar")
	public ResponseEntity<JugadorDto> buscar(@RequestParam(required = true) long id) {
		JugadorDto jugadorDto = service.buscar(id);
		if (jugadorDto != null) {
			return ResponseEntity.ok(jugadorDto);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/buscarByDificultad")
	public ResponseEntity<List<JugadorDto>> buscarByDificultad(@RequestParam(required = true) int dificultad) {
		return ResponseEntity.ok(service.buscarByDificultad(dificultad));
	}
}

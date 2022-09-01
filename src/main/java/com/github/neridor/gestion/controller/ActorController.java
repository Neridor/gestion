package com.github.neridor.gestion.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.neridor.gestion.dto.ActorDto;
import com.github.neridor.gestion.service.ActorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/actor")
public class ActorController {
	private final ActorService service;

	@GetMapping
	public ResponseEntity<List<ActorDto>> listarActores() {
		return ResponseEntity.ok(service.listarActores());
	}

	@GetMapping(path = "/buscar")
	public ResponseEntity<ActorDto> buscar(@RequestParam(required = true) long id) {
		ActorDto actorDto = service.buscar(id);
		if (actorDto != null) {
			return ResponseEntity.ok(actorDto);
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping(path = "/modificar")
	public ResponseEntity<ActorDto> actualizarActor(@Valid @RequestBody ActorDto actorDto) {
		if (service.actualizarActor(actorDto)) {
			return ResponseEntity.ok(actorDto);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping(path = "/mercado")
	public ResponseEntity<List<ActorDto>> actoresEnMercado() {
		return ResponseEntity.ok(service.actoresEnMercado());
	}
}

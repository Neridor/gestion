package com.github.neridor.gestion.service;

import java.util.List;

import com.github.neridor.gestion.dto.ActorDto;

public interface ActorService {
	List<ActorDto> listarActores();

	ActorDto buscar(long id);

	boolean actualizarActor(ActorDto actorDto);

	List<ActorDto> actoresEnMercado();
}

package com.github.neridor.gestion.service;

import java.util.List;

import com.github.neridor.gestion.dto.JugadorDto;

public interface JugadorService {

	List<JugadorDto> listarJugadores();

	Long addJugador(JugadorDto jugadorDto);

	boolean updateJugador(JugadorDto jugadorDto);

	boolean deleteJugador(Long id);

	JugadorDto buscar(Long id);

	List<JugadorDto> buscarByDificultad(int dificultad);
}

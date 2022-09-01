package com.github.neridor.gestion.mapper;

import org.mapstruct.Mapper;

import com.github.neridor.gestion.domain.Jugador;
import com.github.neridor.gestion.dto.JugadorDto;

@Mapper
public interface JugadorMapper {

	Jugador dtoToJugador(JugadorDto dto);

	JugadorDto jugadorToDto(Jugador jugador);
}

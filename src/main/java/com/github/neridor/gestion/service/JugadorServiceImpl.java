package com.github.neridor.gestion.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.neridor.gestion.domain.Jugador;
import com.github.neridor.gestion.dto.JugadorDto;
import com.github.neridor.gestion.mapper.JugadorMapper;
import com.github.neridor.gestion.repository.JugadorRepository;

@Service
public class JugadorServiceImpl implements JugadorService {
	@Autowired
	private JugadorRepository repo;
	@Autowired
	private JugadorMapper jugadorMapper;

	@Override
	public List<JugadorDto> listarJugadores() {
		return repo.findAll().stream().map(jugadorMapper::jugadorToDto).collect(Collectors.toList());
	}

	@Override
	public Long addJugador(JugadorDto jugadorDto) {
		Jugador nuevoJugador = jugadorMapper.dtoToJugador(jugadorDto);
		nuevoJugador.setId(null);
		repo.save(nuevoJugador);
		return nuevoJugador.getId();
	}

	@Override
	public boolean updateJugador(JugadorDto jugadorDto) {
		Optional<Jugador> jugador = repo.findById(jugadorDto.getId());
		if (jugador.isPresent()) {
			repo.save(jugadorMapper.dtoToJugador(jugadorDto));
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteJugador(Long id) {
		Optional<Jugador> jugador = repo.findById(id);
		if (jugador.isPresent()) {
			repo.delete(jugador.get());
			return true;
		}
		return false;
	}

	@Override
	public JugadorDto buscar(Long id) {
		Optional<Jugador> jugador = repo.findById(id);
		if (jugador.isPresent()) {
			return jugadorMapper.jugadorToDto(jugador.get());
		}
		return null;
	}

	@Override
	public List<JugadorDto> buscarByDificultad(int dificultad) {
		return repo.buscarByDificultad(dificultad).stream().map(jugadorMapper::jugadorToDto)
				.collect(Collectors.toList());
	}
}

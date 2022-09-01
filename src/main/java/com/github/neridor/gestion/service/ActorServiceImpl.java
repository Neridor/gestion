package com.github.neridor.gestion.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.neridor.gestion.domain.Actor;
import com.github.neridor.gestion.dto.ActorDto;
import com.github.neridor.gestion.mapper.ActorMapper;
import com.github.neridor.gestion.repository.ActorRepository;

@Service
public class ActorServiceImpl implements ActorService {
	@Autowired
	private ActorRepository repo;
	@Autowired
	private ActorMapper actorMapper;

	@Override
	public List<ActorDto> listarActores() {
		return repo.findAll().stream().map(actorMapper::actorToDto).collect(Collectors.toList());
	}

	@Override
	public ActorDto buscar(long id) {
		Optional<Actor> actor = repo.findById(id);
		if (actor.isPresent()) {
			return actorMapper.actorToDto(actor.get());
		}
		return null;
	}

	@Override
	public boolean actualizarActor(ActorDto actorDto) {
		Optional<Actor> actor = repo.findById(actorDto.getId());
		if (actor.isPresent()) {
			repo.save(actorMapper.dtoToActor(actorDto));
			return true;
		}
		return false;
	}

	@Override
	public List<ActorDto> actoresEnMercado() {
		return repo.actoresEnMercado().stream().map(actorMapper::actorToDto).collect(Collectors.toList());
	}

}

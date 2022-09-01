package com.github.neridor.gestion.mapper;

import org.mapstruct.Mapper;

import com.github.neridor.gestion.domain.Actor;
import com.github.neridor.gestion.dto.ActorDto;

@Mapper
public interface ActorMapper {
	Actor dtoToActor(ActorDto dto);

	ActorDto actorToDto(Actor actor);

}

package com.github.neridor.gestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.github.neridor.gestion.domain.Actor;

public interface ActorRepository extends JpaRepository<Actor, Long> {

	@Query("SELECT a FROM Actor a WHERE a.estudio < 0")
	List<Actor> actoresEnMercado();
}

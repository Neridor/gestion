package com.github.neridor.gestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.github.neridor.gestion.domain.Jugador;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {

	@Query("SELECT j FROM Jugador j WHERE j.dificultad <= :dificultad")
	List<Jugador> buscarByDificultad(@Param("dificultad") int dificultad);
}

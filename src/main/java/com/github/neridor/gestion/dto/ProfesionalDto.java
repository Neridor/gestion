package com.github.neridor.gestion.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ProfesionalDto {
	private Long id;
	@NotNull
	private String nombre;
	@NotNull
	private Double sueldo;
	@NotNull
	private Integer accion;
	@NotNull
	private Integer thriller;
	@NotNull
	private Integer comedia;
	@NotNull
	private Integer drama;
	@NotNull
	private Integer estudio;
	private Integer idext;
	private String urlfoto;
	private Integer bonus;
	private Integer pareja;
	private LocalDateTime fecha;
}

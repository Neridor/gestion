package com.github.neridor.gestion.domain;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode
public abstract class Profesional {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Exclude
	private Long id;
	private String nombre;
	private Double sueldo;
	private Integer accion;
	private Integer thriller;
	private Integer comedia;
	private Integer drama;
	private Integer estudio;
	private Integer idext;
	private String urlfoto;
	private Integer bonus;
	private Integer pareja;
	private LocalDateTime fecha;
}

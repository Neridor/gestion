package com.github.neridor.gestion.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Jugador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Exclude
	private Long id;
	private String nombre;
	private String password;
	private Double dinero;
	private Integer suerte;
	private Integer sexo;
	private String user;
	private Integer mp;
	private Integer dificultad;
	private Integer coproductora;
	private Integer filial;
	private Integer nivel;
	private Integer prestigio;
	private String persona;
}

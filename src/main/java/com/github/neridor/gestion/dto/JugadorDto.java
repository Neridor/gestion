package com.github.neridor.gestion.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class JugadorDto {
	private Long id;
	@NotNull
	private String nombre;
	@NotNull
	private String password;
	@NotNull
	private Double dinero;
	@NotNull
	private Integer suerte;
	@NotNull
	private Integer sexo;
	@NotNull
	private String user;
	@NotNull
	private Integer mp;
	@NotNull
	@Min(0)
	@Max(5)
	private Integer dificultad;
	private Integer coproductora;
	private Integer filial;
	@NotNull
	@Min(1)
	@Max(7)
	private Integer nivel;
	@NotNull
	private Integer prestigio;
	private String persona;
}

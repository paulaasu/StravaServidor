package dto;

import java.io.Serializable;
import java.util.Date;

import domain.Usuario;

public class EntrenamientoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String titulo;
	private String deporte;
	private int distanciaKm;
	private Date fecha_ini;	
	private int hora;	
	private int duracion;
	private Usuario creador;
}

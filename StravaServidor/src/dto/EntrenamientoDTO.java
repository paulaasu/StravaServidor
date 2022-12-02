package dto;

import java.io.Serializable;

public class EntrenamientoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String titulo;
	private TipoDeporteDTO deporte;
	private int distanciaKm;
	private String fecha_ini;	
	private int hora;	
	private int duracion;
	private int creador;
	
	
	
	
	public EntrenamientoDTO(String titulo, TipoDeporteDTO deporte, int distanciaKm, String fecha_ini, int hora, int duracion,
			int creador) {
		super();
		this.titulo = titulo;
		this.deporte = deporte;
		this.distanciaKm = distanciaKm;
		this.fecha_ini = fecha_ini;
		this.hora = hora;
		this.duracion = duracion;
		this.creador = creador;
	}
	
	public EntrenamientoDTO() {
		super();
		this.titulo = "";
		this.deporte = null;
		this.distanciaKm = 0;
		this.fecha_ini = "";
		this.hora = 0;
		this.duracion = 0;
		this.creador = 0;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public TipoDeporteDTO getDeporte() {
		return deporte;
	}

	public void setDeporte(TipoDeporteDTO deporte) {
		this.deporte = deporte;
	}

	public int getDistanciaKm() {
		return distanciaKm;
	}
	public void setDistanciaKm(int distanciaKm) {
		this.distanciaKm = distanciaKm;
	}
	public String getFecha_ini() {
		return fecha_ini;
	}
	public void setFecha_ini(String fecha_ini) {
		this.fecha_ini = fecha_ini;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public int getCreador() {
		return creador;
	}
	public void setCreador(int creador) {
		this.creador = creador;
	}

	@Override
	public String toString() {
		return "EntrenamientoDTO [titulo=" + titulo + ", deporte=" + deporte + ", distanciaKm=" + distanciaKm
				+ ", fecha_ini=" + fecha_ini + ", hora=" + hora + ", duracion=" + duracion + ", creador=" + creador
				+ "]";
	}
	
}

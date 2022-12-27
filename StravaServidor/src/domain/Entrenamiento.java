package domain;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import domain.Usuario;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Entrenamiento {
	private String titulo;
	private TipoDeporte deporte;
	private int distanciaKm;
	private String fecha_ini;	
	private int hora;	
	private int duracion;
	private int creador; //el usuario que crea el entrenamiento
	
	
	
	public Entrenamiento(String titulo, TipoDeporte deporte, int distanciaKm, String fecha_ini, int hora, int duracion, int creador) {
		super();
		this.titulo = titulo;
		this.deporte = deporte;
		this.distanciaKm = distanciaKm;
		this.fecha_ini = fecha_ini;
		this.hora = hora;
		this.duracion = duracion;
		this.creador= creador;
		//usuario u1, entrenamiento e1 -->e1.setCreador(u1);
	}
	public Entrenamiento() {
		super();
		this.titulo = "";
		this.deporte = null;
		this.distanciaKm = 0;
		this.fecha_ini = "";
		this.hora = 0;
		this.duracion = 0;
		this.creador= 0;
		//usuario u1, entrenamiento e1 -->e1.setCreador(u1);
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public TipoDeporte getDeporte() {
		return deporte;
	}
	public void setDeporte(TipoDeporte deporte) {
		this.deporte = deporte;
	}
	public void setCreador(int creador) {
		this.creador = creador;
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
	public void setCreador(Usuario creador) {
		this.creador = creador.getNumero();
	}
	@Override
	public String toString() {
		return "Entrenamiento [titulo=" + titulo + ", deporte=" + deporte + ", distanciaKm=" + distanciaKm
				+ ", fecha_ini=" + fecha_ini + ", hora=" + hora + ", duracion=" + duracion + ", creador=" + creador
				+ "]";
	}

}

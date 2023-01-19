package domain;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import domain.Usuario;

@PersistenceCapable(detachable = "true")
public class Reto {
	private String nombre;
	private String descripcion;
	private String fecha_ini;
	private String fecha_fin;	
	private int distancia;
	private TipoDeporte deporte;
	
	@Join
	@Persistent(defaultFetchGroup = "true")
	private Usuario creador;
	
	
	public Reto(String nombre, String descripcion, String fecha_ini, String fecha_fin, int distancia,
			TipoDeporte deporte, Usuario creador) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha_ini = fecha_ini;
		this.fecha_fin = fecha_fin;
		this.distancia = distancia;
		this.deporte = deporte;
		this.creador = creador;
	}
	public Reto() {
		super();
		this.nombre = "";
		this.descripcion = "";
		this.fecha_ini = null;
		this.fecha_fin = null;
		this.distancia = 0;
		this.deporte = null;
		this.creador = null;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha_ini() {
		return fecha_ini;
	}
	public void setFecha_ini(String fecha_ini) {
		this.fecha_ini = fecha_ini;
	}
	public String getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	public TipoDeporte getDeporte() {
		return deporte;
	}
	public void setDeporte(TipoDeporte deporte) {
		this.deporte = deporte;
	}
	public Usuario getCreador() {
		return creador;
	}
	public void setCreador(Usuario creador) {
		this.creador = creador;
	}
	@Override
	public String toString() {
		return "Reto [nombre=" + nombre + ", descripcion=" + descripcion + ", fecha_ini=" + fecha_ini + ", fecha_fin="
				+ fecha_fin + ", distancia=" + distancia + ", deporte=" + deporte + ", creador=" + creador + "]";
	}
	
	
}

package dto;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import domain.Usuario;

public class RetoDTO implements Serializable {
	private String nombre;
	private Date fecha_ini; //duda: Date o String?
	private Date fecha_fin;	
	private int distancia;
	private long tiempoObjetivo;
	private String deporte;
	private int creador;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecha_ini() {
		return fecha_ini;
	}
	public void setFecha_ini(Date fecha_ini) {
		this.fecha_ini = fecha_ini;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	public long getTiempoObjetivo() {
		return tiempoObjetivo;
	}
	public void setTiempoObjetivo(long tiempoObjetivo) {
		this.tiempoObjetivo = tiempoObjetivo;
	}
	public String getDeporte() {
		return deporte;
	}
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	
	public int getCreador() {
		return creador;
	}
	public void setCreador(int creador) {
		this.creador = creador;
	}
	@Override
	public String toString() {
		return "RetoDTO [nombre=" + nombre + ", fecha_ini=" + fecha_ini + ", fecha_fin=" + fecha_fin + ", distancia="
				+ distancia + ", tiempoObjetivo=" + tiempoObjetivo + ", deporte=" + deporte + ", creador=" + creador
				+ "]";
	}


}

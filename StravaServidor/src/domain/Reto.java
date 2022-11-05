package domain;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import domain.Usuario;

public class Reto {
	private String nombre;
	private Date fecha_ini; //duda: Date o String?
	private Date fecha_fin;	
	private int distancia;
	private long tiempoObjetivo;
	private String deporte;
	Usuario creador;
	
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
	
	
	public Usuario getCreador() {
		return creador;
	}
	public void setCreador(Usuario creador) {
		this.creador = creador;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-YY - hh:mm");
		NumberFormat numberFormatter = NumberFormat.getCurrencyInstance(Locale.getDefault()); 

		
		StringBuffer result = new StringBuffer("Titulo:");
		
		result.append(this.getNombre());
		result.append(" - Deporte:");
		result.append(this.getDeporte());
		result.append(" - Fecha Inicio:");
		result.append(dateFormatter.format(this.fecha_ini));
		result.append(" - Fecha Fin:");
		result.append(dateFormatter.format(this.fecha_fin));
		result.append(" - Distancia:");
		result.append(numberFormatter.format(this.distancia));
		result.append(" - Tiempo Objetivo:");
		result.append(numberFormatter.format(this.tiempoObjetivo));
		result.append(" - Creador:");
		result.append(this.creador.getNombre());
		
		return result.toString();
	}


}

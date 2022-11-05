package domain;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import domain.Usuario;

public class Entrenamiento {
	private String titulo;
	private String deporte;
	private int distanciaKm;
	private Date fecha_ini;	
	private int hora;	
	private int duracion;
	private Usuario creador; //el usuario que crea el entrenamiento
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDeporte() {
		return deporte;
	}
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	public int getDistanciaKm() {
		return distanciaKm;
	}
	public void setDistanciaKm(int distanciaKm) {
		this.distanciaKm = distanciaKm;
	}
	public Date getFecha_ini() {
		return fecha_ini;
	}
	public void setFecha_ini(Date fecha_ini) {
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
	
	
	public Usuario getCreador() {
		return creador;
	}
	public void setCreador(Usuario creador) {
		this.creador = creador;
	}
	@Override //imprime el entrenamiento
	public String toString() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-YY - hh:mm");
		
		NumberFormat numberFormatter = NumberFormat.getCurrencyInstance(Locale.getDefault()); 

		StringBuffer result = new StringBuffer();
		
		result.append(this.titulo);
		result.append(" - ");
		result.append(this.deporte);
		result.append(" (distancia (km):");
		result.append(this.distanciaKm);
		result.append(", fecha: ");
		result.append(this.distanciaKm);
		result.append(", duracion: ");
		result.append(this.duracion);
		result.append(" ) ");
		
		return result.toString();		
	}
	
/*	@Override
	public boolean equals(Object obj) {
		if (this.getClass().getName().equals(obj.getClass().getName())) {
			return this.number == ((Article)obj).number;
		}
		
		return false;
	}*/

}

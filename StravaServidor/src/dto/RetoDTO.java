package dto;

import java.io.Serializable;

public class RetoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String descripcion;
	private String fecha_ini; //duda: Date o String?
	private String fecha_fin;	
	private int distancia;
	private TipoDeporteDTO deporte;
	private int creador;

	
	public RetoDTO(String nombre, String descripcion, String fecha_ini, String fecha_fin, int distancia, TipoDeporteDTO deporte, int creador) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha_ini = fecha_ini;
		this.fecha_fin = fecha_fin;
		this.distancia = distancia;
		this.deporte = deporte;
		this.creador = creador;
	}
	
	public RetoDTO() {
		super();
		this.nombre = "";
		this.descripcion = "";
		this.fecha_ini = "";
		this.fecha_fin = "";
		this.distancia = 0;
		this.deporte = null;
		this.creador = 0;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public TipoDeporteDTO getDeporte() {
		return deporte;
	}

	public void setDeporte(TipoDeporteDTO deporte) {
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
		return "RetoDTO [nombre=" + nombre + ", descripcion=" + descripcion + ", fecha_ini=" + fecha_ini
				+ ", fecha_fin=" + fecha_fin + ", distancia=" + distancia + ", deporte=" + deporte + ", creador="
				+ creador + "]";
	}

}

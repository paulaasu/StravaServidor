package dto;

import java.io.Serializable;

import domain.TipoUsuario;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int numero; //ID
	private String nombre;
	private String email;
	private float pesoKG;
	private float altura;
	private float frecCardMax;
	private float frecCardResposo;
	private TipoUsuario tipoUsuario;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public float getPesoKG() {
		return pesoKG;
	}
	public void setPesoKG(float pesoKG) {
		this.pesoKG = pesoKG;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public float getFrecCardMax() {
		return frecCardMax;
	}
	public void setFrecCardMax(float frecCardMax) {
		this.frecCardMax = frecCardMax;
	}
	public float getFrecCardResposo() {
		return frecCardResposo;
	}
	public void setFrecCardResposo(float frecCardResposo) {
		this.frecCardResposo = frecCardResposo;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	
	
}

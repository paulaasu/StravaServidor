package dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int numero; //ID
	private String nombre;
	private String email;
	private float pesoKG;
	private float altura;
	private float frecCardMax;
	private float frecCardResposo;
	private TipoUsuarioDTO tipoUsuario;
	
	public UsuarioDTO(int numero, String nombre, String email, float pesoKG, float altura, float frecCardMax,
			float frecCardResposo, TipoUsuarioDTO tipoUsuario) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.email = email;
		this.pesoKG = pesoKG;
		this.altura = altura;
		this.frecCardMax = frecCardMax;
		this.frecCardResposo = frecCardResposo;
		this.tipoUsuario = tipoUsuario;
	}
	
	public UsuarioDTO() {
		super();
		this.numero = 0;
		this.nombre = "";
		this.email = "";
		this.pesoKG = 0;
		this.altura = 0;
		this.frecCardMax = 0;
		this.frecCardResposo = 0;
		this.tipoUsuario = tipoUsuario;
	}
	
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
	public TipoUsuarioDTO getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuarioDTO tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	
	
}

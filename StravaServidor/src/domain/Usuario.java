package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;

import domain.TipoUsuario;

@PersistenceCapable(detachable="true")
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Usuario {
	public static int contador=1;
	private int numero; //ID
	private String nombre;
	private String email;
	private float pesoKG;
	private float altura;
	private float frecCardMax;
	private float frecCardResposo;
	private TipoUsuario tipoUsuario;
	private List<Reto> retos = new ArrayList<>();
	
	
public Usuario(String nombre, String email, float pesoKG, float altura, float frecCardMax,
			float frecCardResposo, TipoUsuario tipoUsuario, List<Reto> retos) {
		super();
		this.numero = Usuario.contador;
		Usuario.contador++;
		this.nombre = nombre;
		this.email = email;
		this.pesoKG = pesoKG;
		this.altura = altura;
		this.frecCardMax = frecCardMax;
		this.frecCardResposo = frecCardResposo;
		this.tipoUsuario = tipoUsuario;
		this.retos = retos;
	}

public Usuario() {
	super();
	this.numero = Usuario.contador;
	Usuario.contador++;
	this.nombre = "";
	this.email = "";
	this.pesoKG = 0;
	this.altura = 0;
	this.frecCardMax = 0;
	this.frecCardResposo = 0;
	this.tipoUsuario = null;
	this.retos = null;
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
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	//retos
	public List<Reto> getRetos() {
		return retos;
	}
	public void setRetos(List<Reto> retos) {
		this.retos = retos;
	}
	public void addReto(Reto reto) { //añadir reto a la lista de retos
		if (reto != null && !this.retos.contains(reto)) {
			this.retos.add(reto);
		}
	}
	
	
	
	
	@Override
	public String toString() {
		return "Usuario [numero=" + numero + ", nombre=" + nombre + ", email=" + email + ", pesoKG=" + pesoKG
				+ ", altura=" + altura + ", frecCardMax=" + frecCardMax + ", frecCardResposo=" + frecCardResposo
				+ ", tipoUsuario=" + tipoUsuario + ", retos=" + retos + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (Float.floatToIntBits(altura) != Float.floatToIntBits(other.altura))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (Float.floatToIntBits(frecCardMax) != Float.floatToIntBits(other.frecCardMax))
			return false;
		if (Float.floatToIntBits(frecCardResposo) != Float.floatToIntBits(other.frecCardResposo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numero != other.numero)
			return false;
		if (Float.floatToIntBits(pesoKG) != Float.floatToIntBits(other.pesoKG))
			return false;
		if (retos == null) {
			if (other.retos != null)
				return false;
		} else if (!retos.equals(other.retos))
			return false;
		if (tipoUsuario != other.tipoUsuario)
			return false;
		return true;
	}
	
}

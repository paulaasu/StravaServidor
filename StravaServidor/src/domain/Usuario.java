package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.TipoUsuario;


public class Usuario {
	private int numero; //ID????
	private String nombre;
	private String email;
	private float pesoKG;
	private float altura;
	private float frecCardMax;
	private float frecCardResposo;
	private TipoUsuario tipoUsuario;
	//private List<Entrenamiento> entrenamientos = new ArrayList<>(); //ESTO NOSE SI ESTA BN
	private List<Reto> retos = new ArrayList<>();
	
	
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
	/*	//entrenamientos
	public List<Entrenamiento> getEntrenamientos() {
		return entrenamientos;
	}
	public void setEntrenamientos(List<Entrenamiento> entrenamientos) {
		this.entrenamientos = entrenamientos;
	}
	
	public void addEntrenamiento(Entrenamiento entrenamiento) { //añadir entrenamiento a la lista de entrenamientos
		if (entrenamiento != null && !this.entrenamientos.contains(entrenamiento)) {
			this.entrenamientos.add(entrenamiento);
		}
	}
*/
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
	
/*	@Override
	public String toString() { //te imprime el usuario
		NO ESTA HECHO
	}
	*/
	
/*	@Override //te comprueba si son el mismo tipo de clase u objeto NOSE
	public boolean equals(Object obj) {
		if (this.getClass().getName().equals(obj.getClass().getName())) {
			return this.email.equals(((User)obj).email);
		}
		
		return false;
	}*/
	
}

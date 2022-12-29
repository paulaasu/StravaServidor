package domain;

import java.util.List;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable="true")
public class UsuarioGmail extends Usuario {

	public String password;

	
	public UsuarioGmail(String nombre, String email, float pesoKG, float altura, float frecCardMax,
			float frecCardResposo, TipoUsuario tipoUsuario, List<Reto> retos, String password) {
		super(nombre, email, pesoKG, altura, frecCardMax, frecCardResposo, tipoUsuario, retos);
		this.password = password;
	}
	

	public UsuarioGmail() {
		super();
		this.password = "";
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "UsuarioGmail [password=" + password + ", getNumero()=" + getNumero() + ", getNombre()=" + getNombre()
				+ ", getEmail()=" + getEmail() + ", getPesoKG()=" + getPesoKG() + ", getAltura()=" + getAltura()
				+ ", getFrecCardMax()=" + getFrecCardMax() + ", getFrecCardResposo()=" + getFrecCardResposo()
				+ ", getTipoUsuario()=" + getTipoUsuario() + ", getRetos()=" + getRetos() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	
}

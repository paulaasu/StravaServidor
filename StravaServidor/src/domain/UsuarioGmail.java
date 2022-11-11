package domain;

import java.util.List;

public class UsuarioGmail extends Usuario {

	public String password;

	
	public UsuarioGmail(int numero, String nombre, String email, float pesoKG, float altura, float frecCardMax,
			float frecCardResposo, TipoUsuario tipoUsuario, List<Reto> retos, String password) {
		super(numero, nombre, email, pesoKG, altura, frecCardMax, frecCardResposo, tipoUsuario, retos);
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
	
}

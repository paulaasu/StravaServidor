package services;

import dto.EntrenamientoAssembler;
import dto.TipoUsuarioDTO;
import dto.UsuarioAssembler;
import dto.UsuarioDTO;
import gateway.GoogleGateway;
import domain.Usuario;
import domain.UsuarioGmail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import domain.Entrenamiento;
import domain.Reto;
import domain.TipoDeporte;
import domain.TipoUsuario;

//TODO: Implement Singleton Pattern
public class LoginAppService {
	private List<Usuario> listaUsuarios = new ArrayList<>();
	private List<UsuarioGmail> listaUsuariosGmail = new ArrayList<>();
	public static LoginAppService instance;
	//private UsuarioAssembler assembler=UsuarioAssembler.getInstance();
	public LoginAppService() {
		this.initilizeDataLogin();
	}

	private void initilizeDataLogin() {
		// Create Users
		UsuarioGmail user0 = new UsuarioGmail();
		user0.setEmail("a");
		user0.setNombre("a");
		user0.setPassword("a");
		List<Reto> a = new ArrayList<>();
		user0.setRetos(a);

		UsuarioGmail user1 = new UsuarioGmail();
		user1.setEmail("b");
		user1.setNombre("b");
		user1.setPassword("b");
		List<Reto> b = new ArrayList<>();
		user1.setRetos(b);

		listaUsuariosGmail.add(user0);
		listaUsuariosGmail.add(user1);

	}
	
	
	
	public static LoginAppService getInstance() {
		if (instance == null) {
			instance = new LoginAppService();
		}

		return instance;
	}
	
	public Usuario loginFacebook(String email, String nickName) {
		Usuario u = new Usuario();
		for (Usuario usu : listaUsuarios) {
			if (usu.getEmail().equals(email) && usu.getNombre().equals(nickName)) {
				return usu;

			}
		}
		return u;
	}

	public Usuario loginGoogle(String email, String nickName) {
		Usuario u = new Usuario();
		for (Usuario usu : listaUsuarios) {
			if (usu.getEmail().equals(email) && usu.getNombre().equals(nickName)) {
				return usu;

			}
		}
		return u;
	}

	public UsuarioGmail loginGmail(String email, String password, String nickName) {

		UsuarioGmail u = new UsuarioGmail();

		
		for (UsuarioGmail usu : listaUsuariosGmail) {
			if (usu.getEmail().equals(email) && usu.getNombre().equals(nickName)
					&& usu.getPassword().equals(password)) {
				return usu;
		}
		
		}
		return u;
	}

	public boolean registrarObligatorio(String email, String password, String nickName, TipoUsuarioDTO tipoUsuarioDTO) {
		
		try {
			UsuarioGmail u = new UsuarioGmail();
			u.setEmail(email);
			u.setNombre(nickName);
			u.setPassword(password);
			u.setTipoUsuario(TipoUsuario.EMAIL);
			List<Reto> reto = new ArrayList<>();
			u.setRetos(reto);

			System.out.println("Se ha creado el Usuario correctamente");
			System.out.println("Usuario creado: Nombre: " + u.getNombre() + " Email: " + u.getEmail() + " Contrasenya: "
					+ u.getPassword());

			listaUsuariosGmail.add(u);
			return true;

		} catch (Exception e) {
			System.out.println("Error al crear el usuario");
			return false;
		}

	}

	public boolean registrarCompleto(String email, String password, String nickname, TipoUsuarioDTO tipoUsuarioDTO,
			Integer peso, Integer altura, Integer frecCardMax, Integer frecCardReposo) {

		try {
			UsuarioGmail u = new UsuarioGmail();
			u.setEmail(email);
			u.setNombre(nickname);
			u.setPassword(password);
			u.setTipoUsuario(TipoUsuario.EMAIL);
			u.setPesoKG(peso);
			u.setAltura(altura);
			u.setFrecCardMax(frecCardMax);
			u.setFrecCardResposo(frecCardReposo);
			List<Reto> reto = new ArrayList<>();
			u.setRetos(reto);
			
			System.out.println("Se ha registrado el usuario EMAIL correctamente");
//			System.out.println("Usuario creado: Nombre: " + u.getNombre() + " Email: " + u.getEmail() + " Contrasenya: "
//					+ u.getPassword() + " Peso: " + u.getPesoKG() + " Altura: " + u.getAltura() + " F.C.M: "
//					+ u.getFrecCardMax() + " F.C.R: " + u.getFrecCardResposo());
//			
//			mensaje+=u.toString();
//			System.out.println(mensaje);
			listaUsuariosGmail.add(u);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al crear el usuario");
			return false;
		}
//		String mensaje = "";

	}

	public boolean registrarObligatorioFacebook(String email, String nickname, TipoUsuarioDTO tipoUsuarioDTO) {
		Usuario u = new Usuario();
		try {
			u.setEmail(email);
			u.setNombre(nickname);
			u.setTipoUsuario(TipoUsuario.FACEBOOK);
			List<Reto> reto = new ArrayList<>();
			u.setRetos(reto);
			System.out.println("Se ha registrado el usuario FACEBOOK correctamente");
			System.out.println("Usuario creado: Nombre: " + u.getNombre() + " Email: " + u.getEmail());
			listaUsuarios.add(u);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al crear el usuario");
			return false;
		}

	}

	public boolean registrarObligatorioGoogle(String email,String contasenya, String nickname, TipoUsuarioDTO tipoUsuarioDTO) {
		boolean resultado =false;
		GoogleGateway googleGateway = GoogleGateway.getInstance();
		if (googleGateway.checkCuenta(email, contasenya)==true) {
			Usuario u = new Usuario();
			try {
				u.setEmail(email);
				u.setNombre(nickname);
				u.setTipoUsuario(TipoUsuario.GOOGLE);
				List<Reto> reto = new ArrayList<>();
				u.setRetos(reto);
				System.out.println("Se ha registrado el usuario GOOGLE correctamente");
				System.out.println("Usuario creado: Nombre: " + u.getNombre() + " Email: " + u.getEmail());
				listaUsuarios.add(u);
				resultado = true;
			} catch (Exception e) {
				System.out.println("Error al crear el usuario");
				resultado= false;
			}
		}else {
			System.out.println("La cuenta de google no coincide");
			resultado= false;
		}
		return resultado;
		
	}

	public boolean registrarCompletoFacebook(String email, String nickname, TipoUsuarioDTO tipoUsuarioDTO, Integer peso,
			Integer altura, Integer frecCardMax, Integer frecCardReposo) {
		Usuario u = new Usuario();
		try {
			u.setEmail(email);
			u.setNombre(nickname);
			u.setTipoUsuario(TipoUsuario.FACEBOOK);
			u.setPesoKG(peso);
			u.setAltura(altura);
			u.setFrecCardMax(frecCardMax);
			u.setFrecCardResposo(frecCardReposo);
			List<Reto> reto = new ArrayList<>();
			u.setRetos(reto);
			System.out.println("Se ha registrado el usuario FACEBOOK correctamente");
			System.out.println("Usuario creado: Nombre: " + u.getNombre() + " Email: " + u.getEmail() + " Peso: "
					+ u.getPesoKG() + " Altura: " + u.getAltura() + " F.C.M: " + u.getFrecCardMax() + " F.C.R: "
					+ u.getFrecCardResposo());
			listaUsuarios.add(u);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	public boolean registrarCompletoGoogle(String email, String contrasenya, String nickname, TipoUsuarioDTO tipoUsuarioDTO, Integer peso,
			Integer altura, Integer frecCardMax, Integer frecCardReposo) {
		boolean resultado =false;
		GoogleGateway googleGateway = GoogleGateway.getInstance();
		if (googleGateway.checkCuenta(email, contrasenya)==true) {
			Usuario u = new Usuario();
			try {
				u.setEmail(email);
				u.setNombre(nickname);
				u.setTipoUsuario(TipoUsuario.GOOGLE);
				u.setPesoKG(peso);
				u.setAltura(altura);
				u.setFrecCardMax(frecCardMax);
				u.setFrecCardResposo(frecCardReposo);
				List<Reto> reto = new ArrayList<>();
				u.setRetos(reto);
				System.out.println("Se ha registrado el usuario GOOGLE correctamente");
				System.out.println("Usuario creado: Nombre: " + u.getNombre() + " Email: " + u.getEmail() + " Peso: "
						+ u.getPesoKG() + " Altura: " + u.getAltura() + " F.C.M: " + u.getFrecCardMax() + " F.C.R: "
						+ u.getFrecCardResposo());
				listaUsuarios.add(u);
				resultado= true;
			} catch (Exception e) {
				resultado= false;
			}
		}else {
			resultado =false;
			System.out.println("La cuenta de google no coincide");
		}
		return resultado;
		
		
	}


}
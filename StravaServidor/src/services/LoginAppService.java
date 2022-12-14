package services;

import dto.TipoUsuarioDTO;
import factory.LoginFactory;
import domain.Usuario;
import domain.UsuarioGmail;

import java.util.ArrayList;
import java.util.List;

import dao.UsuarioDAO;
import domain.Reto;
import domain.TipoUsuario;

public class LoginAppService {
	private List<Usuario> listaUsuarios = new ArrayList<>();
	private List<UsuarioGmail> listaUsuariosGmail = new ArrayList<>();
	public static LoginAppService instance;
	
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
	
	
	public Usuario login(String email, String contrasenya,String nickName, TipoUsuarioDTO tipousuario) {
		if (tipousuario.equals(TipoUsuarioDTO.FACEBOOK)) {
			if (LoginFactory.crearLoginService("Facebook").comprobarCuenta(email, contrasenya)==true) {
				for (Usuario usu : UsuarioDAO.getInstance().getAll()) {
					if ((usu).getEmail().equals(email) && (usu).getNombre().equals(nickName)) {
						return usu;
					}
			}
		}
		}else if (tipousuario.equals(TipoUsuarioDTO.GOOGLE)) {
			if (LoginFactory.crearLoginService("Google").comprobarCuenta(email, contrasenya)==true) {
				for (Usuario usu : UsuarioDAO.getInstance().getAll()) {
					if (usu.getEmail().equals(email) && usu.getNombre().equals(nickName)) {
						return usu;
					}
			}	
		}	
		} else if(tipousuario.equals(TipoUsuarioDTO.EMAIL)) {
			for (UsuarioGmail usu : UsuarioDAO.getInstance().getAllGmail()) {
				if (usu.getEmail().equals(email) && usu.getNombre().equals(nickName)
						&& usu.getPassword().equals(contrasenya)) {
					return usu;
			}
		}
	}
		return null;
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
			
			UsuarioDAO.getInstance().guardarGmail(u);
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
			
			
			UsuarioDAO.getInstance().guardarGmail(u);
			return true;
		} catch (Exception e) {
			System.out.println("Error al crear el usuario");
			return false;
		}

	}

	public boolean registrarObligatorioFacebook(String email, String nickname, TipoUsuarioDTO tipoUsuarioDTO) {
		if (LoginFactory.crearLoginService("Facebook").comprobarEmail(email)==true) {
			Usuario u = new Usuario();
			try {
				u.setEmail(email);
				u.setNombre(nickname);
				u.setTipoUsuario(TipoUsuario.FACEBOOK);
				List<Reto> reto = new ArrayList<>();
				u.setRetos(reto);
				System.out.println("Se ha registrado el usuario FACEBOOK correctamente");
				System.out.println("Usuario creado: Nombre: " + u.getNombre() + " Email: " + u.getEmail());
				
				UsuarioDAO.getInstance().guardar(u);
				
				return true;
			} catch (Exception e) {
				System.out.println("Error al crear el usuario");
				return false;
			}
		}else {
			System.out.println("La cuenta de Facebook no coincide");
			return false;
		}
		


	}

	public boolean registrarObligatorioGoogle(String email, String nickname, TipoUsuarioDTO tipoUsuarioDTO) {
		boolean resultado =false;
		if (LoginFactory.crearLoginService("Google").comprobarEmail(email)==true) {
			Usuario u = new Usuario();
			try {
				u.setEmail(email);
				u.setNombre(nickname);
				u.setTipoUsuario(TipoUsuario.GOOGLE);
				List<Reto> reto = new ArrayList<>();
				u.setRetos(reto);
				System.out.println("Se ha registrado el usuario GOOGLE correctamente");
				System.out.println("Usuario creado: Nombre: " + u.getNombre() + " Email: " + u.getEmail());
				
				UsuarioDAO.getInstance().guardar(u);
				
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
		
		if (LoginFactory.crearLoginService("Facebook").comprobarEmail(email)==true) {
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
				
				UsuarioDAO.getInstance().guardar(u);
				
				return true;
			} catch (Exception e) {
				System.out.println("Error al crear usuario");
				return false;
			}
		}else {
			System.out.println("La cuenta de Facebook no coincide");
			return false;
		}

	}

	public boolean registrarCompletoGoogle(String email, String nickname, TipoUsuarioDTO tipoUsuarioDTO, Integer peso,
			Integer altura, Integer frecCardMax, Integer frecCardReposo) {
		boolean resultado =false;
		if (LoginFactory.crearLoginService("Google").comprobarEmail(email)==true) {
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
				
				UsuarioDAO.getInstance().guardar(u);
				
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
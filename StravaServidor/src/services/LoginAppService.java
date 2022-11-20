package services;

import dto.EntrenamientoAssembler;
import dto.TipoUsuarioDTO;
import dto.UsuarioAssembler;
import dto.UsuarioDTO;
import domain.Usuario;
import domain.UsuarioGmail;

import java.util.ArrayList;
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
				u.setNombre(usu.getNombre());
				u.setNumero(usu.getNumero());
				u.setAltura(usu.getAltura());
				u.setEmail(usu.getEmail());
				u.setFrecCardMax(usu.getFrecCardMax());
				u.setFrecCardResposo(usu.getFrecCardResposo());
				u.setPesoKG(usu.getPesoKG());
				u.setRetos(usu.getRetos());
				u.setTipoUsuario(TipoUsuario.FACEBOOK);

				System.out.println("el login se ha completado");
				System.out.println("loginAppService");

			} else {
				System.out.println("el usuario no existe");
				System.out.println("loginAppService ERROR");
			}
		}
		return u;
	}

	public Usuario loginGoogle(String email, String nickName) {
		Usuario u = new Usuario();
		for (Usuario usu : listaUsuarios) {
			if (usu.getEmail().equals(email) && usu.getNombre().equals(nickName)) {
				u.setNombre(usu.getNombre());
				u.setNumero(usu.getNumero());
				u.setAltura(usu.getAltura());
				u.setEmail(usu.getEmail());
				u.setFrecCardMax(usu.getFrecCardMax());
				u.setFrecCardResposo(usu.getFrecCardResposo());
				u.setPesoKG(usu.getPesoKG());
				u.setRetos(usu.getRetos());
				u.setTipoUsuario(TipoUsuario.GOOGLE);

				System.out.println("el login se ha completado");
				System.out.println("loginAppService");

			} else {
				System.out.println("el usuario no existe");
				System.out.println("loginAppService ERROR");

			}
		}
		return u;
	}

	public UsuarioGmail loginGmail(String email, String password, String nickName) {

		UsuarioGmail u = new UsuarioGmail();
		for (UsuarioGmail usu : listaUsuariosGmail) {
			if (usu.getEmail().equals(email) && usu.getNombre().equals(nickName)
					&& usu.getPassword().equals(password)) {
				u.setNombre(usu.getNombre());
				u.setNumero(usu.getNumero());
				u.setAltura(usu.getAltura());
				u.setEmail(usu.getEmail());
				u.setFrecCardMax(usu.getFrecCardMax());
				u.setFrecCardResposo(usu.getFrecCardResposo());
				u.setPesoKG(usu.getPesoKG());
				u.setRetos(usu.getRetos());
				u.setTipoUsuario(TipoUsuario.EMAIL);
				u.setPassword(password);

				System.out.println("el login se ha completado");
				System.out.println("loginAppService");

			} else {
				System.out.println("el usuario no existe");
				System.out.println("loginAppService ERROR");

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
		UsuarioDTO dto = new UsuarioDTO();
		try {
			dto.setEmail(email);
			dto.setNombre(nickname);
			dto.setTipoUsuario(TipoUsuarioDTO.FACEBOOK);
			UsuarioAssembler assembler = new UsuarioAssembler();
			Usuario u = assembler.usuarioDTOtoUsuario(dto);
			System.out.println("Se ha registrado el usuario FACEBOOK correctamente");
			System.out.println("Usuario creado: Nombre: " + dto.getNombre() + " Email: " + dto.getEmail());
			listaUsuarios.add(u);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al crear el usuario");
			return false;
		}

	}

	public boolean registrarObligatorioGoogle(String email, String nickname, TipoUsuarioDTO tipoUsuarioDTO) {
		UsuarioDTO dto = new UsuarioDTO();
		try {
			dto.setEmail(email);
			dto.setNombre(nickname);
			dto.setTipoUsuario(TipoUsuarioDTO.GOOGLE);
			UsuarioAssembler assembler = new UsuarioAssembler();
			Usuario u = assembler.usuarioDTOtoUsuario(dto);
			System.out.println("Se ha registrado el usuario GOOGLE correctamente");
			System.out.println("Usuario creado: Nombre: " + u.getNombre() + " Email: " + u.getEmail());
			listaUsuarios.add(u);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al crear el usuario");
			return false;
		}
	}

	public boolean registrarCompletoFacebook(String email, String nickname, TipoUsuarioDTO tipoUsuarioDTO, Integer peso,
			Integer altura, Integer frecCardMax, Integer frecCardReposo) {
		UsuarioDTO dto = new UsuarioDTO();
		try {
			dto.setEmail(email);
			dto.setNombre(nickname);
			dto.setTipoUsuario(TipoUsuarioDTO.FACEBOOK);
			dto.setPesoKG(peso);
			dto.setAltura(altura);
			dto.setFrecCardMax(frecCardMax);
			dto.setFrecCardResposo(frecCardReposo);
			UsuarioAssembler assembler = new UsuarioAssembler();
			Usuario u = assembler.usuarioDTOtoUsuario(dto);
			System.out.println("Se ha registrado el usuario FACEBOOK correctamente");
			System.out.println("Usuario creado: Nombre: " + dto.getNombre() + " Email: " + dto.getEmail() + " Peso: "
					+ dto.getPesoKG() + " Altura: " + dto.getAltura() + " F.C.M: " + dto.getFrecCardMax() + " F.C.R: "
					+ dto.getFrecCardResposo());
			listaUsuarios.add(u);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	public boolean registrarCompletoGoogle(String email, String nickname, TipoUsuarioDTO tipoUsuarioDTO, Integer peso,
			Integer altura, Integer frecCardMax, Integer frecCardReposo) {
		UsuarioDTO dto = new UsuarioDTO();
		try {
			dto.setEmail(email);
			dto.setNombre(nickname);
			dto.setTipoUsuario(TipoUsuarioDTO.GOOGLE);
			dto.setPesoKG(peso);
			dto.setAltura(altura);
			dto.setFrecCardMax(frecCardMax);
			dto.setFrecCardResposo(frecCardReposo);
			UsuarioAssembler assembler = new UsuarioAssembler();
			Usuario u = assembler.usuarioDTOtoUsuario(dto);
			System.out.println("Se ha registrado el usuario GOOGLE correctamente");
			System.out.println("Usuario creado: Nombre: " + dto.getNombre() + " Email: " + dto.getEmail() + " Peso: "
					+ dto.getPesoKG() + " Altura: " + dto.getAltura() + " F.C.M: " + dto.getFrecCardMax() + " F.C.R: "
					+ dto.getFrecCardResposo());
			System.out.println("Usuario creado: Nombre: " + dto.getNombre() + " Email: " + dto.getEmail());

			listaUsuarios.add(u);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	private void initilizeDataLogin() {
		// Create Users
		UsuarioGmail user0 = new UsuarioGmail();
		user0.setEmail("thomas.e2001@gmail.com");
		user0.setNombre("Thomas");
		user0.setPassword("aaa");

		UsuarioGmail user1 = new UsuarioGmail();
		user1.setEmail("sample@gmail.com");
		user1.setNombre("buyer33");
		user1.setPassword("hqc`}3Hb");

		listaUsuariosGmail.add(user0);
		listaUsuariosGmail.add(user1);

	}

}
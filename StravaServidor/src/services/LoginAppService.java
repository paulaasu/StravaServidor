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
import domain.TipoUsuario;

//TODO: Implement Singleton Pattern
public class LoginAppService {
	private List<Usuario> listaUsuarios = new ArrayList<>();

	public UsuarioDTO login(String email, String nickName, TipoUsuarioDTO tipoUsuarioDTO) {
		UsuarioDTO u = new UsuarioDTO();
		if (tipoUsuarioDTO.equals(TipoUsuarioDTO.FACEBOOK)) {
			u.setEmail(email);
			u.setNombre(nickName);
			u.setTipoUsuario(tipoUsuarioDTO.FACEBOOK);
//			List<Reto> rdto = new ArrayList<>();
//			u.setRetos(rdto);
			if (u.getEmail().equals(email) && u.getNombre().equals(nickName)) {
				System.out.println(u.toString());
				return u;
			} else {
				return null;
			}
		} else if (tipoUsuarioDTO.equals(TipoUsuarioDTO.GOOGLE)) {
			u.setEmail(email);
			u.setNombre(nickName);
			u.setTipoUsuario(tipoUsuarioDTO.GOOGLE);
//			List<Reto> rdto = new ArrayList<>();
//			u.setRetos(rdto);
			if (u.getEmail().equals(email) && u.getNombre().equals(nickName)) {
				System.out.println(u.toString());
				return u;
			} else {
				return null;
			}
		}
		return u;
	}

	public UsuarioGmail loginGmail(String email, String password, String nickName, TipoUsuarioDTO tipoUsuarioDTO) {
		UsuarioGmail u = new UsuarioGmail();
		u.setNombre(nickName);
		u.setEmail(email);
		u.setPassword(password);
		u.setTipoUsuario(TipoUsuario.EMAIL);
		if (u.getEmail().equals(email) && u.getNombre().equals(nickName)) {
			System.out.println(u.toString());
			return u;
		} else {
			return null;
		}

	}

	public boolean registrarObligatorio(String email, String password, String nickName, TipoUsuarioDTO tipoUsuarioDTO) {
//		String mensaje = "";

		try {
			UsuarioGmail u = new UsuarioGmail();
			u.setEmail(email);
			u.setNombre(nickName);
			u.setPassword(password);
			u.setTipoUsuario(TipoUsuario.EMAIL);
			List<Reto> reto = new ArrayList<>();
			u.setRetos(reto);

//			mensaje+=u.toString();

			System.out.println("Se ha creado el Usuario correctamente");
			System.out.println("Usuario creado: Nombre: " + u.getNombre() + " Email: " + u.getEmail() + " Contrasenya: "
					+ u.getPassword());

			listaUsuarios.add(u);
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
			listaUsuarios.add(u);
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
	
	
}
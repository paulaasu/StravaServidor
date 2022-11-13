package services;

import dto.TipoUsuarioDTO;
import dto.UsuarioDTO;
import domain.Usuario;
import domain.UsuarioGmail;

import java.util.ArrayList;
import java.util.List;

import domain.Reto;
import domain.TipoUsuario;
//TODO: Implement Singleton Pattern
public class LoginAppService {
		
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
		} else if(tipoUsuarioDTO.equals(TipoUsuarioDTO.GOOGLE)){
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
	
	public UsuarioGmail registrarObligatorio(String email, String password, String nickName, TipoUsuarioDTO tipoUsuarioDTO) {
		String mensaje = "";
		UsuarioGmail u = new UsuarioGmail();
		u.setEmail(email);
		u.setNombre(nickName);
		u.setPassword(password);
		u.setTipoUsuario(TipoUsuario.EMAIL);
		List<Reto> reto = new ArrayList<>();
		u.setRetos(reto);
		System.out.println("Se ha registrado el usuario EMAIL correctamente");
		System.out.println("Usuario creado: Nombre: "+u.getNombre()+" Email: "+u.getEmail()+" Contrasenya: "+u.getPassword());
		
		mensaje+=u.toString();
		
		return u;
		
	}
	public UsuarioGmail registrarCompleto(String email, String password, String nickname, TipoUsuarioDTO tipoUsuarioDTO,
			Integer peso, Integer altura, Integer frecCardMax, Integer frecCardReposo) {
		String mensaje = "";
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
//		System.out.println("Usuario creado: Nombre: " + u.getNombre() + " Email: " + u.getEmail() + " Contrasenya: "
//				+ u.getPassword() + " Peso: " + u.getPesoKG() + " Altura: " + u.getAltura() + " F.C.M: "
//				+ u.getFrecCardMax() + " F.C.R: " + u.getFrecCardResposo());
//		
		mensaje+=u.toString();
		System.out.println(mensaje);
		return u;
		
	}
	public UsuarioDTO registrarObligatorioFG(String email, String nickname, TipoUsuarioDTO tipoUsuarioDTO) {
		UsuarioDTO u = new UsuarioDTO();
		if (tipoUsuarioDTO.equals(tipoUsuarioDTO.FACEBOOK)) {
			u.setEmail(email);
			u.setNombre(nickname);
			u.setTipoUsuario(TipoUsuarioDTO.FACEBOOK);
			System.out.println("Se ha registrado el usuario FACEBOOK correctamente");
			System.out.println("Usuario creado: Nombre: "+u.getNombre()+" Email: "+u.getEmail());
		} else if (tipoUsuarioDTO.equals(tipoUsuarioDTO.GOOGLE)) {
			u.setEmail(email);
			u.setNombre(nickname);
			u.setTipoUsuario(TipoUsuarioDTO.GOOGLE);
			System.out.println("Se ha registrado el usuario GOOGLE correctamente");
			System.out.println("Usuario creado: Nombre: "+u.getNombre()+" Email: "+u.getEmail());
		}
		return u;
	}
	public UsuarioDTO registrarCompletoFG(String email, String nickname, TipoUsuarioDTO tipoUsuarioDTO, Integer peso,
			Integer altura, Integer frecCardMax, Integer frecCardReposo) {
		UsuarioDTO u = new UsuarioDTO();
		if (tipoUsuarioDTO.equals(tipoUsuarioDTO.FACEBOOK)) {
			u.setEmail(email);
			u.setNombre(nickname);
			u.setTipoUsuario(TipoUsuarioDTO.FACEBOOK);
			u.setPesoKG(peso);
			u.setAltura(altura);
			u.setFrecCardMax(frecCardMax);
			u.setFrecCardResposo(frecCardReposo);
			System.out.println("Se ha registrado el usuario FACEBOOK correctamente");
			System.out.println("Usuario creado: Nombre: "+u.getNombre()+" Email: "+u.getEmail()+" Peso: "+u.getPesoKG()+ " Altura: "+u.getAltura()+" F.C.M: "+u.getFrecCardMax()+" F.C.R: "+u.getFrecCardResposo());
		} else if (tipoUsuarioDTO.equals(tipoUsuarioDTO.GOOGLE)) {
			u.setEmail(email);
			u.setNombre(nickname);
			u.setTipoUsuario(TipoUsuarioDTO.GOOGLE);
			u.setPesoKG(peso);
			u.setAltura(altura);
			u.setFrecCardMax(frecCardMax);
			u.setFrecCardResposo(frecCardReposo);
			System.out.println("Se ha registrado el usuario GOOGLE correctamente");
			System.out.println("Usuario creado: Nombre: "+u.getNombre()+" Email: "+u.getEmail()+" Peso: "+u.getPesoKG()+ " Altura: "+u.getAltura()+" F.C.M: "+u.getFrecCardMax()+" F.C.R: "+u.getFrecCardResposo());
			System.out.println("Usuario creado: Nombre: "+u.getNombre()+" Email: "+u.getEmail());
		}
		return u;
	}
}
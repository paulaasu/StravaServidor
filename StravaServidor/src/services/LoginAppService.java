package services;

import dto.TipoUsuarioDTO;
import domain.Usuario;
import domain.UsuarioGmail;

import java.util.ArrayList;
import java.util.List;

import domain.Reto;
import domain.TipoUsuario;
//TODO: Implement Singleton Pattern
public class LoginAppService {
		
	public Usuario login(String email, String password, String nickName, TipoUsuarioDTO tipoUsuarioDTO) {
		//TODO: Get User using DAO and check 
		if (tipoUsuarioDTO.equals(TipoUsuarioDTO.FACEBOOK) || tipoUsuarioDTO.equals(TipoUsuarioDTO.GOOGLE)) {
			Usuario u = new Usuario();
			u.setEmail(email);
			u.setNombre(nickName);
			List<Reto> rdto = new ArrayList<>();
			u.setRetos(rdto);
			if (u.getEmail().equals(email) && u.getNombre().equals(nickName)) {		
				return u;
			} else {
				return null;
			}
		} else if(tipoUsuarioDTO.equals(TipoUsuarioDTO.EMAIL)){
			UsuarioGmail u = new UsuarioGmail();
			u.setEmail(email);
			u.setNombre(nickName);
			u.setPassword(password);
			List<Reto> rdto = new ArrayList<>();
			u.setRetos(rdto);
			if (u.getEmail().equals(email) && u.getNombre().equals(nickName) && u.getPassword().equals(password) && u.getTipoUsuario().equals(TipoUsuarioDTO.EMAIL)) {		
				return u;
			} else {
				return null;
			}
		}
		return null;
		
	}
	public Usuario registrarObligatorio(String email, String password, String nickName, TipoUsuarioDTO tipoUsuarioDTO) {
		if(tipoUsuarioDTO.equals(tipoUsuarioDTO.FACEBOOK)){
			Usuario u = new Usuario();
			u.setEmail(email);
			u.setNombre(nickName);
			u.setTipoUsuario(TipoUsuario.FACEBOOK);
			List<Reto> reto = new ArrayList<>();
			u.setRetos(reto);
			return u;
		}else if (tipoUsuarioDTO.equals(TipoUsuarioDTO.GOOGLE)){
			Usuario u = new Usuario();
			u.setEmail(email);
			u.setNombre(nickName);
			u.setTipoUsuario(TipoUsuario.GOOGLE);
			List<Reto> reto = new ArrayList<>();
			u.setRetos(reto);
			return u;
		} else if(tipoUsuarioDTO.equals(TipoUsuarioDTO.EMAIL)){
			UsuarioGmail u = new UsuarioGmail();
			u.setEmail(email);
			u.setNombre(nickName);
			u.setPassword(password);
			u.setTipoUsuario(TipoUsuario.EMAIL);
			List<Reto> reto = new ArrayList<>();
			u.setRetos(reto);
			return u;
		}
		
		return null;
		
	}
	public Usuario registrarCompleto(String email, String password, String nickname, TipoUsuarioDTO tipoUsuarioDTO,
			Integer peso, Integer altura, Integer frecCardMax, Integer frecCardReposo) {
		if(tipoUsuarioDTO.equals(tipoUsuarioDTO.FACEBOOK)){
			Usuario u = new Usuario();
			u.setEmail(email);
			u.setNombre(nickname);
			u.setTipoUsuario(TipoUsuario.FACEBOOK);
			u.setPesoKG(peso);
			u.setAltura(altura);
			u.setFrecCardMax(frecCardMax);
			u.setFrecCardResposo(frecCardReposo);
			List<Reto> reto = new ArrayList<>();
			u.setRetos(reto);
			return u;
		}else if (tipoUsuarioDTO.equals(TipoUsuarioDTO.GOOGLE)){
			Usuario u = new Usuario();
			u.setEmail(email);
			u.setNombre(nickname);
			u.setTipoUsuario(TipoUsuario.GOOGLE);
			u.setPesoKG(peso);
			u.setAltura(altura);
			u.setFrecCardMax(frecCardMax);
			u.setFrecCardResposo(frecCardReposo);
			List<Reto> reto = new ArrayList<>();
			u.setRetos(reto);
			return u;
		} else if(tipoUsuarioDTO.equals(TipoUsuarioDTO.EMAIL)){
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
			return u;
		}
		
		return null;
		
	}
}
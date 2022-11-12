package dto;

import java.util.ArrayList;
import java.util.List;

import dto.TipoUsuarioDTO;
import domain.Entrenamiento;
import domain.Usuario;
import domain.TipoUsuario;

public class UsuarioAssembler {

	public static UsuarioAssembler instance;

	
	public static UsuarioAssembler getInstance() {
		if (instance == null) {
			instance = new UsuarioAssembler();
		}

		return instance;
	}
	
	public UsuarioDTO usuarioToDTO(Usuario usuario) {
		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setNumero(usuario.getNumero());
		dto.setNombre(usuario.getNombre());
		dto.setEmail(usuario.getEmail());
		dto.setPesoKG(usuario.getPesoKG());
		dto.setAltura(usuario.getAltura());
		dto.setFrecCardMax(usuario.getFrecCardMax());
		dto.setFrecCardResposo(usuario.getFrecCardResposo());
		
		if(usuario.getTipoUsuario().equals(TipoUsuario.GOOGLE)) {
			dto.setTipoUsuario(TipoUsuarioDTO.GOOGLE);
		} else if(usuario.getTipoUsuario().equals(TipoUsuario.FACEBOOK)) {
			dto.setTipoUsuario(TipoUsuarioDTO.FACEBOOK);
		}else if(usuario.getTipoUsuario().equals(TipoUsuario.EMAIL)) {
			dto.setTipoUsuario(TipoUsuarioDTO.EMAIL);
		}
		
		return dto;
	}
	
	public List<UsuarioDTO> usuariosToDTO(List<Usuario> usuarios) {		
		List<UsuarioDTO> dtos = new ArrayList<>();
		
		for (Usuario usuario : usuarios) {
			dtos.add(this.usuarioToDTO(usuario));
		}
		
		return dtos;
	}
	
	
	
	
	
}

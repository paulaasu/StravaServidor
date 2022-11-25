package dto;

import java.util.ArrayList;
import java.util.List;

import dto.TipoUsuarioDTO;
import domain.Entrenamiento;
import domain.Usuario;
import domain.TipoUsuario;

public class UsuarioAssembler {

	private static UsuarioAssembler instance;

	private UsuarioAssembler() { }
	
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
	
	public Usuario usuarioDTOtoUsuario(UsuarioDTO usuarioDTO) {
		Usuario u = new Usuario();
		
		u.setNombre(usuarioDTO.getNombre());
		u.setEmail(usuarioDTO.getEmail());
		u.setPesoKG(usuarioDTO.getPesoKG());
		u.setAltura(usuarioDTO.getAltura());
		u.setFrecCardMax(usuarioDTO.getFrecCardMax());
		u.setFrecCardResposo(usuarioDTO.getFrecCardResposo());
		
		if(usuarioDTO.getTipoUsuario().equals(TipoUsuario.GOOGLE)) {
			u.setTipoUsuario(TipoUsuario.GOOGLE);
		} else if(usuarioDTO.getTipoUsuario().equals(TipoUsuario.FACEBOOK)) {
			u.setTipoUsuario(TipoUsuario.FACEBOOK);
		}else if(usuarioDTO.getTipoUsuario().equals(TipoUsuario.EMAIL)) {
			u.setTipoUsuario(TipoUsuario.EMAIL);
		}
		
		return u;
	}
	
	public List<UsuarioDTO> usuariosToDTO(List<Usuario> usuarios) {		
		List<UsuarioDTO> dtos = new ArrayList<>();
		
		for (Usuario usuario : usuarios) {
			dtos.add(this.usuarioToDTO(usuario));
		}
		
		return dtos;
	}
	
	
	
	
	
}

package dto;

import java.util.ArrayList;
import java.util.List;

import domain.Reto;
import domain.TipoDeporte;
import domain.TipoUsuario;
import domain.Usuario;

public class RetoAssembler {

	private static RetoAssembler instance;

	private RetoAssembler() { }
	
	public static RetoAssembler getInstance() {
		if (instance == null) {
			instance = new RetoAssembler();
		}

		return instance;
	}
	
	public RetoDTO retoToDTO(Reto reto) {
		RetoDTO dto = new RetoDTO();
		
		dto.setNombre(reto.getNombre());
		dto.setDescripcion(reto.getDescripcion());
		dto.setFecha_ini(reto.getFecha_ini());
		dto.setFecha_fin(reto.getFecha_fin());
		dto.setDistancia(reto.getDistancia());
		
		if(reto.getDeporte().equals(TipoDeporte.CICLISMO)) {
			dto.setDeporte(TipoDeporteDTO.CICLISMO);
		} else if(reto.getDeporte().equals(TipoDeporte.RUNNING)) {
			dto.setDeporte(TipoDeporteDTO.RUNNING);
		}
		
		UsuarioAssembler asem = UsuarioAssembler.getInstance();
		UsuarioDTO usuDTO = asem.usuarioToDTO(reto.getCreador());
		dto.setCreador(usuDTO);
		
		return dto;
	}
	public Reto retoDTOTo(RetoDTO retoDTO) {
		Reto reto = new Reto();
		
		reto.setNombre(retoDTO.getNombre());
		reto.setDescripcion(retoDTO.getDescripcion());
		reto.setFecha_ini(retoDTO.getFecha_ini());
		reto.setFecha_fin(retoDTO.getFecha_fin());
		reto.setDistancia(retoDTO.getDistancia());
		
		if(retoDTO.getDeporte().equals(TipoDeporteDTO.CICLISMO)) {
			reto.setDeporte(TipoDeporte.CICLISMO);
		} else if(retoDTO.getDeporte().equals(TipoDeporteDTO.RUNNING)) {
			reto.setDeporte(TipoDeporte.RUNNING);
		}
		
		
//		Usuario usu = new Usuario();
//		usu.setEmail(retoDTO.getCreador().getEmail());
//		usu.setAltura(retoDTO.getCreador().getAltura());
//		usu.setFrecCardMax(retoDTO.getCreador().getFrecCardMax());
//		usu.setFrecCardResposo(retoDTO.getCreador().getFrecCardResposo());
//		usu.setNombre(retoDTO.getCreador().getNombre());
//		usu.setPesoKG(retoDTO.getCreador().getPesoKG());
//		usu.setNumero(retoDTO.getCreador().getNumero());
//		
//		if(retoDTO.getCreador().getTipoUsuario().equals(TipoUsuarioDTO.GOOGLE)) {
//			usu.setTipoUsuario(TipoUsuario.GOOGLE);
//		} else if(retoDTO.getCreador().getTipoUsuario().equals(TipoUsuarioDTO.FACEBOOK)) {
//			usu.setTipoUsuario(TipoUsuario.FACEBOOK);
//		}else if(retoDTO.getCreador().getTipoUsuario().equals(TipoUsuarioDTO.EMAIL)) {
//			usu.setTipoUsuario(TipoUsuario.EMAIL);
//		}
		
//		reto.setCreador(usu);
		UsuarioAssembler asem = UsuarioAssembler.getInstance();
		Usuario usu = asem.usuarioDTOtoUsuario(retoDTO.getCreador());
		reto.setCreador(usu);
				
		return reto;
	}
	
	
	public List<RetoDTO> retosToDTO(List<Reto> retos) {		
		List<RetoDTO> dtos = new ArrayList<>();
		for (Reto reto : retos) {
							
			dtos.add(this.retoToDTO(reto));
		}
		return dtos;
	}
	
	
	
}

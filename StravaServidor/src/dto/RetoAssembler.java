package dto;

import java.util.ArrayList;
import java.util.List;

import domain.Reto;
import domain.TipoDeporte;

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
		dto.setCreador(reto.getCreador());
				
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
		reto.setCreador(retoDTO.getCreador());
				
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

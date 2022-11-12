package dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.Reto;

public class RetoAssembler {

	public static RetoAssembler instance;

	
	public static RetoAssembler getInstance() {
		if (instance == null) {
			instance = new RetoAssembler();
		}

		return instance;
	}
	
	public RetoDTO retoToDTO(Reto reto) {
		RetoDTO dto = new RetoDTO();
		
		dto.setNombre(reto.getNombre());
		dto.setFecha_ini(reto.getFecha_ini());
		dto.setFecha_fin(reto.getFecha_fin());
		dto.setDistancia(reto.getDistancia());
		dto.setDeporte(reto.getDeporte());
		dto.setCreador(reto.getCreador());
				
		return dto;
	}
	
	public List<RetoDTO> retosToDTO(List<Reto> retos) {		
		List<RetoDTO> dtos = new ArrayList<>();
		
		for (Reto reto : retos) {
			dtos.add(this.retoToDTO(reto));
		}
		
		return dtos;
	}
	
	
	
}

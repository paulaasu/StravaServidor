package dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.Entrenamiento;

public class EntrenamientoAssembler {

	public static EntrenamientoAssembler instance;

	
	public static EntrenamientoAssembler getInstance() {
		if (instance == null) {
			instance = new EntrenamientoAssembler();
		}

		return instance;
	}
	
	public EntrenamientoDTO entrenamientoToDTO(Entrenamiento entrenamiento) {
		EntrenamientoDTO dto = new EntrenamientoDTO();
		
		dto.setTitulo(entrenamiento.getTitulo());
		dto.setDeporte(entrenamiento.getDeporte());
		dto.setDistanciaKm(entrenamiento.getDistanciaKm());
		dto.setDuracion(entrenamiento.getDuracion());
		dto.setFecha_ini(entrenamiento.getFecha_ini());
		dto.setHora(entrenamiento.getHora());
		dto.setCreador(entrenamiento.getCreador());
				
		return dto;
	}
	
	public List<EntrenamientoDTO> entrenamientosToDTO(List<Entrenamiento> entrenamientos) {		
		List<EntrenamientoDTO> dtos = new ArrayList<>();
		
		for (Entrenamiento entrenamiento : entrenamientos) {
			dtos.add(this.entrenamientoToDTO(entrenamiento));
		}
		
		return dtos;
	}
	
}

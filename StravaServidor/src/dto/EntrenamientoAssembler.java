package dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.Entrenamiento;
import domain.TipoDeporte;

public class EntrenamientoAssembler {

	private static EntrenamientoAssembler instance;

	private EntrenamientoAssembler() { }
	
	public static EntrenamientoAssembler getInstance() {
		if (instance == null) {
			instance = new EntrenamientoAssembler();
		}

		return instance;
	}
	
	public EntrenamientoDTO entrenamientoToDTO(Entrenamiento entrenamiento) {
		EntrenamientoDTO dto = new EntrenamientoDTO();
		
		dto.setTitulo(entrenamiento.getTitulo());
		if(entrenamiento.getDeporte().equals(TipoDeporte.CICLISMO)) {
			dto.setDeporte(TipoDeporteDTO.CICLISMO);
		} else if(entrenamiento.getDeporte().equals(TipoDeporte.RUNNING)) {
			dto.setDeporte(TipoDeporteDTO.CICLISMO);
		}
		dto.setDistanciaKm(entrenamiento.getDistanciaKm());
		dto.setDuracion(entrenamiento.getDuracion());
		dto.setFecha_ini(entrenamiento.getFecha_ini());
		dto.setHora(entrenamiento.getHora());
		dto.setCreador(entrenamiento.getCreador());
				
		return dto;
	}
	
	public Entrenamiento entrenamientoDTOTo(EntrenamientoDTO entrenamientoDTO) {
		Entrenamiento entre = new Entrenamiento();
		
		entre.setTitulo(entrenamientoDTO.getTitulo());
		if(entrenamientoDTO.getDeporte().equals(TipoDeporteDTO.CICLISMO)) {
			entre.setDeporte(TipoDeporte.CICLISMO);
		} else if(entrenamientoDTO.getDeporte().equals(TipoDeporteDTO.RUNNING)) {
			entre.setDeporte(TipoDeporte.CICLISMO);
		}
		entre.setDistanciaKm(entrenamientoDTO.getDistanciaKm());
		entre.setDuracion(entrenamientoDTO.getDuracion());
		entre.setFecha_ini(entrenamientoDTO.getFecha_ini());
		entre.setHora(entrenamientoDTO.getHora());
		entre.setCreador(entrenamientoDTO.getCreador());
				
		return entre;
	}
	
	public List<EntrenamientoDTO> entrenamientosToDTO(List<Entrenamiento> entrenamientos) {		
		List<EntrenamientoDTO> dtos = new ArrayList<>();
		
		for (Entrenamiento entrenamiento : entrenamientos) {
			dtos.add(this.entrenamientoToDTO(entrenamiento));
		}
		
		return dtos;
	}
	
}

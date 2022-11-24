package ServerRemote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.Reto;
import domain.UsuarioGmail;
//import clases.RetoAceptadoDTO;
import dto.EntrenamientoDTO;
import dto.RetoDTO;
import dto.TipoDeporteDTO;
import dto.UsuarioDTO;
import dto.TipoUsuarioDTO;

//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {	

	public long loginFacebook(String email, String nickname) throws RemoteException;
	
	public long loginGoogle(String email, String nickname) throws RemoteException;
	
	public long loginGmail(String email, String password, String nickname) throws RemoteException;
	
	public void logout(long token) throws RemoteException; 
	
	//Registrar Email
	
	public boolean registrarObligatorio(String email, String password, String nickname, TipoUsuarioDTO tipoUsuarioDTO) throws RemoteException;
	
	public boolean registrarCompleto(String email, String password, String nickname, TipoUsuarioDTO tipoUsuarioDTO, Integer peso, Integer altura, Integer frecCardMax, Integer frecCardReposo) throws RemoteException;

	//Registrar Facebook/Google sin contraseña	
	
	public boolean registrarObligatorioFacebook(String email, String nickname, TipoUsuarioDTO tipoUsuarioDTO) throws RemoteException;
	
	public boolean registrarObligatorioGoogle(String email, String nickname, TipoUsuarioDTO tipoUsuarioDTO) throws RemoteException;

	public boolean registrarCompletoFacebook(String email, String nickname, TipoUsuarioDTO tipoUsuarioDTO, Integer peso, Integer altura, Integer frecCardMax, Integer frecCardReposo) throws RemoteException;
	
	public boolean registrarCompletoGoogle(String email, String nickname, TipoUsuarioDTO tipoUsuarioDTO, Integer peso, Integer altura, Integer frecCardMax, Integer frecCardReposo) throws RemoteException;

	//Crear Reto/Entrenamiento
	
	public boolean crearReto(long token, RetoDTO retoDTO) throws RemoteException;
	
	public boolean crearEntrenamiento(long token, EntrenamientoDTO entrenamientoDTO) throws RemoteException;
	
	public List<RetoDTO> getTodosRetos() throws RemoteException;
	
	public List<EntrenamientoDTO> getTodosEntrenamientos(long token) throws RemoteException;
	
	public List<RetoDTO> getRetosAceptados(long token) throws RemoteException;
	
//	public List<RetoDTO> obtenerRetosActivos() throws RemoteException;
	
	public boolean aceptarReto(long token, RetoDTO reto) throws RemoteException;
//	
//	public void quitarRetoARetos(String tituloReto) throws RemoteException;
//	
	//public float calcularEstado(RetoAceptadoDTO reto, UsuarioDTO user) throws RemoteException;
	
	public float getGBPRate() throws RemoteException;
}
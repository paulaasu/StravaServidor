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
import dto.UsuarioDTO;
import dto.TipoUsuarioDTO;

//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {	

	public long loginGF(String email, String nickname, TipoUsuarioDTO tipoUsuario) throws RemoteException;
	
	public long login(String email, String password, String nickname, TipoUsuarioDTO tipoUsuarioDTO) throws RemoteException;
	
	public void logout(long token) throws RemoteException; 
	
	//Registrar Email
	
	public Long registrarObligatorio(String email, String password, String nickname, TipoUsuarioDTO tipoUsuarioDTO) throws RemoteException;
	
	public Long registrarCompleto(String email, String password, String nickname, TipoUsuarioDTO tipoUsuarioDTO, Integer peso, Integer altura, Integer frecCardMax, Integer frecCardReposo) throws RemoteException;

	//Registrar Facebook/Google sin contraseña	
	
	public Long registrarObligatorioFG(String email, String nickname, TipoUsuarioDTO tipoUsuarioDTO) throws RemoteException;
	
	public Long registrarCompletoFG(String email, String nickname, TipoUsuarioDTO tipoUsuarioDTO, Integer peso, Integer altura, Integer frecCardMax, Integer frecCardReposo) throws RemoteException;
	
	//Crear Reto/Entrenamiento
	
	public RetoDTO crearReto(String nombre, String descripcion, String fecha_ini, String fecha_fin, int distancia,String deporte, int creador) throws RemoteException;
	
	public EntrenamientoDTO crearEntrenamiento(String titulo, String deporte, int distanciaKm, String fecha_ini, int hora, int duracion, int creador) throws RemoteException;
	
	public List<RetoDTO> getTodosRetos() throws RemoteException;
	
	List<EntrenamientoDTO> getTodosEntrenamientos() throws RemoteException;	
	
//	public ArrayList<RetoDTO> getRetos(String deporte) throws RemoteException;
//	
//	public void anyadirRetoARetos(RetoDTO reto, UsuarioDTO user) throws RemoteException;
//	
//	public void quitarRetoARetos(String tituloReto) throws RemoteException;
//	
	//public float calcularEstado(RetoAceptadoDTO reto, UsuarioDTO user) throws RemoteException;
//	
	public float getGBPRate() throws RemoteException;

	
}
package ServerRemote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.EntrenamientoDTO;
import dto.RetoDTO;
import dto.TipoUsuarioDTO;

public interface IRemoteFacade extends Remote {	

	public long loginFacebook(String email, String nickname) throws RemoteException;
	
	public long loginGoogle(String email, String nickname) throws RemoteException;
	
	public long loginGmail(String email, String password, String nickname) throws RemoteException;
	
	public void logout(long token) throws RemoteException; 

	public boolean registrarObligatorio(String email, String password, String nickname, TipoUsuarioDTO tipoUsuarioDTO) throws RemoteException;
	
	public boolean registrarCompleto(String email, String password, String nickname, TipoUsuarioDTO tipoUsuarioDTO, Integer peso, Integer altura, Integer frecCardMax, Integer frecCardReposo) throws RemoteException;

	//Registrar Facebook/Google obligatorio
	
	public boolean registrarObligatorioFacebook(String email,String contasenya, String nickname, TipoUsuarioDTO tipoUsuarioDTO) throws RemoteException;
	
	public boolean registrarObligatorioGoogle(String email, String contrasenya, String nickname, TipoUsuarioDTO tipoUsuarioDTO) throws RemoteException;

	//Registrar Facebook/Google completo
	
	public boolean registrarCompletoFacebook(String email,String contasenya, String nickname, TipoUsuarioDTO tipoUsuarioDTO, Integer peso, Integer altura, Integer frecCardMax, Integer frecCardReposo) throws RemoteException;
	
	public boolean registrarCompletoGoogle(String email, String contrasenya, String nickname, TipoUsuarioDTO tipoUsuarioDTO, Integer peso, Integer altura, Integer frecCardMax, Integer frecCardReposo) throws RemoteException;

	//Crear Reto/Entrenamiento
	
	public boolean crearReto(long token, RetoDTO retoDTO) throws RemoteException;
	
	public boolean crearEntrenamiento(long token, EntrenamientoDTO entrenamientoDTO) throws RemoteException;
	
	//Obtener Retos
	
	public List<RetoDTO> getTodosRetos() throws RemoteException;
	
	//Obtener Retos aceptados/Entrenamientos propios
	
	public List<EntrenamientoDTO> getTodosEntrenamientos(long token) throws RemoteException;
	
	public List<RetoDTO> getRetosAceptados(long token) throws RemoteException;
	
	//Aceptar Reto
	
	public boolean aceptarReto(long token, RetoDTO reto) throws RemoteException;

}
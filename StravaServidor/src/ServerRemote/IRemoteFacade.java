package ServerRemote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
//import clases.RetoAceptadoDTO;
import dto.EntrenamientoDTO;
import dto.RetoDTO;
import dto.UsuarioDTO;
import dto.TipoUsuarioDTO;

//This interface defines the API of the Server. It represents the Remote Facade pattern
public interface IRemoteFacade extends Remote {	

	public long login(String email, String password) throws RemoteException;
	
	public void logout(long token) throws RemoteException; 
	
	public ArrayList<RetoDTO> getRetos(String deporte) throws RemoteException;
	
	public UsuarioDTO getCheckedUsuario(String email, String password) throws RemoteException;
	
	public void anyadirRetoARetos(RetoDTO reto, UsuarioDTO user) throws RemoteException;
	
	public void quitarRetoARetos(String tituloReto) throws RemoteException;
	
	//public float calcularEstado(RetoAceptadoDTO reto, UsuarioDTO user) throws RemoteException;
	
	public float getGBPRate() throws RemoteException;	
}
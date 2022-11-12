package ServerRemote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.UsuarioGmail;
import domain.Entrenamiento;
import domain.Usuario;
import domain.Reto;
import dto.EntrenamientoAssembler;
import dto.EntrenamientoDTO;
import dto.RetoAssembler;
import dto.RetoDTO;
import dto.UsuarioDTO;
import dto.UsuarioAssembler;
import dto.TipoUsuarioDTO;
import services.ERAppService;
import services.LoginAppService;

public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {	
	private static final long serialVersionUID = 1L;

	//Data structure for manage Server State
	private Map<Long, Usuario> serverState = new HashMap<>();
	
	//TODO: Remove this instances when Singleton Pattern is implemented
	private LoginAppService loginService = new LoginAppService();
	private ERAppService eraService = new ERAppService();

	public RemoteFacade() throws RemoteException {
		super();		
	}
	
	@Override
	public synchronized long login(String email, String password, String nickname, TipoUsuarioDTO tipoUsuario) throws RemoteException {
		System.out.println(" * RemoteFacade login(): " + email + " / " + password + " / " +nickname+ " / " +tipoUsuario);
				
		//Perform login() using LoginAppService
		Usuario user = loginService.login(email, password, nickname, tipoUsuario);
			
		//If login() success user is stored in the Server State
		if (user != null) {
			//If user is not logged in 
			if (!this.serverState.values().contains(user)) {
				Long token = Calendar.getInstance().getTimeInMillis();		
				this.serverState.put(token, user);		
				return(token);
			} else {
				throw new RemoteException("User is already logged in!");
			}
		} else {
			throw new RemoteException("Login fails!");
		}
	}
	
	@Override
	public synchronized void logout(long token) throws RemoteException {
		System.out.println(" * RemoteFacade logout(): " + token);
		
		if (this.serverState.containsKey(token)) {
			//Logout means remove the User from Server State
			this.serverState.remove(token);
		} else {
			throw new RemoteException("User is not logged in!");
		}
	}

	@Override
	public float getGBPRate() throws RemoteException {
		System.out.println(" * RemoteFacade get GBP rate");
		
		//Get rate using BidAppService
		float rate = eraService.getGBPRate();
		
		if (rate != -1) {
			return rate;
		} else {
			throw new RemoteException("getGBPRate() fails!");
		}
	}

	@Override
	public ArrayList<RetoDTO> getRetos(String deporte) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void anyadirRetoARetos(RetoDTO reto, UsuarioDTO user) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quitarRetoARetos(String tituloReto) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UsuarioDTO registrarObligatorio(String email, String password, String nickname, TipoUsuarioDTO tipoUsuarioDTO)
			throws RemoteException {
		
		Usuario user = loginService.registrarObligatorio(email, password, nickname, tipoUsuarioDTO);
		UsuarioAssembler assembler = new UsuarioAssembler();
		UsuarioDTO usuarioDto = assembler.usuarioToDTO(user);
		
		return usuarioDto;
		
	}

	@Override
	public UsuarioDTO registrarCompleto(String email, String password, String nickname, TipoUsuarioDTO tipoUsuarioDTO,
			Integer peso, Integer altura, Integer frecCardMax, Integer frecCardReposo) throws RemoteException {
		// TODO Auto-generated method stub
		
		Usuario user = loginService.registrarCompleto(email, password, nickname, tipoUsuarioDTO, peso, altura, frecCardMax, frecCardReposo);
		UsuarioAssembler assembler = new UsuarioAssembler();
		UsuarioDTO usuarioDto = assembler.usuarioToDTO(user);
		
		return usuarioDto;
	}

	
}

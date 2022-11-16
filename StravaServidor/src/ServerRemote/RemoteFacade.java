package ServerRemote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import dto.TipoDeporteDTO;
import dto.UsuarioDTO;
import dto.UsuarioAssembler;
import dto.TipoUsuarioDTO;
import services.ERAppService;
import services.LoginAppService;

public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {	
	private static final long serialVersionUID = 1L;

	//Data structure for manage Server State
	private Map<Long, UsuarioDTO> serverState = new HashMap<>();
	private Map<Long, UsuarioGmail> serverStates = new HashMap<>();
	
	//TODO: Remove this instances when Singleton Pattern is implemented
	private LoginAppService loginService = new LoginAppService();
	private ERAppService eraService = new ERAppService();

	public RemoteFacade() throws RemoteException {
		super();		
	}
	
	@Override
	public long login(String email, String password, String nickname, TipoUsuarioDTO tipoUsuario) throws RemoteException {
//		System.out.println(" * RemoteFacade login(): " + email + " / " + password + " / " +nickname+ " / " +tipoUsuario);
//				
		//Perform login() using LoginAppService
		UsuarioGmail user = loginService.loginGmail(email, password, nickname, tipoUsuario);
		//If login() success user is stored in the Server State
		if (user != null) {
			//If user is not logged in 
			if (!this.serverStates.values().contains(user)) {
				Long token = Calendar.getInstance().getTimeInMillis();		
				this.serverStates.put(token, user);
				return(token);
			} else {
				throw new RemoteException("El usuario no esta registrado!");
			}
		} else {
			throw new RemoteException("Login fails!");
		}
	}
	
	public synchronized long loginGF(String email, String nickname, TipoUsuarioDTO tipoUsuario) throws RemoteException {
		System.out.println(" * RemoteFacade login(): " + email + " / " +nickname+ " / " +tipoUsuario);
//				
		//Perform login() using LoginAppService
		UsuarioDTO user = loginService.login(email, nickname, tipoUsuario);
		//If login() success user is stored in the Server State
		if (user != null) {
			//If user is not logged in 
			if (!this.serverState.values().contains(user)) {
				Long token = Calendar.getInstance().getTimeInMillis();		
				this.serverState.put(token, user);
				return(token);
			} else {
				throw new RemoteException("El usuario no esta registrado!");
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

//	@Override
//	public ArrayList<RetoDTO> getRetos(String deporte) throws RemoteException {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public void anyadirRetoARetos(RetoDTO reto, UsuarioDTO user) throws RemoteException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void quitarRetoARetos(String tituloReto) throws RemoteException {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public Long registrarObligatorio(String email, String password, String nickname, TipoUsuarioDTO tipoUsuarioDTO)
			throws RemoteException {
		
		UsuarioGmail user = loginService.registrarObligatorio(email, password, nickname, tipoUsuarioDTO);
		
		if (user != null) {
		//If user is not logged in 
		if (!this.serverStates.values().contains(user)) {
			Long token = Calendar.getInstance().getTimeInMillis();		
			this.serverStates.put(token, user);		
			return(token);
		} else {
			throw new RemoteException("Usuario ya registrado!");
		}
	} else {
		throw new RemoteException("Error de registro!");
	}
	}

	@Override
	public Long registrarCompleto(String email, String password, String nickname, TipoUsuarioDTO tipoUsuarioDTO,
			Integer peso, Integer altura, Integer frecCardMax, Integer frecCardReposo) throws RemoteException {
		
		
		UsuarioGmail usuarioDTO = loginService.registrarCompleto(email, password, nickname, tipoUsuarioDTO, peso, altura, frecCardMax, frecCardReposo);
		
		if (usuarioDTO != null) {
			//If user is not logged in 
			if (!this.serverStates.values().contains(usuarioDTO)) {
				Long token = Calendar.getInstance().getTimeInMillis();		
				this.serverStates.put(token, usuarioDTO);		
				return(token);
			} else {
				throw new RemoteException("Usuario ya registrado!");
			}
		} else {
			throw new RemoteException("Error de registro!");
		}
	}

	@Override
	public boolean crearReto(RetoDTO retoDTO) throws RemoteException {
		RetoAssembler assembler = new RetoAssembler();
		Reto reto = assembler.retoDTOTo(retoDTO);
		
		if (eraService.crearReto(reto)==true) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public boolean crearEntrenamiento(EntrenamientoDTO entrenamientoDTO) throws RemoteException {
		EntrenamientoAssembler assembler = new EntrenamientoAssembler();
		Entrenamiento entrenamiento = assembler.entrenamientoDTOTo(entrenamientoDTO);
		
		if (eraService.crearEntrenamiento(entrenamiento)==true) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Long registrarObligatorioFG(String email, String nickname, TipoUsuarioDTO tipoUsuarioDTO)
			throws RemoteException {
		
		UsuarioDTO usuDTO = loginService.registrarObligatorioFG(email, nickname, tipoUsuarioDTO);
		
		if (usuDTO != null) {
			//If user is not logged in 
			if (!this.serverState.values().contains(usuDTO)) {
				Long token = Calendar.getInstance().getTimeInMillis();		
				this.serverState.put(token, usuDTO);		
				return(token);
			} else {
				throw new RemoteException("Usuario ya registrado!");
			}
		} else {
			throw new RemoteException("Error de registro!");
		}
		
//		return usuDTO;
	}

	@Override
	public Long registrarCompletoFG(String email, String nickname, TipoUsuarioDTO tipoUsuarioDTO, Integer peso,
			Integer altura, Integer frecCardMax, Integer frecCardReposo) throws RemoteException {
		
		UsuarioDTO usuDTO = loginService.registrarCompletoFG(email,nickname, tipoUsuarioDTO, peso, altura, frecCardMax, frecCardReposo);
		
		if (usuDTO != null) {
			//If user is not logged in 
			if (!this.serverState.values().contains(usuDTO)) {
				Long token = Calendar.getInstance().getTimeInMillis();		
				this.serverState.put(token, usuDTO);		
				return(token);
			} else {
				throw new RemoteException("Usuario ya registrado!");
			}
		} else {
			throw new RemoteException("Error de registro!");
		}
	}

	@Override
	public List<RetoDTO> getTodosRetos() throws RemoteException {
		List<Reto> listaRetos;
		listaRetos = eraService.getTodosRetos();
		System.out.println("RemoteFacade1:"+listaRetos.size());
		
		RetoAssembler assembler = new RetoAssembler();
		List<RetoDTO> listaRetosDTO =  assembler.retosToDTO(listaRetos);
		System.out.println("RemoteFacade2:"+listaRetosDTO.size());
		return listaRetosDTO;
	}
	
	@Override
	public List<EntrenamientoDTO> getTodosEntrenamientos() throws RemoteException {
		List<Entrenamiento> listaEntrenamientos;
		listaEntrenamientos = eraService.getTodosEntrenamiento();
		System.out.println("RemoteFacade1:"+listaEntrenamientos.size());
		
		EntrenamientoAssembler assembler = new EntrenamientoAssembler();
		List<EntrenamientoDTO> listaEntrenamientosDTO =  assembler.entrenamientosToDTO(listaEntrenamientos);
		System.out.println("RemoteFacade2:"+listaEntrenamientosDTO.size());
		return listaEntrenamientosDTO;
	}
}

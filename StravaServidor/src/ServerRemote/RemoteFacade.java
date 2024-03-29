package ServerRemote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
import dto.TipoUsuarioDTO;
import dto.UsuarioAssembler;
import dto.UsuarioDTO;
import services.ERAppService;
import services.LoginAppService;

public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {
	private static final long serialVersionUID = 1L;

	// Data structure for manage Server State
	private Map<Long, Usuario> serverState = new HashMap<>(); // mapa de los token y usuarios

	// TODO: Remove this instances when Singleton Pattern is implemented
	private ERAppService eraService = new ERAppService();

	public RemoteFacade() throws RemoteException {
		super();
	}


	@Override
	public long login(String email, String password, String nickname, TipoUsuarioDTO tipoUsuarioDTO)
			throws RemoteException {
		System.out.println(" * RemoteFacade login(): " + email + " / " + password + " / " +nickname+ " / " +tipoUsuarioDTO);
		
		Usuario user = LoginAppService.getInstance().login(email, password, nickname, tipoUsuarioDTO);

		Long token = (long) -1;
		// If login() success user is stored in the Server State
		if (user != null) {
			// If user is not logged in
			if (!this.serverState.values().contains(user)) {
				token = Calendar.getInstance().getTimeInMillis();
				this.serverState.put(token, user);
				return (token);
			} else {
				throw new RemoteException("El usuario no esta registrado!");
			}
		} else {
			System.out.println("Error en el remotefacade loginGmail");
			return(token);
		}
	}


	@Override
	public synchronized void logout(long token) throws RemoteException {
		System.out.println(" * RemoteFacade logout(): " + token);

		if (this.serverState.containsKey(token)) {
			// Logout means remove the User from Server State
			this.serverState.remove(token);
		} else {
			throw new RemoteException("User is not logged in!");
		}
	}



	@Override
	public boolean registrarObligatorio(String email, String password, String nickname, TipoUsuarioDTO tipoUsuarioDTO)
			throws RemoteException {
		LoginAppService loginService = LoginAppService.getInstance();
		if (loginService.registrarObligatorio(email, password, nickname, tipoUsuarioDTO)) {
			return true;

		} else {
			return false;
		}

	}

	@Override
	public boolean registrarCompleto(String email, String password, String nickname, TipoUsuarioDTO tipoUsuarioDTO,
			Integer peso, Integer altura, Integer frecCardMax, Integer frecCardReposo) throws RemoteException {
		LoginAppService loginService = LoginAppService.getInstance();
		if (loginService.registrarCompleto(email, password, nickname, tipoUsuarioDTO, peso, altura, frecCardMax,
				frecCardReposo) == true) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean crearReto(long token, RetoDTO retoDTO) throws RemoteException {
		
		if (this.serverState.containsKey(token)) {
			
			UsuarioAssembler asem = UsuarioAssembler.getInstance();
			UsuarioDTO usuDTO = asem.usuarioToDTO(this.serverState.get(token));
			retoDTO.setCreador(usuDTO);
			RetoAssembler assembler = RetoAssembler.getInstance();//Usar patron singleton
			Reto reto = assembler.retoDTOTo(retoDTO);

			if (eraService.crearReto(this.serverState.get(token), reto) == true) {
				return true;
			} else {
				return false;
			}
			
		} else {
			throw new RemoteException("User is not logged in!");
		}

	}

	@Override
	public boolean crearEntrenamiento(long token, EntrenamientoDTO entrenamientoDTO) throws RemoteException {
		
		if (this.serverState.containsKey(token)) {
			EntrenamientoAssembler assembler =EntrenamientoAssembler.getInstance();//Usar patron singleton
			Entrenamiento entrenamiento = assembler.entrenamientoDTOTo(entrenamientoDTO);

			if (eraService.crearEntrenamiento(this.serverState.get(token),entrenamiento) == true) {
				return true;
			} else {
				return false;
			}
		} else {
			throw new RemoteException("User is not logged in!");
		}
		
	}

	@Override
	public boolean registrarObligatorioFacebook(String email, String nickname, TipoUsuarioDTO tipoUsuarioDTO)
			throws RemoteException {
		LoginAppService loginService = LoginAppService.getInstance();
		if (loginService.registrarObligatorioFacebook(email, nickname, tipoUsuarioDTO)==true) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean registrarObligatorioGoogle(String email, String nickname, TipoUsuarioDTO tipoUsuarioDTO)
			throws RemoteException {
		boolean resultado = false;
		LoginAppService loginService = LoginAppService.getInstance();
		if (loginService.registrarObligatorioGoogle(email, nickname, tipoUsuarioDTO)==true) {
			resultado= true;
		} else {
			resultado= false;
		}
		 return resultado;
	}

	@Override
	public boolean registrarCompletoFacebook(String email, String nickname, TipoUsuarioDTO tipoUsuarioDTO, Integer peso,
			Integer altura, Integer frecCardMax, Integer frecCardReposo) throws RemoteException {
		LoginAppService loginService = LoginAppService.getInstance();
		if (loginService.registrarCompletoFacebook(email, nickname, tipoUsuarioDTO, peso, altura, frecCardMax,
				frecCardReposo)==true) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean registrarCompletoGoogle(String email, String nickname, TipoUsuarioDTO tipoUsuarioDTO, Integer peso,
			Integer altura, Integer frecCardMax, Integer frecCardReposo) throws RemoteException {
		LoginAppService loginService = LoginAppService.getInstance();
		if (loginService.registrarCompletoGoogle(email, nickname, tipoUsuarioDTO, peso, altura, frecCardMax,
				frecCardReposo)==true) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<RetoDTO> getTodosRetos() throws RemoteException {
		List<Reto> listaRetos;
		listaRetos = eraService.getTodosRetos();
		
		RetoAssembler assembler=RetoAssembler.getInstance();//usar patron singleton
		List<RetoDTO> listaRetosDTO = assembler.retosToDTO(listaRetos);
		return listaRetosDTO;
	}

	@Override
	public List<EntrenamientoDTO> getTodosEntrenamientos(long token) throws RemoteException {
		
		if (this.serverState.containsKey(token)) {
			List<Entrenamiento> listaEntrenamientos;
			listaEntrenamientos = eraService.getTodosEntrenamiento(this.serverState.get(token));
			
			EntrenamientoAssembler assembler =EntrenamientoAssembler.getInstance();//Usar patron singleton
			List<EntrenamientoDTO> listaEntrenamientosDTO = assembler.entrenamientosToDTO(listaEntrenamientos);
			
			return listaEntrenamientosDTO;
		} else {
			throw new RemoteException("User is not logged in!");
		}
	}

	@Override
	public List<RetoDTO> getRetosAceptados(long token) throws RemoteException {
		if (this.serverState.containsKey(token)) {
			List<Reto> listaRetos;
			listaRetos = eraService.getRetosAceptados(this.serverState.get(token));

			RetoAssembler assembler=RetoAssembler.getInstance();//usar patron singleton
			List<RetoDTO> listaRetosDTO = assembler.retosToDTO(listaRetos);
			
			return listaRetosDTO;
		} else {
			throw new RemoteException("User is not logged in!");
		}
		
	}

	@Override
	public boolean aceptarReto(long token, RetoDTO retoDTO) throws RemoteException {
		if (this.serverState.containsKey(token)) {
			RetoAssembler assembler=RetoAssembler.getInstance();//usar patron singleton 
			Reto re =assembler.retoDTOTo(retoDTO);
			if(eraService.aceptarReto(this.serverState.get(token), re)) {
				return true;
			}
			
		} else {
			throw new RemoteException("User is not logged in!");
		}
		return false;
		
	}




}

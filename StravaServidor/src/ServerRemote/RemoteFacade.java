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

	// Data structure for manage Server State
	private Map<Long, Usuario> serverState = new HashMap<>(); // mapa de los token y usuarios

	// TODO: Remove this instances when Singleton Pattern is implemented
	private LoginAppService loginService = new LoginAppService();
	private ERAppService eraService = new ERAppService();

	public RemoteFacade() throws RemoteException {
		super();
	}

	@Override
	public long loginGmail(String email, String password, String nickname) throws RemoteException {
//		System.out.println(" * RemoteFacade login(): " + email + " / " + password + " / " +nickname+ " / " +tipoUsuario);
//				
		// Perform login() using LoginAppService
		UsuarioGmail user = loginService.loginGmail(email, password, nickname);
		
		Long token = (long) -1;
		// If login() success user is stored in the Server State
		if (!(user.getNombre() == "" && user.getEmail() == "" && user.password=="")) {
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

	public synchronized long loginGoogle(String email, String nickname) throws RemoteException {

		// Perform login() using LoginAppService
		Usuario user = loginService.loginGoogle(email, nickname);
		System.out.println(" * RemoteFacade login(): " + user.getEmail() + " / " + user.getNombre());
		Long token = (long) -1;
		// If login() success user is stored in the Server State
		if (!(user.getNombre() == "" && user.getEmail() == "")) {
			// If user is not logged in
			if (!this.serverState.values().contains(user)) {
				token = Calendar.getInstance().getTimeInMillis();
				this.serverState.put(token, user);
				return (token);
			} else {
				throw new RemoteException("El usuario no esta registrado!");
			}
		} else {
			System.out.println("Error en el remotefacade loginGoogle");
			return (token);
		}
	}

	public synchronized long loginFacebook(String email, String nickname) throws RemoteException {

		// Perform login() using LoginAppService
		Usuario user = loginService.loginFacebook(email, nickname);
		System.out.println(" * RemoteFacade login(): " + user.getEmail() + " / " + user.getNombre());
		Long token = (long) -1;
		// If login() success user is stored in the Server State
		if (!(user.getNombre() == "" && user.getEmail() == "")) {
			// If user is not logged in
			if (!this.serverState.values().contains(user)) {
				token = Calendar.getInstance().getTimeInMillis();
				this.serverState.put(token, user);
				return (token);
			} else {
				throw new RemoteException("El usuario no esta registrado!");
			}
		} else {
			System.out.println("Error en el remotefacade loginFacebook");
			return (token);
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
	public float getGBPRate() throws RemoteException {
		System.out.println(" * RemoteFacade get GBP rate");

		// Get rate using BidAppService
		float rate = eraService.getGBPRate();

		if (rate != -1) {
			return rate;
		} else {
			throw new RemoteException("getGBPRate() fails!");
		}
	}


	@Override
	public boolean registrarObligatorio(String email, String password, String nickname, TipoUsuarioDTO tipoUsuarioDTO)
			throws RemoteException {

		if (loginService.registrarObligatorio(email, password, nickname, tipoUsuarioDTO)) {
			return true;

		} else {
			return false;
		}

	}

	@Override
	public boolean registrarCompleto(String email, String password, String nickname, TipoUsuarioDTO tipoUsuarioDTO,
			Integer peso, Integer altura, Integer frecCardMax, Integer frecCardReposo) throws RemoteException {

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
			
			RetoAssembler assembler = new RetoAssembler();
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
			EntrenamientoAssembler assembler = new EntrenamientoAssembler();
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

		if (loginService.registrarObligatorioFacebook(email, nickname, tipoUsuarioDTO)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean registrarObligatorioGoogle(String email, String nickname, TipoUsuarioDTO tipoUsuarioDTO)
			throws RemoteException {

		if (loginService.registrarObligatorioGoogle(email, nickname, tipoUsuarioDTO)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean registrarCompletoFacebook(String email, String nickname, TipoUsuarioDTO tipoUsuarioDTO, Integer peso,
			Integer altura, Integer frecCardMax, Integer frecCardReposo) throws RemoteException {

		if (loginService.registrarCompletoFacebook(email, nickname, tipoUsuarioDTO, peso, altura, frecCardMax,
				frecCardReposo)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean registrarCompletoGoogle(String email, String nickname, TipoUsuarioDTO tipoUsuarioDTO, Integer peso,
			Integer altura, Integer frecCardMax, Integer frecCardReposo) throws RemoteException {

		if (loginService.registrarCompletoGoogle(email, nickname, tipoUsuarioDTO, peso, altura, frecCardMax,
				frecCardReposo)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<RetoDTO> getTodosRetos() throws RemoteException {
		List<Reto> listaRetos;
		listaRetos = eraService.getTodosRetos();

		RetoAssembler assembler = new RetoAssembler();
		List<RetoDTO> listaRetosDTO = assembler.retosToDTO(listaRetos);
		return listaRetosDTO;
	}

	@Override
	public List<EntrenamientoDTO> getTodosEntrenamientos(long token) throws RemoteException {
		
		if (this.serverState.containsKey(token)) {
			List<Entrenamiento> listaEntrenamientos;
			listaEntrenamientos = eraService.getTodosEntrenamiento(this.serverState.get(token));
			
			EntrenamientoAssembler assembler = new EntrenamientoAssembler();
			List<EntrenamientoDTO> listaEntrenamientosDTO = assembler.entrenamientosToDTO(listaEntrenamientos);
			
			return listaEntrenamientosDTO;
		} else {
			throw new RemoteException("User is not logged in!");
		}
	}

	@Override
	public List<RetoDTO> getRetosPersonales(long token) throws RemoteException {
		if (this.serverState.containsKey(token)) {
			List<Reto> listaRetos;
			listaRetos = eraService.getRetoPersonal(this.serverState.get(token));
			System.out.println("RemoteFacade1:" + listaRetos.size());

			RetoAssembler assembler = new RetoAssembler();
			List<RetoDTO> listaRetosDTO = assembler.retosToDTO(listaRetos);
			System.out.println("RemoteFacade2:" + listaRetosDTO.size());
			
			return listaRetosDTO;
		} else {
			throw new RemoteException("User is not logged in!");
		}
		
	}

	@Override
	public boolean aceptarReto(long token, RetoDTO retoDTO) throws RemoteException {
		boolean result=false;
		if (this.serverState.containsKey(token)) {
			RetoAssembler assembler = new RetoAssembler();
			Reto re =assembler.retoDTOTo(retoDTO);
			
			
			if(eraService.aceptarReto(this.serverState.get(token), re)) {
				List<RetoDTO> retos =getRetosPersonales(token);
				retos.add(retoDTO);
				result =true;
			}
			
		} else {
			throw new RemoteException("User is not logged in!");
		}
		return result;
		
	}

}

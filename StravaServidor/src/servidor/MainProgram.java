package servidor;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;

import ServerRemote.IRemoteFacade;
import ServerRemote.RemoteFacade;
import dao.DAO;
import dao.EntrenamientoDAO;
import dao.UsuarioDAO;
import domain.Usuario;
import domain.Entrenamiento;
import domain.Reto;
import domain.TipoUsuario;
import domain.TipoDeporte;


public class MainProgram {

	@SuppressWarnings("removal")
	public static void main(String[] args) {	
		//Activate Security Manager. It is needed for RMI.
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		//args[0] = RMIRegistry IP
		//args[1] = RMIRegistry Port
		//args[2] = Service Name
		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];	
		
		initDB();
		
		//Bind remote facade instance to a sirvice name using RMIRegistry
		try {
			IRemoteFacade remoteFacade = new RemoteFacade();			
			Naming.rebind(name, remoteFacade);
			System.out.println(" * StravaServidor '" + name + "' started!!");
		} catch (Exception ex) {
			System.err.println(" # StravaServer Exception: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	private static void initDB() {
		
		//Usuarios
		Usuario user0 = new Usuario();		
		user0.setNumero(0);
		user0.setEmail("thomas@gmail.com");
		user0.setNombre("Thomas");
		user0.setAltura(0);
		user0.setPesoKG(0);
		user0.setFrecCardMax(0);
		user0.setFrecCardResposo(0);;
		user0.setTipoUsuario(TipoUsuario.FACEBOOK);
		List<Reto> retosAceptados = new ArrayList<Reto>();
		user0.setRetos(retosAceptados);
		
		//Entrenamientos
		Entrenamiento entrenamiento1 = new Entrenamiento();
		entrenamiento1.setTitulo("BiciMax");
		entrenamiento1.setDistanciaKm(200);
		entrenamiento1.setFecha_ini("11/01/2021");
		entrenamiento1.setDuracion(20);
		entrenamiento1.setHora(1222);
		entrenamiento1.setDeporte(TipoDeporte.CICLISMO);
		
		
		//Save Users in the DB
		UsuarioDAO.getInstance().guardarObjeto(user0);
		EntrenamientoDAO.getInstance().guardarObjeto(entrenamiento1);
//		UserDAO.getInstance().save(user1);
//		UserDAO.getInstance().save(user2);
	}

}

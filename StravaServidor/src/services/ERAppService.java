package services;

import java.util.ArrayList;
import java.util.List;

import dao.EntrenamientoDAO;
import dao.RetoDAO;
import dao.UsuarioDAO;
import domain.Entrenamiento;
import domain.Reto;
import domain.TipoDeporte;
import domain.Usuario;
import domain.UsuarioGmail;


public class ERAppService {

	private List<Reto> listaRetos = new ArrayList<>();
	public List<Usuario> listaUser = new ArrayList<>();
	public List<Entrenamiento> listaEntrenamiento = new ArrayList<>();
	public static ERAppService instance;

	public static ERAppService getInstance() {
		if (instance == null) {
			instance = new ERAppService();
		}

		return instance;
	}

	public ERAppService() {
		this.initilizeData();
	}

	private void initilizeData() {
//Create Users

//		UsuarioGmail user0 = new UsuarioGmail();
//		user0.setEmail("thomas.e2001@gmail.com");
//		user0.setNombre("Thomas");
//		user0.setPassword("aaa");
//
//		UsuarioGmail user1 = new UsuarioGmail();
//		user1.setEmail("sample@gmail.com");
//		user1.setNombre("buyer33");
//		user1.setPassword("hqc`}3Hb");
//
//		listaUser.add(user0);
//		listaUser.add(user1);

//Create Reto
//		Reto reto1 = new Reto();
//		reto1.setNombre("Pedalear Muchisimo");
//		reto1.setDescripcion("Quema tu bici");
//		reto1.setCreador(user0.getNumero());
//		reto1.setFecha_ini("01/01/2021");
//		reto1.setFecha_fin("31/12/2021");
//		reto1.setDistancia(10);
//		reto1.setDeporte(TipoDeporte.CICLISMO);
//
//		Reto reto2 = new Reto();
//		reto2.setNombre("Correr Muchisimo");
//		reto2.setDescripcion("Huye de la policia");
//		reto2.setCreador(user1.getNumero());
//		reto2.setFecha_ini("31/10/2021");
//		reto2.setFecha_fin("31/12/2021");
//		reto2.setDistancia(5);
//		reto2.setDeporte(TipoDeporte.RUNNING);
//
//		listaRetos.add(reto1);
//		listaRetos.add(reto2);
//		
//		Entrenamiento entr = new Entrenamiento();
//		entr.setTitulo("CrossFit");
//		entr.setDeporte(TipoDeporte.RUNNING);
//		entr.setDistanciaKm(10);
//		entr.setDuracion(10);
//		entr.setFecha_ini("31/10/2021");
//		entr.setHora(21);
////		entr.setCreador(user1);
//
//		Entrenamiento entr1 = new Entrenamiento();
//		entr1.setTitulo("Correr 10KM");
//		entr1.setDeporte(TipoDeporte.RUNNING);
//		entr1.setDistanciaKm(10);
//		entr1.setDuracion(20);
//		entr1.setFecha_ini("21/10/2021");
//		entr1.setHora(18);
////		entr1.setCreador(user0);
//
//		listaEntrenamiento.add(entr1);
//		listaEntrenamiento.add(entr);

	}

	public boolean crearReto(Usuario u, Reto reto) {
		RetoDAO.getInstance().guardar(reto);
		System.out.println("Se ha creado el Reto correctamente");
		return true;

	}

	public boolean aceptarReto(Usuario u, Reto reto) {
		
		for (Reto ret : RetoDAO.getInstance().getAll()) {
			if (ret.getNombre().equals(reto.getNombre())&& ret.getDescripcion().equals(reto.getDescripcion()) && ret.getDeporte().equals(reto.getDeporte()) && ret.getDistancia()==reto.getDistancia() && ret.getFecha_ini().equals(reto.getFecha_ini())&& ret.getFecha_fin().equals(reto.getFecha_fin())) {
				u.getRetos().add(ret);
				UsuarioDAO.getInstance().updateUser(u);
				System.out.println("Reto Aceptado correctamente");
				return true;
		}
		}
		return false;

	}
	

	public boolean crearEntrenamiento(Usuario u, Entrenamiento entrenamiento) {
		
		u.addEntrenamiento(entrenamiento);
		UsuarioDAO.getInstance().updateUser(u);
//		UsuarioDAO.getInstance().guardar(u);
//		EntrenamientoDAO.getInstance().guardar(entrenamiento);
		System.out.println("Se ha creado el Entrenamiento correctamente");
		return true;
	}

	public List<Reto> getTodosRetos() {
		
		return RetoDAO.getInstance().getAll();

	}

	public List<Entrenamiento> getTodosEntrenamiento(Usuario usuario) {
		return usuario.getEntrenamientos();
	}

	public List<Reto> getRetosAceptados(Usuario usuario) {
		return usuario.getRetos();

	}

}

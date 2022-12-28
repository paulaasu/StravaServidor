package services;

import java.util.ArrayList;
import java.util.List;
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

		UsuarioGmail user0 = new UsuarioGmail();
		user0.setEmail("thomas.e2001@gmail.com");
		user0.setNombre("Thomas");
		user0.setPassword("aaa");

		UsuarioGmail user1 = new UsuarioGmail();
		user1.setEmail("sample@gmail.com");
		user1.setNombre("buyer33");
		user1.setPassword("hqc`}3Hb");

		listaUser.add(user0);
		listaUser.add(user1);

//Create Reto
		Reto reto1 = new Reto();
		reto1.setNombre("Pedalear Muchisimo");
		reto1.setDescripcion("Quema tu bici");
		reto1.setCreador(user0.getNumero());
		reto1.setFecha_ini("01/01/2021");
		reto1.setFecha_fin("31/12/2021");
		reto1.setDistancia(10);
		reto1.setDeporte(TipoDeporte.CICLISMO);

		Reto reto2 = new Reto();
		reto2.setNombre("Correr Muchisimo");
		reto2.setDescripcion("Huye de la policia");
		reto2.setCreador(user1.getNumero());
		reto2.setFecha_ini("31/10/2021");
		reto2.setFecha_fin("31/12/2021");
		reto2.setDistancia(5);
		reto2.setDeporte(TipoDeporte.RUNNING);

		listaRetos.add(reto1);
		listaRetos.add(reto2);
		
		Entrenamiento entr = new Entrenamiento();
		entr.setTitulo("CrossFit");
		entr.setDeporte(TipoDeporte.RUNNING);
		entr.setDistanciaKm(10);
		entr.setDuracion(10);
		entr.setFecha_ini("31/10/2021");
		entr.setHora(21);
		entr.setCreador(user1);

		Entrenamiento entr1 = new Entrenamiento();
		entr1.setTitulo("Correr 10KM");
		entr1.setDeporte(TipoDeporte.RUNNING);
		entr1.setDistanciaKm(10);
		entr1.setDuracion(20);
		entr1.setFecha_ini("21/10/2021");
		entr1.setHora(18);
		entr1.setCreador(user0);

		listaEntrenamiento.add(entr1);
		listaEntrenamiento.add(entr);

	}

	public boolean crearReto(Usuario u, Reto reto) {

		reto.setCreador(u.getNumero());
		System.out.println("Se ha creado el Reto correctamente");
		RetoARetos(reto);
		return true;

	}

	public boolean aceptarReto(Usuario u, Reto reto) {
		boolean resultado = false;
		for (Reto ret : listaRetos) {
			if (ret.getNombre().equals(reto.getNombre())&& ret.getDescripcion().equals(reto.getDescripcion()) && ret.getDeporte().equals(reto.getDeporte()) && ret.getDistancia()==reto.getDistancia() && ret.getFecha_ini().equals(reto.getFecha_ini())&& ret.getFecha_fin().equals(reto.getFecha_fin())&&ret.getCreador()==reto.getCreador()) {
				System.out.println("Reto Aceptado correctamente");
				u.getRetos().add(reto);
				resultado= true;
			}else {
				resultado= false;
			}
		}
		return resultado;

	}
	

	public boolean crearEntrenamiento(Usuario u, Entrenamiento entrenamiento) {
		entrenamiento.setCreador(u.getNumero());
		System.out.println("Se ha creado el Entrenamiento correctamente");
		EntrenaAEntrena(entrenamiento);
		return true;
	}

	public void RetoARetos(Reto reto) {
		listaRetos.add(reto);
	}

	public void EntrenaAEntrena(Entrenamiento entre) {
		listaEntrenamiento.add(entre);
	}

	public List<Reto> getTodosRetos() {
		return listaRetos;

	}

	public List<Entrenamiento> getTodosEntrenamiento(Usuario usuario) {
		List<Entrenamiento> listaEntrenaPersonal = new ArrayList<>();
		for (Entrenamiento entrenamiento : listaEntrenamiento) {
			if (entrenamiento.getCreador() == usuario.getNumero()) {
				listaEntrenaPersonal.add(entrenamiento);
			}
		}
		return listaEntrenaPersonal;

	}

	public List<Reto> getRetosAceptados(Usuario usuario) {
		return usuario.getRetos();

	}

}

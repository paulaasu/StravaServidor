package services;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import domain.Entrenamiento;
import domain.Reto;
import domain.Usuario;
import domain.UsuarioGmail;
import dto.RetoAssembler;
import dto.RetoDTO;


//TODO: Implement Singleton Pattern
public class ERAppService {

	private List<Reto> retos = new ArrayList<>();
	public List<Usuario> listaUser = new ArrayList<>();
	private RetoAssembler assemblerReto = new RetoAssembler();

	public ERAppService() {
		this.initilizeData();
	}

	private void initilizeData() {
		//Create Users
		
		
		UsuarioGmail user0 = new UsuarioGmail();
		user0.setEmail("thomas.e2001@gmail.com");
		user0.setNombre("Thomas");
		user0.setPassword("aaa");
		user0.setNumero(1);

		
		
		UsuarioGmail user1 = new UsuarioGmail();
		user1.setEmail("sample@gmail.com");
		user1.setNombre("buyer33");		
		user1.setPassword("hqc`}3Hb");
		user0.setNumero(2);

		listaUser.add(user0);
		listaUser.add(user1);
		
		//Create Reto
		Reto reto1 = new Reto();
		reto1.setNombre("Pedalear Muchisimo");
		reto1.setDescripcion("�quema tu bici!");
		reto1.setCreador(user0.getNumero());
		reto1.setFecha_ini("01/01/2021");
		reto1.setFecha_fin("31/12/2021");
		reto1.setDeporte("bici");

		Reto reto2 = new Reto();
		reto2.setNombre("Correr Muchisimo");
		reto2.setDescripcion("Huye de la policia");
		reto2.setCreador(user1.getNumero());
		reto2.setFecha_ini("31/10/2021");
		reto2.setFecha_fin("31/12/2021");
		reto2.setDeporte("correr");

		retos.add(reto1);
		retos.add(reto2);

	}
	public RetoDTO crearReto(String nombre, String descripcion, String fecha_ini, String fecha_fin, int distancia,String deporte, int creador) {
		RetoDTO reto = new RetoDTO(nombre,descripcion,fecha_ini,fecha_fin,distancia,deporte, creador);
		System.out.println("Se ha creado el RETO correctamente");
		return reto;		
	}
//	public Reto obtenerReto(String nombre, String descripcion, String fecha_ini, String fecha_fin, int distancia, long tiempoObjetivo,String deporte, int creador) {
//		
//		Reto reto = new Reto(nombre,descripcion,fecha_ini,fecha_fin,distancia, tiempoObjetivo,deporte, creador);
//		
//		System.out.println("Se ha creado el RETO correctamente");		
//		return reto;
//	}
	
	
	public Entrenamiento crearEntrenamiento(String titulo, String deporte, int distanciaKm, Date fecha_ini, int hora, int duracion) {
		Entrenamiento entrenamiento = new Entrenamiento(titulo, deporte,distanciaKm,fecha_ini, hora, duracion);
		
		System.out.println("Se ha creado el Entrenamiento correctamente");
		return entrenamiento;
	}
	

	public float getGBPRate() {
		// TODO Auto-generated method stub
		return 0;
	}
}
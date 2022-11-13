package services;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import domain.Entrenamiento;
import domain.Reto;
import domain.Usuario;
import domain.UsuarioGmail;
import dto.EntrenamientoDTO;
import dto.RetoAssembler;
import dto.RetoDTO;

//TODO: Implement Singleton Pattern
public class ERAppService {

	private List<Reto> listaRetos = new ArrayList<>();
	public List<Usuario> listaUser = new ArrayList<>();
	public List<Entrenamiento> listaEntrenamiento = new ArrayList<>();
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

		UsuarioGmail user1 = new UsuarioGmail();
		user1.setEmail("sample@gmail.com");
		user1.setNombre("buyer33");
		user1.setPassword("hqc`}3Hb");

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

		listaRetos.add(reto1);
		listaRetos.add(reto2);
		System.out.println("ERAppService:"+listaRetos.size());

		Entrenamiento entr = new Entrenamiento();
		entr.setTitulo("CrossFit");
		entr.setDeporte("GYM");
		entr.setDistanciaKm(10);
		entr.setDuracion(10);
		entr.setFecha_ini("31/10/2021");
		entr.setHora(21);
		entr.setCreador(user1);
		
		Entrenamiento entr1 = new Entrenamiento();
		entr1.setTitulo("Correr 10KM");
		entr1.setDeporte("Correr");
		entr1.setDistanciaKm(10);
		entr1.setDuracion(20);
		entr1.setFecha_ini("21/10/2021");
		entr1.setHora(18);
		entr1.setCreador(user0);
		
		listaEntrenamiento.add(entr1);
		listaEntrenamiento.add(entr);
		

}
	public Reto crearReto(String nombre, String descripcion, String fecha_ini, String fecha_fin, int distancia,String deporte, int creador) {
		Reto reto = new Reto(nombre,descripcion,fecha_ini,fecha_fin,distancia,deporte, creador);
		System.out.println("Se ha creado el RETO correctamente");
		RetoARetos(reto);
		return reto;
}


	public Entrenamiento crearEntrenamiento(String titulo, String deporte, int distanciaKm, String fecha_ini, int hora, int duracion, int creador) {
		Entrenamiento entrenamiento = new Entrenamiento(titulo, deporte, distanciaKm, fecha_ini, hora, duracion, creador);
		System.out.println("Se ha creado el Entrenamiento correctamente");
		EntrenaAEntrena(entrenamiento);
		return entrenamiento;
}
	public void RetoARetos(Reto reto) {
		listaRetos.add(reto);
	}
	public void EntrenaAEntrena(Entrenamiento entre) {
		listaEntrenamiento.add(entre);
	}

	public List<Reto> getTodosRetos(){
		return listaRetos;

}
	public List<Entrenamiento> getTodosEntrenamiento(){
		return listaEntrenamiento;

}

	public float getGBPRate() {
// TODO Auto-generated method stub
		return 0;
}
}

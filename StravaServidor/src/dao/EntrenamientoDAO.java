package dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import domain.Entrenamiento;
import domain.Usuario;

public class EntrenamientoDAO implements IDAO<Entrenamiento>{
	private static EntrenamientoDAO instance;	

	
	public static EntrenamientoDAO getInstance() {
		if (instance == null) {
			instance = new EntrenamientoDAO();
		}		
		
		return instance;
	}
	
	private PersistenceManagerFactory pmf;

	public EntrenamientoDAO() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}

	

	@Override
	public void borrarObjeto(Entrenamiento object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();			
			pm.deletePersistent(object);			
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error deleting an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		
	}

	@Override
	public List<Entrenamiento> getAll() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		List<Entrenamiento> entrenamientos = new ArrayList<>();

		try {
			tx.begin();
			
			Extent<Entrenamiento> entrenamientoExtent = pm.getExtent(Entrenamiento.class, true);
			
			for (Entrenamiento entrenamiento : entrenamientoExtent) {
				entrenamientos.add(entrenamiento);
			}
						
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying all users: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return entrenamientos;
	}

	@Override
	public Entrenamiento buscarObjetos(String condicion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(Entrenamiento object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println("   * Storing an object: " + object);
			pm.makePersistent(object);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error storing an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		
	}
	
	
}

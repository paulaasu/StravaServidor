package dao;

import java.util.List;


public interface IDAO<DomainObject> {
	public void borrarObjeto(DomainObject object);
	public List<DomainObject> getAll();
	public DomainObject buscarObjetos(String condicion);
	
	public void guardar(DomainObject object);
}

package factory;

import java.rmi.Naming;


import remote.IGoogle;

public class GoogleGateway implements ILoginGateway {
	private static GoogleGateway instance;
	private IGoogle GoogleService;
	
	public GoogleGateway() {
		try {		
			String URL = "//127.0.0.1:1099/ServidorGoogle";
			this.GoogleService = (IGoogle) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating remote service: " + ex);
		}
	}
	
	public static GoogleGateway getInstance() {
		if(instance == null) {
			instance = new GoogleGateway();
		}
		
		return instance;
	}

	@Override
	public boolean comprobarCuenta(String email, String contasenya) {
		boolean resultado = false;
		try {
			if (this.GoogleService.checkUsuario(email, contasenya)) {
				resultado = true;
			} else {
				resultado= false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public boolean comprobarEmail(String email) {
		boolean resultado = false;
		try {
			if (this.GoogleService.checkEmail(email)) {
				resultado = true;
			} else {
				resultado= false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
	


	
}
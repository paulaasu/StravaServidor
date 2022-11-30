package gateway;

import java.rmi.Naming;


import remote.IGoogle;

public class GoogleGateway {
	private static GoogleGateway instance;
	private IGoogle currencyConvService;
	
	private GoogleGateway() {
		try {		
			String URL = "//127.0.0.1:1099/ServidorGoogle";
			this.currencyConvService = (IGoogle) Naming.lookup(URL);
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

	
	public boolean checkCuenta(String email, String contasenya) {
		boolean resultado = false;
		try {
			if (this.currencyConvService.checkUsuario(email, contasenya)) {
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
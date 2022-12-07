package factory;


public class LoginFactory {
	public static ILoginGateway crearLoginService(String metodo) {
		if (metodo.equals("Google")) {
			return (ILoginGateway) new GoogleGateway();
		} else if (metodo.equals("Facebook")) {
			final String serverIP = "127.0.0.1";
			final int serverPort = 8001;
			return new FacebookSocketCliente(serverIP, serverPort);
		} else {
			return null;
		}
	}

}
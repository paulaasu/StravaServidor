package factory;

public interface ILoginGateway {
	public boolean comprobarCuenta(String email, String contrasenya);
	public boolean comprobarEmail(String email);
}

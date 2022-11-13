package servidor;

import java.rmi.Naming;

import ServerRemote.IRemoteFacade;
import ServerRemote.RemoteFacade;

public class MainProgram {

	public static void main(String[] args) {	
		//Activate Security Manager. It is needed for RMI.
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		//args[0] = RMIRegistry IP
		//args[1] = RMIRegistry Port
		//args[2] = Service Name
		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];		
		
		//Bind remote facade instance to a sirvice name using RMIRegistry
		try {
			IRemoteFacade remoteFacade = new RemoteFacade();			
			Naming.rebind(name, remoteFacade);
			System.out.println(" * StravaServidor '" + name + "' started!!");
		} catch (Exception ex) {
			System.err.println(" # StravaServer Exception: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

}
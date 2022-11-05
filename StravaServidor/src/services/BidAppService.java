package services;

import java.rmi.RemoteException;

public class BidAppService {

	
	public float getUSDRate() {
		//TODO: Get conversion rate using Service Gateway
		return 0.85f;
	}

	public float getGBPRate() throws RemoteException {
		//TODO: Get conversion rate using Service Gateway
		return 1.17f;
	}
}

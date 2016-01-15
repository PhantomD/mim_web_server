import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Server implements GameServer {

	private Map<String, Integer> map = new HashMap<String, Integer>();
	private int pick = 13;


	@Override
	public boolean register(String name) throws RemoteException {
		// TODO Auto-generated method stub
		map.put(name, 13);
		return true;
	}

	@Override
	public int play(String name, int remainingStick) throws RemoteException,
			IllegalArgumentException {

		if (remainingStick == -1) {

			return -1;
		}

		pick = (int) ((int) pick - ((Math.random() * Math
				.min(3, remainingStick)) + 1));
		
		System.out.println("CPU a pris " + pick + " bâtons !");
		map.put(name, pick);

		return pick;
	}

	public static void main(String args[]) throws RemoteException,
			UnknownHostException {

		Registry registry = LocateRegistry.createRegistry(1099); // Pramètre n°
																	// de port
		System.setProperty("java.rmi.server.hostname", Inet4Address.getLocalHost().getHostName());
		
		Server serveur = new Server();
		Remote stub = UnicastRemoteObject.exportObject(
				serveur, 1099); // Stub
		registry.rebind("Swag", stub);
	}

	@Override
	public int getPick() {
		// TODO Auto-generated method stub
		return pick;
	}
}

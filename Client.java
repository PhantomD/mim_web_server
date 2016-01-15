import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez choisir votre nom de joueur :");
		String name = sc.nextLine();
		System.out.println("Veuillez entrer l'adresse de votre serveur :");
		String addr = sc.nextLine();

		try {

			Registry registry = LocateRegistry.getRegistry(1099); // récupère le
																	// stub par
																	// le
																	// registre
			GameServer game = (GameServer) registry.lookup("Swag");

			game.register(name);

			while (game.getPick() > 0) {

				System.out.println("Nombre de bâtons restants :" +game.getPick());
				System.out.println("Veuillez entrer le nombre de bâtons à enlever :");
				String ent = sc.nextLine();

				if(game.getPick() == 0){
					
					System.out.println("You Win !");
					
				}
				game.play(name, game.getPick());
				
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
}

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GameServer extends Remote {
 /**
 * Enregistre le client avec son nom. Le serveur lui crée un jeu à 13 bâtons.
 * @param name le nom du client
 * @return true si le nom n'est pas déjà pris
 * @throws RemoteException si problème RMI
 */
 boolean register(String name) throws RemoteException;
 
 int getPick() throws RemoteException;
 /**
 * Le joueur name prends stick bâtons. 
 * Le serveur prends lui aussi prend des bâtons si il en reste.
 * @param name le nom du joueur
 * @param stick le nombre de bâton (entre 1 et 3)
 * @return Le nombre de bâtons restant après le coup du serveur. -1 si le serveur ne peut pas prendre de bâton (le joueur a perdu). 
 * @throws RemoteException si problème RMI
 * @throws IllegalArgumentException si joueur name n'existe pas ou si le nombre de bâton est incorrect 
 */
 int play(String name, int stick) throws RemoteException, IllegalArgumentException; 
}
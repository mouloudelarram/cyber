import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;

public class P2 {
    public static void main(String[] strArr) {
        try {
            SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(12345);
            System.out.println("Serveur SSL en attente de connexions...");

            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    String message = reader.readLine();
                    System.out.println("Message reçu: " + message);
                    reader.close();
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Erreur lors de l'acceptation de la connexion ou de la lecture des données : " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur du serveur : " + e.getMessage());
        }
    }
}

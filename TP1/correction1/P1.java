import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.security.cert.X509Certificate;

public class P1 {
    public static void main(String[] strArr) {
        try {
            // Initialisation de SSLContext pour ignorer les erreurs de certificat
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{
                    new X509TrustManager() {
                        public X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }
                        public void checkClientTrusted(X509Certificate[] certs, String authType) {
                        }
                        public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        }
                    }
            }, new java.security.SecureRandom());

            // Créer un SSLSocket pour se connecter au serveur sécurisé
            SSLSocketFactory factory = sslContext.getSocketFactory();
            SSLSocket sslSocket = (SSLSocket) factory.createSocket("127.0.0.1", 12345);

            // Envoi de données chiffrées au serveur
            OutputStream outputStream = sslSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            writer.println("2cb4b1431b84ec15d35ed83bb927e27e8967d75f4bcd9cc4b25c8d879ae23e18");
            System.out.println("Message envoyé");

            // Fermeture de la connexion
            writer.close();
            outputStream.close();
            sslSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

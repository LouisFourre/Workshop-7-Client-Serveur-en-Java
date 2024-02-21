import java.io.*;
import java.net.*;

public class ClientSimple {
    public static void main(String[] args) {
        String adresseServeur = "localhost";
        int port = 12345;
        try (Socket socket = new Socket(adresseServeur, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String messageDuServeur = in.readLine();
            System.out.println("Message reçu du serveur : " + messageDuServeur);
        } catch (UnknownHostException e) {
            System.err.println("Serveur inconnu : " + adresseServeur);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Erreur lors de la connexion au serveur : " + adresseServeur);
            e.printStackTrace();
        }
    }
}
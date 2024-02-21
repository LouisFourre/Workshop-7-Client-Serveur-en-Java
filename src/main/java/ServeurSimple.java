import java.io.*;
import java.net.*;

public class ServeurSimple {
    public static void main(String[] args) throws IOException {
        int port = 12345; // Port d'écoute du serveur
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Serveur démarré, en attente de connexion...");
            try (Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                System.out.println("Client connecté");
                out.println("Bonjour Client");
            }
        } catch (IOException e) {
            System.out.println("Exception lors de l'écoute sur le port " + port);
            System.out.println(e.getMessage());
        }
    }
}
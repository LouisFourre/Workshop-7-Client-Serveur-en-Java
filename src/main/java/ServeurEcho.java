import java.io.*;
import java.net.*;

public class ServeurEcho {
    public static void main(String[] args) throws IOException {
        int port = 3132;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Serveur Echo démarré sur le port " + port);

            try (Socket clientSocket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    if(inputLine.equals("quit")){
                        out.write("Fin de la communication.");
                        return;
                    }
                    System.out.println("Message reçu du client : " + inputLine);
                    out.write(inputLine.toUpperCase() + "\n");
                    out.flush();
                }
            }catch (UnknownHostException e) {
                System.err.println("prob");
                e.printStackTrace();
            }
        }
    }
}

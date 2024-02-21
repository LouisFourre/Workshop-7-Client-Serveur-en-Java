import java.io.*;
import java.net.*;

public class ClientEcho {
    public static void main(String[] args) {
        String hostName = "localhost";
        int port = 3132;
        try (Socket echoSocket = new Socket(hostName, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
             PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("Message du serveur : " + in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package client;


import java.io.Console;
import java.io.IOException;
import java.net.Socket;
import server.Constants;
import server.NetworkIO;

public class ClientSession {
    private final Socket socket;

    public ClientSession(Socket socket) {
        this.socket = socket;
    }

    public void session() throws IOException {

        // Get line from console
        boolean quit = false;
        Console cons = System.console();
        NetworkIO nio = new NetworkIO(socket);
        String output = "";

        while (!quit) {
            output = cons.readLine("Send message to server: ");
            
            quit = output.trim().toLowerCase().equals(Constants.QUIT);
            nio.write(output);
            if (quit) 
            continue;
            
            String input = nio.read();
            System.out.printf(">>>>SERVER SAYS: %s\n", input);
        }

        System.out.printf("Closing connection...");
        nio.close();
    }
}

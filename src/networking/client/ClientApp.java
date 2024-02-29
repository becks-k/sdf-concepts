package client;

import java.net.Socket;

public class ClientApp {

    public static void main(String[] args) {

        String hostName = "";
        int portNo = 0;

        if (args.length > 0) {
            String[] connInfo = args[0].split(":");
            hostName = connInfo[0];
            portNo = Integer.parseInt(connInfo[1]);
        }

        // Establish client connection
        try (Socket clientSock = new Socket(hostName, portNo)) {
            System.out.printf("Successfully connected to server.\n");
            ClientSession cs = new ClientSession(clientSock);
            cs.session();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

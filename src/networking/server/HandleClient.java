package server;

import java.net.Socket;

public class HandleClient implements Runnable {
    private Socket socket;
    private LogSession logger;

    public HandleClient(Socket socket, LogSession logger) {
        this.socket = socket;
        this.logger = logger;
    }

    public void process() throws Exception{
        NetworkIO nio = new NetworkIO(socket);
        String input = "";
        logger.log("Client info: %s".formatted(socket.getInetAddress().toString()));

        boolean quit = false;
        while (!quit) {
            
            // Server reads input from client
            input = nio.read();

            quit = input.trim().toLowerCase().equals(Constants.QUIT);
            System.out.println(quit);
            if (quit)
                continue;
            
            if (Constants.FLUSH.equals(input.trim().toLowerCase())) {
                System.out.println(input);
                logger.flush();
                nio.write(input.toUpperCase() + "ED");
                continue;
            }

            System.out.printf(">>>CLIENT SAYS: %s\n", input);
            logger.log(input);

            // Server writes output to client
            nio.write(input.toUpperCase());

        }

        System.out.printf("Client aborted connection. Closing server connection...\n");
        nio.close();
    }

    // for multi-threading
    @Override
    public void run() {
        try {
            process();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

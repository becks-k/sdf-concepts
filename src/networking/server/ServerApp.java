package server;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerApp {
    public static void main(String[] args) throws Exception {

        // args to contain portNo noThreads
        int port = 0;
        int noThreads = 0;

        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
            noThreads = Integer.parseInt(args[1]);
        }

        OutputStream os = new FileOutputStream("log.txt");
        LogSession logger = new LogSession(os);

        ExecutorService threadPool = Executors.newFixedThreadPool(noThreads);
        System.out.printf("Main thread: %s\n", Thread.currentThread().getName());

        System.out.printf("Starting server on port %d\n", port);
        // Create server socket
        try (ServerSocket server = new ServerSocket(port)) {

            // Accept client connection
            // Server never closes, always ready to accept connection
            while (true) {
                System.out.printf("Waiting for client connection...\n");
                Socket socket = server.accept();
                System.out.printf("Successfully connected to a client...\n");

                HandleClient handler = new HandleClient(socket, logger);
                threadPool.execute(new Supervisor(threadPool, 1000)); //threads - main, supervisor, client
                threadPool.submit(handler);
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            logger.close();
        }

    }
}

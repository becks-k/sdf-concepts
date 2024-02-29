package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class NetworkIO {
    
    private InputStream is;
    private DataInputStream dis;
    private OutputStream os;
    private DataOutputStream dos;

    //establish input/output streams; data transmitted in bytes
    public NetworkIO (Socket socket) throws IOException{
        is = socket.getInputStream(); 
        dis = new DataInputStream(is);
        os = socket.getOutputStream(); 
        dos = new DataOutputStream(os);
    }
    

    public String read() throws IOException {
        return dis.readUTF(); //returns a string //writes to console
    }

    public void write(String input) throws IOException {
        dos.writeUTF(input); //returns void //sends input out
        dos.flush();
    }

    //close sockets in sequential order
    public void close() {
        try {
            dis.close();
            is.close();
            dos.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}

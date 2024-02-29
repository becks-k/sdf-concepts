package server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;

// To log date and input from client 
public class LogSession {

    private Writer writer;
    private BufferedWriter bw;

    // if LogSession is changed to accept OutputStream os, log session class can
    // effectively become a server as it accepts an output stream
    public LogSession(OutputStream os) throws IOException {
        writer = new OutputStreamWriter(os);
        bw = new BufferedWriter(writer);
    }

    public void log(String line) throws IOException {
        Date timestamp = new Date();
        bw.write(String.format("[%s]: %s\n", timestamp, line));

    }

    public void flush() throws Exception {
        bw.flush();
        writer.flush();
    }

    public void close() throws IOException {
        bw.flush();
        bw.close();
        writer.flush();
        writer.close();
    }
}

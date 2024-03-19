package org.example;

import java.io.*;
import java.net.*;

public class PeerSocket {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public PeerSocket(String hostName, int portNumber) throws IOException {
        this.socket = new Socket(hostName, portNumber);
        this.out = new PrintWriter(socket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public PrintWriter getPrintWriter() {
        return out;
    }

    public BufferedReader getBufferedReader() {
        return in;
    }

    public void close() throws IOException {
        out.close();
        in.close();
        socket.close();
    }
}
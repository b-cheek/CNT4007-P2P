package org.example;

import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;

public class PeerSocket {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    String message;
    String MESSAGE;

    public PeerSocket(String hostName, int portNumber) throws IOException {
        this.socket = new Socket(hostName, portNumber);
        this.out = new PrintWriter(socket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        BufferedReader buffRead = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            System.out.print("Hello, please input a sentence: ");
            //read a sentence from the standard input
            message = buffRead.readLine();
            //Send the sentence to the server
            sendMessage(message);
            //Receive the upperCase sentence from the server
            MESSAGE = (String)buffRead.readLine();
            //show the message to the user
            System.out.println("Client Receive message: " + MESSAGE);

        }

    }


    public PrintWriter getPrintWriter() {
        return out;
    }

    public BufferedReader getBufferedReader() {
        return in;
    }

    void sendMessage(String msg)
    {
        //stream write the message
        out.write(msg);
        out.flush();
    }



    public void close() throws IOException {
        out.close();
        in.close();
        socket.close();
    }

}
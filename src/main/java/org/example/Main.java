package org.example;

public class Main {
    public static void main(String[] args) {
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try {
            PeerSocket peer0 = new PeerSocket(hostName, portNumber);
            PeerSocket peer1 = new PeerSocket(hostName, portNumber + 1);
        }
        catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
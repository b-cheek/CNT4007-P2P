package org.example;

public class Main {
    public static void main(String[] args) {
        //String hostName = args[0];
        //int portNumber = Integer.parseInt(args[1]);
        PeerInfo peer = new PeerInfo("1001","localhost",8000);
        try {
            PeerSocket peer0 = new PeerSocket(peer.peerAddress, peer.peerPort);
            peer0.sendMessage(args[0]);
            //server0.sendMessage();
        }
        catch (java.io.IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
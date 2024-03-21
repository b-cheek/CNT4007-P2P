package org.example;

public class Peer {
    private int peerID;
    private Server server;
    private Client client;

    public Peer(int peerID, int port) throws Exception {
        this.peerID = peerID;
        this.server = new Server(port);
        this.server.start();
    }
    public void connect(String host, int port) {
        this.client = new Client(host, port, this.peerID);
        client.start();
        try {
            client.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void close() {
        try {
            this.server.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

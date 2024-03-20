package org.example;

public class Peer {
    private Server server;
    private Client client;

    public Peer(int port) throws Exception {
        this.server = new Server(port);
        this.server.start();
    }
    public void connect(String host, int port) {
        this.client = new Client(host, port);
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

package org.example;

public class Peer {
    /*
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
    */

    private int peerID;
    private String hostName;
    private int port;
    private boolean hasFile;

    public Peer(int peerID, String hostName, int port, boolean hasFile) {
        this.peerID = peerID;
        this.hostName = hostName;
        this.port = port;
        this.hasFile = hasFile;
    }

    public int getPeerID() {
        return peerID;
    }

    public String getHostName() {
        return hostName;
    }

    public int getPort() {
        return port;
    }

    public boolean hasFile() {
        return hasFile;
    }

    public String printPeer() {
        return "Peer{" +
                "peerID=" + peerID +
                ", hostName='" + hostName + '\'' +
                ", port=" + port +
                ", hasFile=" + hasFile +
                '}';
    }
}

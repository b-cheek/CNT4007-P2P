package org.example;

public class PeerInfo {
    public String peerId;
    public String peerAddress;
    public int peerPort;

    public PeerInfo(String pId, String pAddress, int pPort) {
        peerId = pId;
        peerAddress = pAddress;
        peerPort = pPort;
    }

    public String getPeerAddress() {
        return peerAddress;
    }

    public String getPeerId() {
        return peerId;
    }


    public int getPeerPort() {
        return peerPort;
    }


    public void setHost(String peerAddress) {
        this.peerAddress = peerAddress;
    }


    public void setPeerId(String peerId) {
        this.peerId = peerId;
    }

    public void setPort(int peerPort) {
        this.peerPort = peerPort;
    }
}
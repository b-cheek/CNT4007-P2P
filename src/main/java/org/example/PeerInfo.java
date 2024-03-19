package org.example;

public class PeerInfo {
    public String peerId;
    public String peerAddress;
    public String peerPort;

    public PeerInfo(String pId, String pAddress, String pPort) {
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


    public String getPeerPort() {
        return peerPort;
    }


    public void setHost(String peerAddress) {
        this.peerAddress = peerAddress;
    }


    public void setPeerId(String peerId) {
        this.peerId = peerId;
    }

    public void setPort(String peerPort) {
        this.peerPort = peerPort;
    }
}
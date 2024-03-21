package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            Peer peer0 = new Peer(1000, 8000);
            Thread.sleep(5000);
            peer0.connect("localhost", 9000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
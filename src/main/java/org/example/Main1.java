package org.example;

public class Main1 {
    public static void main(String[] args) {
        try { 
            Peer peer1 = new Peer(1001, 9000);
            peer1.connect("localhost", 8000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

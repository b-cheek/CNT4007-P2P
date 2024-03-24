package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Config {
    public Map<String, String> common = new HashMap<>();
    public List<Peer> peerInfoList = new ArrayList<>();

    public Config(String path) throws IOException {
        // Read Common.cfg
        BufferedReader br = new BufferedReader(new FileReader(path + "/Common.cfg"));
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(" ");
            common.put(parts[0], parts[1]);
        }
        br.close();

        // Read PeerInfo.cfg
        br = new BufferedReader(new FileReader(path + "/PeerInfo.cfg"));

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(" ");
            int peerID = Integer.parseInt(parts[0]);
            String hostName = parts[1];
            int port = Integer.parseInt(parts[2]);
            boolean hasFile = parts[3].equals("1");
            peerInfoList.add(new Peer(peerID, hostName, port, hasFile));
        }
        br.close();
    }

    public void printConfig() {
        System.out.println("Common Configuration:");
        for (Map.Entry<String, String> entry : common.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nPeer Information:");
        for (Peer peer : peerInfoList) {
            System.out.println(peer.printPeer());
        }
    }
}
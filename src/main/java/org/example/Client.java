package org.example;

import java.net.*;
import java.io.*;

public class Client extends Thread {
	Socket requestSocket;           //socket connect to the server
	ObjectOutputStream out;         //stream write to the socket
 	ObjectInputStream in;          //stream read from the socket
	String message;                //message send to the server
	String MESSAGE;                //capitalized message read from the server
	private String host;
	private int port;
	private int peerID;

	public Client(String host, int port, int peerID) {
		this.host = host;
		this.port = port;
	}

	public void run()
	{
		try{
			//create a socket to connect to the server
			requestSocket = new Socket(this.host, this.port);
			System.out.printf("Connected to %s on port %d%n", host, port);
			//initialize inputStream and outputStream
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(requestSocket.getInputStream());
			
			//get Input from standard input
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				System.out.print("Hello, please input a sentence: ");
				//read a sentence from the standard input
				message = bufferedReader.readLine();
				if (message.equalsIgnoreCase("close")) {
					break;
				}
				//Send the sentence to the server
				sendMessage(message);
				//Receive the upperCase sentence from the server
				MESSAGE = (String)in.readObject();
				//show the message to the user
				System.out.println("Receive message: " + MESSAGE);
			}
		}
		catch (ConnectException e) {
    			System.err.println("Connection refused. You need to initiate a server first.");
		} 
		catch ( ClassNotFoundException e ) {
            		System.err.println("Class not found");
        	} 
		catch(UnknownHostException unknownHost){
			System.err.println("You are trying to connect to an unknown host!");
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		finally{
			//Close connections
			try{
				in.close();
				out.close();
				requestSocket.close();
				System.out.printf("Connection to %s on port %d closed%n", this.host, this.port);
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
	}
	//send a message to the output stream
	void sendMessage(String msg)
	{
		try{
			//stream write the message
			out.writeObject(msg);
			out.flush();
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}

	void sendHandshake() {
		try {
			out.writeBytes("P2PFILESHARINGPRROJ");
			out.write(new byte[10]);
			out.writeInt(this.peerID);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}

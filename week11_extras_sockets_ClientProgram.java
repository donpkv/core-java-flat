package sockets;

import java.net.*;              //Start of Sockect Program As Client
        import java.io.*;
public class ClientProgram
{// initialize socket and input output streams
    private Socket socket		 = null;
    private DataInputStream input = null;
    private DataOutputStream out	 = null;// constructor to put ip address and port
    public ClientProgram(String address, int port) {// establish a connection
        try {
            socket = new Socket(address, port);
            System.out.println("Connection accepted by Server");
            // takes input from terminal
            input = new DataInputStream(System.in);
            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u){
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }// string to read message from input
        String line = "";// keep reading until "Over" is input
        while (!line.equals("Over"))
        {  try{
            //line = input.readUTF();
            line = input.readLine();
            out.writeUTF(line);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
        }

            try {
                input.close(); // close the connection
                out.close();
                socket.close();
            } catch (IOException i) {
                System.out.println(i);
            }

    }
    public static void main(String args[]){
        ClientProgram client = new ClientProgram("127.0.0.1", 5000);
    }
}


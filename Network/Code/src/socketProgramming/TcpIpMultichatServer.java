package socketProgramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class TcpIpMultichatServer {
    HashMap clients;

    public TcpIpMultichatServer() {
        clients = new HashMap();
        Collections.synchronizedMap(clients);
    }

    public static void main(String[] args) {
        new TcpIpMultichatServer().start();
    }

    public void start() {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(7777);
            System.out.println("Server Start");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]"+"Connect");
                ServerReceiver thread = new ServerReceiver(socket);
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void sendToAll(String msg) {
        Iterator it = clients.keySet().iterator();

        while (it.hasNext()) {
            try {
                DataOutputStream out = (DataOutputStream) clients.get(it.next());
                out.writeUTF(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class ServerReceiver extends Thread {
        Socket socket;
        DataInputStream in;
        DataOutputStream out;

        ServerReceiver(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String name = "";
            try {
                name = in.readUTF();
                sendToAll("#"+name+" is in");
                clients.put(name, out);
                System.out.println("Num: "+clients.size());
                while (in!=null) {
                    sendToAll(in.readUTF());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                sendToAll("#"+name+" is out");
                clients.remove(name);
                System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]"+"exit");
                System.out.println("Num: "+clients.size());
            }
        }
    }
}


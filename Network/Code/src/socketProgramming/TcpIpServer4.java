package socketProgramming;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer4 implements Runnable {
    ServerSocket serverSocket;
    Thread[] threadArr;

    public static void main(String[] args) {
        TcpIpServer4 server = new TcpIpServer4(5);
        server.start();
    }

    public TcpIpServer4(int num) {
        try {
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime()+"Server Ready");

            threadArr = new Thread[num];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        for(int i=0; i<threadArr.length; i++) {
            threadArr[i] = new Thread(this);
            threadArr[i].start();
        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                System.out.println(getTime()+"Waiting Connect");
                Socket socket = serverSocket.accept();
                System.out.println(getTime()+socket.getInetAddress()+" is connect accpet");

                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                dos.writeUTF("[Notice] Test Message from Server");
                System.out.println(getTime()+"Send Message");

                dos.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static String getTime() {
        String name = Thread.currentThread().getName();
        SimpleDateFormat df = new SimpleDateFormat("[hh:mm:ss]");
        return df.format(new Date()) + name;
    }
}

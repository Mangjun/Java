package socketProgramming;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer3 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(7777);
            System.out.println(getTime()+"Server Ready");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                System.out.println(getTime()+"Waiting Connect...");

                serverSocket.setSoTimeout(5*1000);
                Socket socket = serverSocket.accept();
                System.out.println(getTime()+socket.getInetAddress()+" is connect accpet");

                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                dos.writeUTF("[Notice] Test Message from Server");
                System.out.println(getTime()+"Send Message");

                dos.close();
                socket.close();
            } catch (SocketTimeoutException e) {
                System.out.println("Server Timeout Ending");
                System.exit(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static String getTime() {
        SimpleDateFormat df = new SimpleDateFormat("[hh:mm:ss]");
        return df.format(new Date());
    }
}

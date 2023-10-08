package socketProgramming;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;

public class TcpIpClient {
    public static void main(String[] args) {
        try {
            String serverIp = "127.0.0.1";

            System.out.println("Connecting Server... ServerIP: "+serverIp);
            Socket socket = new Socket(serverIp, 7777);

            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);

            System.out.println("Message: "+dis.readUTF());
            System.out.println("Ending Connect...");

            dis.close();
            socket.close();
            System.out.println("End Connect");
        } catch (ConnectException ce) {
            ce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

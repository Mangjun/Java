package network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class NetworkEx1 {
    public static void main(String[] args) {
        InetAddress ip = null;
        InetAddress[] ipArr = null;

        try {
            ip = InetAddress.getByName("www.naver.com");
            System.out.println("Host Name: "+ip.getHostName());
            System.out.println("Host Address: "+ip.getHostAddress());
            System.out.println("Host: "+ip.toString());

            byte[] ipAddr = ip.getAddress();
            System.out.println("IP: "+Arrays.toString(ipAddr));

            String result = "";
            for(int i=0;i<ipAddr.length; i++) {
                result += (ipAddr[i]<0) ? ipAddr[i]+256 : ipAddr[i];
                result += ".";
            }
            System.out.println(result);
            System.out.println();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            ip = InetAddress.getLocalHost();
            System.out.println("Host Name: "+ip.getHostName());
            System.out.println("Host Address: "+ip.getHostAddress());
            System.out.println();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            ipArr = InetAddress.getAllByName("www.naver.com");

            for(int i=0; i< ipArr.length; i++) {
                System.out.println("ipArr["+i+"]: "+ipArr[i]);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

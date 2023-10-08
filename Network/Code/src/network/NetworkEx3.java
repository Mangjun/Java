package network;

import java.net.URL;
import java.net.URLConnection;

public class NetworkEx3 {
    public static void main(String[] args) {
        URL url = null;
        String address = "http://www.naver.com";

        try {
            url = new URL(address);
            URLConnection conn = url.openConnection();

            System.out.println("conn: "+conn.toString());
            System.out.println("AllowUserInteraction: "+conn.getAllowUserInteraction());
            System.out.println("ConnectTimeout: "+conn.getConnectTimeout());
            System.out.println("Content: "+conn.getContent());
            System.out.println("Content Encoding: "+conn.getContentEncoding());
            System.out.println("Content Length: "+conn.getContentLength());
            System.out.println("Content Type: "+conn.getContentType());
            System.out.println("Date: "+conn.getDate());
            System.out.println("Default AllowUserInteraction: "+ URLConnection.getDefaultAllowUserInteraction());
            System.out.println("Default UseCaches: "+conn.getDefaultUseCaches());
            System.out.println("DoInput: "+conn.getDoInput());
            System.out.println("DoOutput: "+conn.getDoOutput());
            System.out.println("Expiration: "+conn.getExpiration());
            System.out.println("Header Field: "+conn.getHeaderFields());
            System.out.println("IfModifiedSince: "+conn.getIfModifiedSince());
            System.out.println("LastModified: "+conn.getLastModified());
            System.out.println("ReadTimeout: "+conn.getReadTimeout());
            System.out.println("URL: "+conn.getURL());
            System.out.println("UseCaches: "+conn.getUseCaches());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

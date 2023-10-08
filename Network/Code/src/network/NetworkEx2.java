package network;

import java.net.MalformedURLException;
import java.net.URL;

public class NetworkEx2 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://naver.com");
        System.out.println("url: "+url.getAuthority());
        System.out.println("url Content: "+url.getContent());
        System.out.println("url Default Port: "+url.getDefaultPort());
        System.out.println("url Port: "+url.getPort());
        System.out.println("url File: "+url.getFile());
        System.out.println("url Host: "+url.getHost());
        System.out.println("url Path: "+url.getPath());
        System.out.println("url Protocol: "+url.getProtocol());
        System.out.println("url Query: "+url.getQuery());
        System.out.println("url Ref: "+url.getRef());
        System.out.println("url UserInfo: "+url.getUserInfo());
        System.out.println("url ExternalForm: "+url.toExternalForm());
        System.out.println("uri: "+url.toURI());
    }
}

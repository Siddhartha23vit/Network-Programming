import java.net.URL;
import java.net.MalformedURLException;

public class URLDemo {
    public static void main(String[] args) {
        try {
            // Creating a URL object
            URL url = new URL("https://www.youtube.com/watch?v=FhOumaSI_DI&list=PLwLSw1_eDZl22NzEffbakJYVXiiWas9KH");

            // Methods of URL class
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("File: " + url.getFile());
            System.out.println("Query: " + url.getQuery());
            System.out.println("Authority: " + url.getAuthority());
            System.out.println("UserInfo: " + url.getUserInfo());
            System.out.println("Ref: " + url.getRef());
            System.out.println("Default Port: " + url.getDefaultPort());
     

        
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

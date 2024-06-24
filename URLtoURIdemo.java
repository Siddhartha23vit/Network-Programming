import java.net.URI;
import java.net.URL;
import java.net.MalformedURLException;

public class URLtoURIdemo {
    public static void main(String[] args) {
        try {
           
            URL url = new URL("https://www.youtube.com/watch?v=FhOumaSI_DI&list=PLwLSw1_eDZl22NzEffbakJYVXiiWas9KH");

            URI uri = url.toURI();

      
            System.out.println("URI: " + uri);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

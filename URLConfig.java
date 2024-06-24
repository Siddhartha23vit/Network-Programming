import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLConfig {
    public static void main(String[] args) {
        String urlString = "https://www.freecodecamp.org/news/cloud-storage-options/";

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

       
            printConnectionConfigurations(connection);

       
            connection.setDoInput(false); 
            connection.setDoOutput(true);
            connection.setAllowUserInteraction(true); 
            connection.setUseCaches(false);
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(2000);

           
            System.out.println("\nConnection configurations after setting:");
            printConnectionConfigurations(connection);

           
            connection.connect();

            
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void printConnectionConfigurations(HttpURLConnection connection) {
        System.out.println("Allow User Interaction: " + connection.getAllowUserInteraction());
        System.out.println("Do Input: " + connection.getDoInput());
        System.out.println("Do Output: " + connection.getDoOutput());
        System.out.println("Use Caches: " + connection.getUseCaches());
        System.out.println("Connection Timeout: " + connection.getConnectTimeout() + " milliseconds");
        System.out.println("Read Timeout: " + connection.getReadTimeout() + " milliseconds");
    }
}

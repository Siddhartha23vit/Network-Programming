import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlConnection {
    public static void main(String[] args) {
        try {
          
            URL url = new URL("https://asuratoon.com/3370734378-the-nebulas-civilization-chapter-2/");

  
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            
            connection.setRequestMethod("GET");

           
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");

           
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);


            String responseMessage = connection.getResponseMessage();
            System.out.println("Response Message: " + responseMessage);


            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

         
            System.out.println("Response Body:");
            System.out.println(response.toString());

          
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

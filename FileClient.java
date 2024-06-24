import java.io.*;
import java.net.*;

public class FileClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);
            BufferedReader fileReader = new BufferedReader(new FileReader("clientstory.txt"));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
            
            String line;
            StringBuilder last500Chars = new StringBuilder();
            while ((line = fileReader.readLine()) != null) {
                if (line.length() > 500) {
                    last500Chars.append(line.substring(line.length() - 500));
                } else {
                    last500Chars.append(line);
                }
            }
            fileReader.close();

            // Send the last 500 characters to the server
            out.println(last500Chars.toString());
            System.out.println("Sent data to server: " + last500Chars.toString());

            String convertedData = in.readLine();
            System.out.println("Received converted data from server: " + convertedData);

            // Close connections
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

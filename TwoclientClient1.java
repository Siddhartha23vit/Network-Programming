import java.io.*;
import java.net.*;

public class TwoclientClient1 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345); // Connect to the server running on localhost at port 12345

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverResponse = in.readLine(); // Read the server's response
            System.out.println("Server response to Client 1: " + serverResponse);

            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) throws UnknownHostException {
       
        
        try {
            Socket socket = new Socket("localhost", 8080);
            
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            System.out.print("Enter message: ");
            String message = userInput.readLine();
            out.println(message);
            
            String response = in.readLine();
            System.out.println("Server response: " + response);
            
            userInput.close();
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

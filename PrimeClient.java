import java.io.*;
import java.net.*;

public class PrimeClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 7782);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Request for prime number");
            String response = in.readLine();
            System.out.println("Largest prime number received from server: " + response);

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class SSLServer {
    private static final int PORT = 8632; 

    public static void main(String[] args) {
        try {
            SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(PORT);

            
            System.out.println("Server is running on port " + PORT + "...");
            
            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("New connection from: " + clientSocket.getInetAddress().getHostAddress());
                
            
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

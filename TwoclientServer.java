import java.io.*;
import java.net.*;
import java.util.Date;

public class TwoclientServer{
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345); 
            System.out.println("Server is running and waiting for clients...");

            int clientCount = 0;

            while (clientCount < 2) { 
                Socket clientSocket = serverSocket.accept(); 
                clientCount++;
                System.out.println("Client " + clientCount + " connected: " + clientSocket);

                // Create a new thread to handle the client
                ClientHandler handler = new ClientHandler(clientSocket, clientCount);
                handler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket clientSocket;
    private int clientNumber;

    public ClientHandler(Socket socket, int clientNumber) {
        this.clientSocket = socket;
        this.clientNumber = clientNumber;
    }

    public void run() {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Hello Client " + clientNumber + ", the server time is: " + new Date().toString()); // Send current time to the client
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

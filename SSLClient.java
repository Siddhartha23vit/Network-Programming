import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class SSLClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8632;
    
    public static void main(String[] args) {
        try {
            // Without Socket Options
            Socket socketWithoutOptions = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Connection without socket options established.");

            // With Socket Options
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socketWithOptions = (SSLSocket) factory.createSocket(SERVER_ADDRESS, SERVER_PORT);
            
            // Set socket options
            socketWithOptions.setTcpNoDelay(true); // Disable Nagle's algorithm
            socketWithOptions.setSoTimeout(5000); // Set timeout to 5 seconds
            socketWithOptions.setSoLinger(true, 10); // Linger for 10 seconds
            socketWithOptions.setSendBufferSize(8192); // Set send buffer size
            socketWithOptions.setReceiveBufferSize(8192); // Set receive buffer size
            socketWithOptions.setKeepAlive(true); // Enable TCP keep-alive
         
            socketWithOptions.setTrafficClass(0x10); // Set IP TOS (Type of Service) to minimize delay
            
            System.out.println("Connection with socket options established.");
            
    
            socketWithoutOptions.close();
            socketWithOptions.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

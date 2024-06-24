import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {

    public static void main(String[] args) {
        try {
           
            Socket socket = new Socket(InetAddress.getLocalHost(), 12345); 
            System.out.println("Connected to server.");

          
            socket.setTcpNoDelay(true); 
            socket.setSoTimeout(5000); 
            socket.setKeepAlive(true); 
            socket.setOOBInline(true); 
            socket.setSendBufferSize(8192); 
            socket.setReceiveBufferSize(8192); 
            socket.setSoLinger(true, 10); 
            socket.setTrafficClass(0x10); 

           
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            writer.println("Hello from client!");

           
            writer.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.io.*;
import java.net.*;
import java.util.concurrent.atomic.AtomicLong;

class PrimeServerThread extends Thread {
    private Socket clientSocket;
    private static AtomicLong largestPrime = new AtomicLong();

    public PrimeServerThread(Socket socket) {
        this.clientSocket = socket;
    }

    public static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public static synchronized long getLargestPrime() {
        return largestPrime.get();
    }

    public void run() {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    
            long candidate = 999999999999999999L; // 18 nines
            while (true) {
                if (isPrime(candidate)) {
                    out.println(candidate); // Send the prime number to the client
                    break;
                }
                candidate--;
            }
    
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7782);
        System.out.println("Server listening on port 7782...");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            new PrimeServerThread(clientSocket).start();
        }
    }
}

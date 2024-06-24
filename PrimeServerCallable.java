import java.io.*;
import java.net.*;
import java.util.concurrent.*;

class PrimeServerCallable implements Callable<Long> {
    private Socket clientSocket;

    public PrimeServerCallable(Socket socket) {
        this.clientSocket = socket;
    }

    public boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public Long call() throws Exception {
        long candidate = 999999999999999999L; // 18 nines
        while (true) {
            if (isPrime(candidate)) {
                return candidate;
            }
            candidate--;
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7782);
        System.out.println("Server listening on port 7782...");
        ExecutorService executor = Executors.newCachedThreadPool();

        while (true) {
            Socket clientSocket = serverSocket.accept();
            Future<Long> future = executor.submit(new PrimeServerCallable(clientSocket));
            try {
                long result = future.get();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println(result);
                out.close();
                clientSocket.close();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}

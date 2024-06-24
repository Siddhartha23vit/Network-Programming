import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileReadRepeat {
    public static void main(String[] args) {
        try (InputStream in = new FileInputStream("reader.txt")) {
            if (!in.markSupported()) {
                System.out.println("Mark/reset not supported.");
                return;
            }

            for (int i = 0; i < 10; i++) {
                in.mark(30); // Mark the position

                // Read characters from position 10 to 30
                for (int j = 0; j < 20; j++) {
                    int data = in.read();
                    if (data == -1) {
                        // End of file
                        break;
                    }
                    System.out.print((char) data);
                }

                // Reset to the marked position
                in.reset();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

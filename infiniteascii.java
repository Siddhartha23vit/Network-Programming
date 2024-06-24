import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class infiniteascii {

    public static void main(String[] args) throws IOException {
        int charsPerLine = 72;

        // Create output stream for the file
        try (OutputStream outputStream = new FileOutputStream("infinite.txt")) {
            System.out.println("Writing using write(int):");

            while (true) {
                for (int i = 0; i < charsPerLine; i++) {
                    int startChar = 34 + i;

                    int endChar = startChar + charsPerLine - 1;

                    // Ensure endChar is capped at 126
                    if (endChar > 126) {
                        endChar = 126;
                    }

                    for (int j = startChar; j <= endChar; j++) {
                        outputStream.write(j);
                    }

                    // Write new line character
                    outputStream.write(10);

                    // Check if the line is printed, and terminate if true
                    if (endChar >= 126) {
                        break;
                    }
                }
              
            }
        }
    }
}

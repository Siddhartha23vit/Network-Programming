import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class asbyte{

    public static void main(String[] args) throws IOException {
        int charsPerLine = 72;
        int end = 200;
        int start = 0;

        // Create output stream for the file
        try (OutputStream outputStream = new FileOutputStream("bytewrite.txt")) {
            System.out.println("Writing using write(byte[]):");

            while (start <= end) {
                byte[] lineBytes = generateLineBytes(start, charsPerLine);

                // Write the entire line to the output stream
                outputStream.write(lineBytes);

                // Write new line character
                outputStream.write(10);

                start++;
            }
        }
    }

    private static byte[] generateLineBytes(int start, int charsPerLine) {
        byte[] lineBytes = new byte[charsPerLine + 1]; // buffer for characters + new line character
        for (int i = 0; i < charsPerLine; i++) {
            int currentChar = 34 + start + i;

            // Ensure currentChar is capped at 126
            if (currentChar > 126) {
                currentChar = 126;
            }

            lineBytes[i] = (byte) currentChar;
        }

        // Write new line character
        lineBytes[charsPerLine] = 10;

        return lineBytes;
    }
}

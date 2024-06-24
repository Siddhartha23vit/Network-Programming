import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Asint {

    public static void main(String[] args) throws IOException {
        int charsPerLine = 72;
        int end = 200;
        int start = 0;

        try (OutputStream outputStream = new FileOutputStream("intwrite.txt")) {
            System.out.println("Writing using write(int):");

            while (start <= end) {
                for (int i = 0; i < charsPerLine; i++) {
                    int startChar = 34 + i;

                    int endChar = startChar + charsPerLine - 1;

                    if (endChar > 126) {
                        endChar = 126;
                    }

                    for (int j = startChar; j <= endChar; j++) {
                        outputStream.write(j);
                    }

                   
                    outputStream.write(10);

                    
                    if (endChar >= 126) {
                        break;
                    }
                }
                start++;
            }
        }
    }
}

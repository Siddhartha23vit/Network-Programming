import java.io.FileReader;
import java.io.IOException;

public class CharCount {
    public static void main(String[] args) {
        String fileName = "reader.txt";

        try {
            int charCount = countCharacters(fileName);
            System.out.println("Number of characters in the file: " + charCount);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    private static int countCharacters(String fileName) throws IOException {
        try (FileReader reader = new FileReader(fileName)) {
            int charCount = 0;
            int charRead;
            
            while ((charRead = reader.read()) != -1) {
                charCount++;
            }

            return charCount;
        }
    }
}
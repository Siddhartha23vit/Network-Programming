import java.io.*;

public class FileManipulate {
    public static void main(String[] args) {
        // Specify the file name
        String fileName = "example.txt";

        // Write "hello" to the file
        writeFile(fileName, "hello");

        // Read and display the contents of the file
        String fileContents = readFile(fileName);
        System.out.println("File Contents: " + fileContents);

        // Find the number of characters in the file
        int charCount = countCharacters(fileContents);
        System.out.println("Number of Characters: " + charCount);

        // Search for a specific word and replace it
        String replacedContents = replaceWord(fileContents, "hello", "world");
        System.out.println("Replaced Contents: " + replacedContents);
    }

    // Method to write content to a file
    private static void writeFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("File created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read content from a file
    private static String readFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    // Method to count characters in a string
    private static int countCharacters(String text) {
        return text.length();
    }

    // Method to replace a specific word in a string
    private static String replaceWord(String text, String oldWord, String newWord) {
        return text.replaceAll(oldWord, newWord);
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWordReplace {
    public static void main(String[] args) {
        String fileName = "reader.txt";
        String oldWord = "Siddhartha";
        String newWord = "Sukhavasi";

        try {
            String content = readFromFile(fileName);
            String updatedContent = replaceWord(content, oldWord, newWord);
            writeToFile(fileName, updatedContent);
            System.out.println("Word replaced successfully in the file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error processing the file: " + e.getMessage());
        }
    }

    private static String readFromFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    private static String replaceWord(String content, String oldWord, String newWord) {
        return content.replaceAll(oldWord, newWord);
    }

    private static void writeToFile(String fileName, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        }
    }
}

